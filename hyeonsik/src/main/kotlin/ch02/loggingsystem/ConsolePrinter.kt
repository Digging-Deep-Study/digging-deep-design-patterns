package main.ch02.loggingsystem

import main.ch02.Log

class ConsolePrinter : LoggingSystem {

    override fun log(log: Log) {
        println("[Application][ConsolePrinter][${log.level}][${log.localDateTime}] ${log.message}")
    }
}
