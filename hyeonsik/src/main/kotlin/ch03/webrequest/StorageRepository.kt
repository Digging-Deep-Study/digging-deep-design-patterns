package main.ch03.webrequest

class StorageRepository {

    private val storage = mutableMapOf<String, String>()

    init {
        for (i in 1..10) {
            storage[i.toString()] = "원본데이터 $i"
        }
    }

    fun getData(shopNumber: String): String {
        return storage[shopNumber] ?: "기본 데이터 for $shopNumber"
    }

    fun saveData(shopNumber: String, data: String) {
        storage[shopNumber] = data
    }

}