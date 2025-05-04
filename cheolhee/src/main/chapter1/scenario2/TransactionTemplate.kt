package main.chapter1.scenario2

interface TransactionTemplate {
    fun <T> transaction(
        block: () -> T,
    ): T
}

class MysqlTransactionTemplate : TransactionTemplate {
    override fun <T> transaction(block: () -> T) =
        block()
}