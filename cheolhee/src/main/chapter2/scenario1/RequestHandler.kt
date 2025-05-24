package main.chapter2.scenario1

interface RequestHandler {
    fun handle(): HttpResponse
}

abstract class HttpRequestHandler(
    val httpRequest: HttpRequest,
    val controller: Controller,
) : RequestHandler {
    fun invoke(
        httpRequest: HttpRequest,
        controller: Controller,
    ): HttpResponse = controller.handle(httpRequest)

    override fun handle(): HttpResponse {
        return controller.handle(httpRequest)
    }
}

class RequestHandlerImpl(
    httpRequest: HttpRequest,
    controller: Controller,
) : HttpRequestHandler(httpRequest, controller)

abstract class HttpRequestHandlerDecorator(
    private val httpRequestHandler: HttpRequestHandler,
) : HttpRequestHandler(httpRequestHandler.httpRequest, httpRequestHandler.controller) {
    override fun handle(): HttpResponse {
        return httpRequestHandler.handle()
    }
}

class LoggingDecoratorHttp(
    private val httpRequestHandler: HttpRequestHandler,
) : HttpRequestHandlerDecorator(httpRequestHandler) {
    override fun handle(): HttpResponse {
        println("LoggingDecoratorHttp: ${httpRequest.requestHeader.method} ${httpRequest.requestHeader.path} START")
        return super.handle().apply {
            println("LoggingDecoratorHttp: ${httpRequest.requestHeader.method} ${httpRequest.requestHeader.path} END")
        }
    }
}

class AuthenticationDecoratorHttp(
    private val httpRequestHandler: HttpRequestHandler,
) : HttpRequestHandlerDecorator(httpRequestHandler) {
    override fun handle(): HttpResponse {
        val isAuthenticated = httpRequestHandler.httpRequest.requestHeader.host !in blacklist

        if (isAuthenticated) println("인증된 사용자입니다.")
        else println("허용되지 않은 사용자입니다.").apply { throw UnAuthorizedException() }

        return super.handle()
    }
}

class CachingDecoratorHttp(
    private val httpRequestHandler: HttpRequestHandler,
) : HttpRequestHandlerDecorator(httpRequestHandler) {

    override fun handle(): HttpResponse {
        globalHttpCache[httpRequest]?.let { httpResponse ->
            println("캐시된 응답을 반환합니다: $httpResponse")
            return httpResponse
        }

        println("캐시된 응답이 없습니다.")
        val response = super.handle()
        globalHttpCache[httpRequest] = response
        return response
    }
}