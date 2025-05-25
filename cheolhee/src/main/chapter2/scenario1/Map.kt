package main.chapter2.scenario1

val blacklist = mutableListOf(
    "김찬우", "이은지",
)

val globalHttpCache = mutableMapOf<HttpRequest, HttpResponse>()
val urlToControllerMap = mutableMapOf<HttpEndpoint, Controller>()

inline fun <reified R> Map<*, *>.requestBody() =
    this as R

inline fun <reified R> Map<*, *>.queryParameters() =
    this as R

