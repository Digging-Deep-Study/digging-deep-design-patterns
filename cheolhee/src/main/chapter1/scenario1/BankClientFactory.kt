package main.chapter1.scenario1

class BankClientFactory {
    fun getClient(bank: Bank) =
        when (bank) {
            Bank.TOSS -> TossBankClient()
            Bank.KAKAO -> KakaoBankClient()
            Bank.SHINHAN -> ShinhanBankClient()
        }
}