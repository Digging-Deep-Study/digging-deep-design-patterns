package main.chapter2.scenario1

data class HttpRequest(
    val requestHeader: RequestHeader,
    val requestBody: Map<String, String> = emptyMap(),
    val queryString: Map<String, String> = emptyMap(),
)

data class HttpResponse(
    val statusCode: Int,
    val body: String? = null,
)

data class RequestHeader(
    val method: RequestMethod,
    val path: RequestPath,
    val host: String,
)

enum class RequestMethod {
    GET,
    POST,
    PUT,
    DELETE,
}

@JvmInline
value class RequestPath(
    val value: String,
) {
    init {
        require(value.isNotEmpty()) { "path는 비어있을 수 없습니다." }
        require(value.startsWith("/")) { "path는 '/'로 시작해야 합니다." }
    }

    fun toRegexPattern(): Regex {
        val regexStr = this.value
            .replace(Regex("\\{([^/]+)}")) { matchResult ->
                "(?<${
                    matchResult.groupValues[1]
                }>[^/]+)"
            }
        return Regex("^$regexStr$")
    }

    fun extractVariableNames(): List<String> {
        return Regex("\\{([^/]+)}")
            .findAll(this.value)
            .map { it.groupValues[1] }
            .toList()
    }
}

data class UnAuthorizedException(override val message: String = "허용되지 않은 사용자입니다.") : RuntimeException(message)

data class HttpEndpoint(
    val method: RequestMethod,
    val path: RequestPath,
)