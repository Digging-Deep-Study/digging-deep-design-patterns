package main.ch03.webrequest

class InMemoryCacheRepository {
    private val cache = mutableMapOf<String, String>()

    fun get(key: String): String? {
        println("InMemoryCacheRepository.get: key=$key, value=${cache[key]}")
        return cache[key]
    }

    fun put(key: String, value: String) {
        println("InMemoryCacheRepository.put: key=$key, value=$value")
        cache[key] = value

    }
}