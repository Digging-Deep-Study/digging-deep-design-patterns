package main.ch02.logger

import main.ch02.Log
import main.ch02.loggingsystem.LoggingSystem

/**
 * Subject
 */
interface Logger {

    fun log(log: Log)
    fun info(message: String)
    fun warn(message: String)
    fun error(message: String)

    fun addObserver(observer: LoggingSystem)
    fun removeObserver(observer: LoggingSystem)

}