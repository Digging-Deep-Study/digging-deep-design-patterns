package main.ch03.webrequest.response

import main.ch03.webrequest.StorageRepository
import main.ch03.webrequest.request.HttpRequest

class DefaultHttpResponse(
    private val repository: StorageRepository = StorageRepository(),
    override val request: HttpRequest
) : HttpResponse() {
    override var statusCode: Int = 200
    override var body: String? = null
        get() {
            val shopNumber = request.extractShopNumber()
            return field ?: repository.getData(shopNumber).also {
                field = it
            }
        }
        set(value) {
            val shopNumber = request.extractShopNumber()
            field = value
            if (value != null) {
                repository.saveData(shopNumber, value)
            }
        }
}