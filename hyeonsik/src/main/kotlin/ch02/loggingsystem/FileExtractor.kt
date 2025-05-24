package main.ch02.loggingsystem

import main.ch02.Log

class FileExtractor : LoggingSystem {

    override fun log(log: Log) {
        println("[FileExtractor] ${log.level} - ${log.message}")
    }

}