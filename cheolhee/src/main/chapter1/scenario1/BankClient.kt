package main.chapter1.scenario1

interface BankClient {
    fun fetchAccount(
        card: Card,
        password: String,
    ): BankAccount
}

class TossBankClient : BankClient {
    private val bankApi = TossBankApi()

    override fun fetchAccount(
        card: Card,
        password: String,
    ): BankAccount {
        val accountNumber = bankApi.fetchAccountNumber(card, password)

        return BankAccount(
            accountNumber = accountNumber,
            accountHolder = card.cardHolder,
            bank = Bank.TOSS,
        )
    }
}

class KakaoBankClient : BankClient {
    private val bankApi = KakaoBankApi()

    override fun fetchAccount(
        card: Card,
        password: String,
    ): BankAccount {
        val accountNumber = bankApi.fetchAccountNumber(card, password)

        return BankAccount(
            accountNumber = accountNumber,
            accountHolder = card.cardHolder,
            bank = Bank.KAKAO,
        )
    }
}

class ShinhanBankClient : BankClient {
    private val bankApi = ShinhanBankApi()

    override fun fetchAccount(
        card: Card,
        password: String,
    ): BankAccount {
        val accountNumber = bankApi.fetchAccountNumber(card, password)

        return BankAccount(
            accountNumber = accountNumber,
            accountHolder = card.cardHolder,
            bank = Bank.SHINHAN,
        )
    }
}