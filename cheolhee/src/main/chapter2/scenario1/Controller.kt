package main.chapter2.scenario1

interface Controller {
    fun handle(request: HttpRequest): HttpResponse
}

class UserController : Controller {
    override fun handle(request: HttpRequest): HttpResponse {
        val method = request.requestHeader.method
        val path = request.requestHeader.path

        return when {
            method == RequestMethod.POST && path.value == "/users" -> createUser(request)
            method == RequestMethod.GET && path.value == "/users" -> getUsers(request)
            method == RequestMethod.PUT && path.value == "/users" -> updateUser(request)
            method == RequestMethod.DELETE && path.value == "/users" -> deleteUser(request)
            else -> HttpResponse(404, "해당 URL을 처리할 수 없습니다.")
        }
    }

    private fun createUser(request: HttpRequest): HttpResponse {
        val userRequest = request.requestBody.queryParameters<UserRequest>()

        if (userRequest.id in userDatabase) return HttpResponse(409, "이미 존재하는 회원입니다.")
        userDatabase[userRequest.id] = userRequest

        return HttpResponse(201)
    }

    private fun getUsers(request: HttpRequest): HttpResponse {
        val userList = userDatabase.values.joinToString(", ")
        return HttpResponse(200, userList)
    }

    private fun updateUser(request: HttpRequest): HttpResponse {
        val userRequest = request.requestBody.queryParameters<UserRequest>()
        userDatabase[userRequest.id]
            ?: return HttpResponse(404, "회원을 찾을 수 없습니다.")

        userDatabase[userRequest.id] = userRequest
        return HttpResponse(200, "회원 정보가 업데이트되었습니다.")
    }

    private fun deleteUser(request: HttpRequest): HttpResponse {
        val userId = request.queryString["id"]?.toLongOrNull()
            ?: return HttpResponse(400, "id 값이 없습니다.")

        if (userDatabase.remove(userId) == null) return HttpResponse(404, "회원을 찾을 수 없습니다.")

        return HttpResponse(204)
    }
}

data class UserRequest(
    val id: Long,
    val name: String,
    val password: String,
)

val userDatabase = mutableMapOf(
    1L to UserRequest(1, "정철희", "1234"),
    2L to UserRequest(2, "김찬우", "abcd"),
)

object EndpointDispatcher {
    fun dispatch(request: HttpRequest): Controller {
        val exactEndpoint = HttpEndpoint(
            method = request.requestHeader.method,
            path = request.requestHeader.path,
        )

        return urlToControllerMap[exactEndpoint]
            ?: throw IllegalArgumentException("해당 URL을 처리할 수 없습니다.")
    }

    init {
        urlToControllerMap[HttpEndpoint(RequestMethod.POST, RequestPath("/users"))] = UserController()
        urlToControllerMap[HttpEndpoint(RequestMethod.GET, RequestPath("/users"))] = UserController()
        urlToControllerMap[HttpEndpoint(RequestMethod.PUT, RequestPath("/users"))] = UserController()
        urlToControllerMap[HttpEndpoint(RequestMethod.DELETE, RequestPath("/users"))] = UserController()
    }
}

data class ControllerWithPath(
    val controller: Controller,
    val pathVariables: Map<String, String>
)