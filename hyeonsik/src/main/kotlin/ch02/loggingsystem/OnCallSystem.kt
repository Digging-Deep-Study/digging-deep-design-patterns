package main.ch02.loggingsystem

import main.ch02.Log

class OnCallSystem : LoggingSystem {

    companion object {
        const val ON_CALL_MEMBER = "최현식"
    }

    override fun log(log: Log) {
        if (log.level == Log.LogLevel.ERROR) {
            notifyOnCall(log)
        }
    }

    private fun notifyOnCall(log: Log) {
        println("[OnCallSystem] ${ON_CALL_MEMBER}에게 알림: ${log.message} (${log.localDateTime})")
    }

}
