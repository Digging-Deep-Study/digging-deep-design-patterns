package main.chapter1.scenario2

interface LockTemplate {
    fun <T> lock(
        block: () -> T,
    ): T
}

class SynchronizedLockTemplate : LockTemplate {
    private val lock = Any()

    override fun <T> lock(
        block: () -> T,
    ): T = synchronized(lock) {
        block()
    }
}