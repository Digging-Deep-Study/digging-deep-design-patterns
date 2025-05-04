package main.chapter1.scenario1

interface BankApi {
    fun fetchAccountNumber(
        card: Card,
        password: String,
    ): String
}

class TossBankApi : BankApi {
    override fun fetchAccountNumber(
        card: Card,
        password: String,
    ) = "1234567890"
}

class KakaoBankApi : BankApi {
    override fun fetchAccountNumber(
        card: Card,
        password: String,
    ) = "0987654321"
}

class ShinhanBankApi : BankApi {
    override fun fetchAccountNumber(
        card: Card,
        password: String,
    ) = "1122334455"
}