package main.chapter2.scenario1

fun main() {
    val httpRequest = HttpRequest(
        requestHeader = RequestHeader(
            method = RequestMethod.GET,
            path = RequestPath("/users"),
            host = "localhost",
        ),
        queryString = mapOf("id" to "1"),
    )

    val controller = EndpointDispatcher.dispatch(httpRequest)
    val httpRequestHandler = RequestHandlerImpl(httpRequest, controller)
    val loggingDecoratorHttp = LoggingDecoratorHttp(httpRequestHandler)
    val authenticationDecoratorHttp = AuthenticationDecoratorHttp(loggingDecoratorHttp)
    val cachingDecoratorHttp = CachingDecoratorHttp(authenticationDecoratorHttp)

    val response = cachingDecoratorHttp.handle()
    println("Response 결과값: ${response.statusCode} ${response.body}")

    println("=====================캐시 처리 확인=========================")

    val response2 = cachingDecoratorHttp.handle()
    println("Response2 결과값: ${response2.statusCode} ${response2.body}")
}