package main.ch02.logger

import main.ch02.Log
import main.ch02.loggingsystem.LoggingSystem

class Log4j : Logger {

    private val loggers = mutableListOf<LoggingSystem>()

    override fun log(log: Log) {
        loggers.forEach { it.log(log) }
    }

    override fun info(message: String) {
        log(Log(Log.LogLevel.INFO, message))
    }

    override fun warn(message: String) {
        log(Log(Log.LogLevel.WARN, message))
    }

    override fun error(message: String) {
        log(Log(Log.LogLevel.ERROR, message))
    }

    override fun addObserver(observer: LoggingSystem) {
        println("[Log4j] 옵저버 추가: $observer")
        loggers.add(observer)
    }

    override fun removeObserver(observer: LoggingSystem) {
        println("[Log4j] 옵저버 제거: $observer")
        loggers.remove(observer)
    }

}