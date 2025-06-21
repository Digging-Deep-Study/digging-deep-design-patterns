package main.ch03.webrequest.response

class Authentication(
    httpResponse: HttpResponse
) : HttpResponseDecorator(httpResponse) {

    companion object {
        const val USER_ID = "userId"
        const val USER_PW = "userPw"
    }

    override var statusCode: Int = httpResponse.statusCode
        get() {
            if (isRequestWithCredentials()) {
                return field
            }
            return 401
        }

    override var body: String? = httpResponse.body
        get() {
            if (isRequestWithCredentials()) {
                return field
            }
            return "Unauthorized"
        }

    private fun isRequestWithCredentials() = request.path.endsWith("?userId=$USER_ID&userPw=$USER_PW")
}