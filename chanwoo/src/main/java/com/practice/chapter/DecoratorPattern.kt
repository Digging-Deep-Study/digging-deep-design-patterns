package com.practice.chapter

import io.netty.bootstrap.ServerBootstrap
import io.netty.buffer.Unpooled
import io.netty.channel.*
import io.netty.channel.nio.NioIoHandler
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.http.*
import io.netty.handler.logging.LogLevel
import io.netty.handler.logging.LoggingHandler

fun main(args: Array<String>) {
    Server.run(8282) {
        contentType("text/plain") {
            authenticate {

            }
        }
    }
}

interface RequestDecorator {
    val contentType: String
    val authenticate: Boolean
}

class DefaultRequestDecorator : RequestDecorator {
    override val contentType: String = "application/json"
    override val authenticate: Boolean = true
}

class Routing {
    var decorator: RequestDecorator = DefaultRequestDecorator()
    private set

    var message = "Hello, World!"

    fun contentType(type: String, block: Routing.() -> Unit): RequestDecorator {
        return object : RequestDecorator {
            override val contentType: String = type
            override val authenticate: Boolean = decorator.authenticate

            init {
                block()
            }
        }.also {
            this.decorator = it
        }
    }

    fun authenticate(block: Routing.() -> Unit): RequestDecorator {
        return object : RequestDecorator {
            override val contentType: String = decorator.contentType
            override val authenticate: Boolean = true

            init {
                block()
            }
        }.also {
            this.decorator = it
        }
    }
}

class Server {
    companion object {
        fun run(port: Int = 8080, router: Routing.() -> RequestDecorator) {
            val bossGroup = MultiThreadIoEventLoopGroup(1, NioIoHandler.newFactory())
            val workerGroup = MultiThreadIoEventLoopGroup(NioIoHandler.newFactory())

            try {
                ServerBootstrap().apply {
                    group(bossGroup, workerGroup)
                    channel(NioServerSocketChannel::class.java)
                    handler(LoggingHandler(LogLevel.INFO))
                    childHandler(ServerInitializer(router))
                }.bind(port).sync().channel().also {
                    println("Server started on port $port")
                }.closeFuture().sync()
            } finally {
                bossGroup.shutdownGracefully()
                workerGroup.shutdownGracefully()
            }
        }
    }

    class ServerInitializer(private val router: Routing.() -> RequestDecorator) : ChannelInitializer<SocketChannel>() {
        override fun initChannel(channel: SocketChannel) {
            channel.pipeline().apply {
                addLast(HttpServerCodec())
                addLast(HttpObjectAggregator(1 shl 16))
                addLast(ServerHandler(router))
            }
        }
    }

    class ServerHandler(private val router: Routing.() -> RequestDecorator) : SimpleChannelInboundHandler<Any>() {
        override fun channelRead0(context: ChannelHandlerContext, message: Any?) {
            val routing = Routing()

            routing.router()

            val decorator = routing.decorator

            try {
                if (message is HttpRequest) {
                    val content = "Hello, World!"

                    val response = DefaultFullHttpResponse(
                        HttpVersion.HTTP_1_1,
                        HttpResponseStatus.OK,
                        Unpooled.wrappedBuffer(content.toByteArray())
                    )

                    if (decorator.authenticate) {
                        val hasAuthorization = message.headers().contains("Authorization")

                        if (!hasAuthorization) {
                            response.status = HttpResponseStatus.UNAUTHORIZED
                            response.content().clear()
                            context.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE)

                            return
                        }
                    }

                    response.headers().set(HttpHeaderNames.CONTENT_TYPE, decorator.contentType)
                    response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes())
                    response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE)

                    context.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE)
                }
            } catch (e: Exception) {
                println("Error processing request: ${e.message}")
                context.fireExceptionCaught(e)
                context.close().addListener(ChannelFutureListener.CLOSE)
            }
        }
    }
}