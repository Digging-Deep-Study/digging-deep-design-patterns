package main.ch03.webrequest.response

import main.ch03.webrequest.request.HttpRequest

abstract class HttpResponse {
    open val request: HttpRequest = HttpRequest(HttpRequest.HttpMethod.GET, "/")
    open var statusCode: Int = 200
    open var body: String? = null

    override fun toString(): String {
        return "HttpResponse(request=$request, statusCode=$statusCode, body=$body)"
    }
}