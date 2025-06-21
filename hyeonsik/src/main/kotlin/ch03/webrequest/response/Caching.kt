package main.ch03.webrequest.response

import main.ch03.webrequest.InMemoryCacheRepository
import main.ch03.webrequest.StorageRepository

class Caching(
    httpResponse: HttpResponse,
    private val cache: InMemoryCacheRepository
) : HttpResponseDecorator(httpResponse) {

    override var statusCode: Int
        get() = httpResponse.statusCode
        set(value) {
            httpResponse.statusCode = value
        }

    override var body: String?
        get() {
            val shopNumber = httpResponse.request.extractShopNumber()
            val cachedData = cache.get(shopNumber)
            return cachedData?.also {
                println("캐시 히트: shopNumber=$shopNumber, data=$it")
            } ?: httpResponse.body?.also {
                println("캐시에 저장: shopNumber=$shopNumber, data=$it")
                cache.put(shopNumber, it)
            }
        }
        set(value) {
            val shopNumber = httpResponse.request.extractShopNumber()
            println("캐시에 저장 요청: shopNumber=$shopNumber, 저장할 값=$value")
            httpResponse.body = value
            if (value != null) {
                cache.put(shopNumber, value)
            }
        }
}