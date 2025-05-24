package main.ch02.loggingsystem

import main.ch02.Log

/**
 * Observer
 */
interface LoggingSystem {

    fun log(log: Log)

}