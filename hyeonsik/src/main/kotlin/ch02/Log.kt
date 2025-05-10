package main.ch02

import java.time.LocalDateTime

data class Log(
    val level: LogLevel,
    val message: String,
    val localDateTime: LocalDateTime = LocalDateTime.now(),
) {

    enum class LogLevel {
        INFO,
        WARN,
        ERROR,
    }

}
