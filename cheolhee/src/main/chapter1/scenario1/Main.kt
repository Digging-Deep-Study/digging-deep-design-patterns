package main.chapter1.scenario1

val googlePay = GooglePay()
val applePay = ApplePay()
val kakaoPay = KakaoPay()
val tossPay = TossPay()

fun main() {
    //    client에서 받아오는 값
    val myCard = Card(
        cardNumber = "1234-5678-9012-3456",
        cardHolder = "정철희",
        expirationDate = "05/01",
        cvv = "123",
        bank = Bank.TOSS,
    )

    val myPassword = "정철희입니다."

    val toAccount = BankAccount(
        bank = Bank.KAKAO,
        accountNumber = "0987654321",
        accountHolder = "김찬우",
    )

    //    비즈니스 로직
    val cardPayment = PayPal(
        email = "ekxk1234@gmail.com",
        password = myPassword,
        toAccount = toAccount,
        paymentGateway = tossPay,
    )

    cardPayment.pay(
        amount = 1000.toBigDecimal(),
        currency = Currency.KRW,
    )
}