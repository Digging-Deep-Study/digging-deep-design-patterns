package main.chapter1.scenario1

interface BankClient {
    fun fetchAccount(
        card: Card,
        password: String,
    ): BankAccount
}

class TossBankClient : BankClient {
    override fun fetchAccount(
        card: Card,
        password: String,
    ): BankAccount {
        return BankAccount(
            accountNumber = "1234567890",
            accountHolder = "정철희",
            bank = Bank.TOSS,
        )
    }
}

class KakaoBankClient : BankClient {
    override fun fetchAccount(
        card: Card,
        password: String,
    ): BankAccount {
        return BankAccount(
            accountNumber = "0987654321",
            accountHolder = "정철희",
            bank = Bank.KAKAO,
        )
    }
}

class ShinhanBankClient : BankClient {
    override fun fetchAccount(
        card: Card,
        password: String,
    ): BankAccount {
        return BankAccount(
            accountNumber = "1122334455",
            accountHolder = "정철희",
            bank = Bank.SHINHAN,
        )
    }
}