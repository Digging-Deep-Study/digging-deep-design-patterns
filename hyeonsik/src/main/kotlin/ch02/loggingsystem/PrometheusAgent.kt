package main.ch02.loggingsystem

import main.ch02.Log


class PrometheusAgent : LoggingSystem {

    override fun log(log: Log) {
        println("[PrometheusAgent] ${log.level} - ${log.message}")
    }

}