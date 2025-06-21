package ch03.webrequest

import io.kotest.core.spec.style.StringSpec
import main.ch03.webrequest.InMemoryCacheRepository
import main.ch03.webrequest.StorageRepository
import main.ch03.webrequest.request.HttpRequest
import main.ch03.webrequest.response.Caching
import main.ch03.webrequest.response.DefaultHttpResponse
import main.ch03.webrequest.response.HttpResponse
import main.ch03.webrequest.response.Logging

class WebServer : StringSpec({

    "DefaultHttpResponse는 순수하게 진행된다." {
        val repository = StorageRepository()
        val request = HttpRequest(
            method = HttpRequest.HttpMethod.GET,
            path = "/1"
        )

        var response: HttpResponse = DefaultHttpResponse(
            repository = repository,
            request = request
        )

        println("response: $response")
    }

    "HttpResponseDecorator는 순수하게 진행된다." {
        val repository = StorageRepository()
        val cache = InMemoryCacheRepository()

        val request = HttpRequest(
            method = HttpRequest.HttpMethod.GET,
            path = "/1"
        )

        // when
        var response: HttpResponse = DefaultHttpResponse(
            repository = repository,
            request = request
        )
        response = Caching(
            httpResponse = response,
            cache = cache
        )

        println("첫 번째 요청 결과: ${response.body}")
        println("두 번째 요청 결과: ${response.body}")
        println("세 번째 요청 결과: ${response.body}")
    }


    "HttpResponseDecorator는 순수하게 진행된다.2" {
        val repository = StorageRepository()
        val cache = InMemoryCacheRepository()

        val request = HttpRequest(
            method = HttpRequest.HttpMethod.GET,
            path = "/1"
        )

        // when
        var response: HttpResponse = DefaultHttpResponse(
            repository = repository,
            request = request
        )
        response = Logging(
            httpResponse = response,
        )
        response = Logging(
            httpResponse = response,
        )
        response = Logging(
            httpResponse = response,
        )
        response = Logging(
            httpResponse = response,
        )

        println("요청 결과: ${response.body}")
    }

})