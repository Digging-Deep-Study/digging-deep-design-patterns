package main.ch03.webrequest.response

class Logging(
    httpResponse: HttpResponse
) : HttpResponseDecorator(httpResponse) {

    override var statusCode = httpResponse.statusCode
        get() {
            println("Logging: statusCode = $field")
            return field
        }

    override var body = httpResponse.body
        get() {
            println("Logging: body = $field")
            return field
        }

}