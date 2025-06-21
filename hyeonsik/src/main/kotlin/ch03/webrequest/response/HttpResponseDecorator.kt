package main.ch03.webrequest.response

import main.ch03.webrequest.request.HttpRequest

abstract class HttpResponseDecorator (
    val httpResponse: HttpResponse,
) : HttpResponse() {

    override val request: HttpRequest
        get() = httpResponse.request

}
