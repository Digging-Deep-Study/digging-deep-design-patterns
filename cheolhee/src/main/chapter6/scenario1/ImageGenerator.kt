package main.chapter6.scenario1

import java.io.File
import java.lang.reflect.Proxy
import java.time.LocalDate

interface ImageGenerator {
    fun generate(
        prompt: String,
        width: Width,
        height: Height,
        format: ImageFormat,
    ): File
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LocalCacheable(
    val key: String,
    val ttl: Long = -1,
)

object LocalCache {
    val cache = mutableMapOf<String, Pair<Long, Any>>()

    inline fun <reified T> get(key: String): T? {
        val entry = cache[key] ?: return null
        if (entry.first == -1L) {
            println("cache hit for key: $key (no TTL)")
            return entry.second as T
        }
        if (System.currentTimeMillis() > entry.first) {
            cache.remove(key)
            return null
        }
        println("cache hit for key: $key")
        return entry.second as T
    }

    fun put(key: String, value: Any, ttl: Long) {
        cache[key] = Pair(System.currentTimeMillis() + ttl, value)
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class DailyLimit(
    val key: String,
    val limit: Int,
)

object DailyLimitTracker {
    private val usage = mutableMapOf<String, Pair<Long, LocalDate>>()

    fun checkAndIncrement(key: String, limit: Int): Boolean {
        val today = LocalDate.now()
        val entry = usage[key]
        if (entry == null || entry.second != today) {
            usage[key] = Pair(1L, today)
            return true
        }
        if (entry.first < limit) {
            usage[key] = Pair(entry.first + 1, today)
            return true
        }
        println("Daily limit exceeded for key: $key")
        return false
    }
}

class SimpleImageGenerator(
    private val imageGenerationClient: ImageGenerationClient,
) : ImageGenerator {

    @LocalCacheable(key = KEY, ttl = TTL)
    @DailyLimit(key = KEY, limit = LIMIT)
    override fun generate(
        prompt: String,
        width: Width,
        height: Height,
        format: ImageFormat,
    ) =
        imageGenerationClient.generateImage(
            prompt = prompt,
            width = width.value,
            height = height.value,
            format = format.name.lowercase(),
        )

    private companion object {
        const val KEY: String = "SimpleImageGenerator.generate"
        const val TTL: Long = 60 * 60 * 24
        const val LIMIT = 2
    }
}

class ImageGenerationClient {
    fun generateImage(
        prompt: String,
        width: Int = 512,
        height: Int = 512,
        format: String,
    ) =
        File("dummy_image.$format").apply {
            writeText("Generated image with prompt: $prompt, width: $width, height: $height, format: $format")
        }
}

@JvmInline value class Height(val value: Int)
@JvmInline value class Width(val value: Int)
enum class ImageFormat { PNG, JPEG, WEBP }

fun main() {val target = SimpleImageGenerator(ImageGenerationClient())
    val imageGenerator = Proxy.newProxyInstance(
        ImageGenerator::class.java.classLoader,
        arrayOf(ImageGenerator::class.java),
    ) { _, method, args ->
        val arguments = args ?: emptyArray()

        val dailyLimit = target::class.java.getMethod(method.name, *method.parameterTypes)
            .getAnnotation(DailyLimit::class.java)

        val localCacheable = target::class.java.getMethod(method.name, *method.parameterTypes)
            .getAnnotation(LocalCacheable::class.java)

        if (dailyLimit != null) {
            if (!DailyLimitTracker.checkAndIncrement(dailyLimit.key, dailyLimit.limit)) {
                throw IllegalStateException("Daily limit exceeded for key: ${dailyLimit.key}")
            }
        }

        if (localCacheable != null) {
            LocalCache.get<Any>(localCacheable.key)?.let { return@newProxyInstance it }

            val result = method.invoke(target, *arguments)
            LocalCache.put(localCacheable.key, result, localCacheable.ttl)
            return@newProxyInstance result
        }

        method.invoke(target, *arguments)
    } as ImageGenerator

    val imageFile = imageGenerator.generate(
        prompt = "A beautiful sunset over the mountains",
        width = Width(800),
        height = Height(600),
        format = ImageFormat.PNG,
    )
    println("Image generated at: ${imageFile.absolutePath}")

    val imageFile2 = imageGenerator.generate(
        prompt = "A beautiful sunset over the mountains",
        width = Width(800),
        height = Height(600),
        format = ImageFormat.PNG,
    )
    println("Image generated at: ${imageFile2.absolutePath}")

    val imageFile3 = imageGenerator.generate(
        prompt = "A beautiful sunset over the mountains",
        width = Width(800),
        height = Height(600),
        format = ImageFormat.PNG,
    )
    println("Image generated at: ${imageFile3.absolutePath}")
}