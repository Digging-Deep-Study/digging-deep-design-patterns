package main.ch03.webrequest.request

data class HttpRequest(
    val method: HttpMethod,
    val path: String,
) {
    enum class HttpMethod {
        GET,
        POST,
        PUT,
        DELETE,
        PATCH,
        HEAD,
        OPTIONS,
    }

    fun extractShopNumber(): String {
        val regex = """/(\w+)(\?.*)?""".toRegex()
        val result = regex.find(path)?.groupValues?.get(1)
            ?: ""

        println("extractShopNumber: path=$path, result=$result")
        return result
    }
}
