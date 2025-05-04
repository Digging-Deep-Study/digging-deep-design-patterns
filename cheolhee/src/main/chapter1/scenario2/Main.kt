package main.chapter1.scenario2

import main.chapter1.scenario1.*

val googlePay = GooglePay()
val applePay = ApplePay()
val kakaoPay = KakaoPay()
val tossPay = TossPay()

val marketAccount = BankAccount(
    bank = Bank.TOSS,
    accountNumber = "1234-5678-9012-3456",
    accountHolder = "정철희",
)

fun main() {
    //    client에서 받아오는 값
    val customerCard = Card(
        cardNumber = "1234-5678-9012-3456",
        cardHolder = "김찬우",
        expirationDate = "05/04",
        cvv = "123",
        bank = Bank.KAKAO,
    )

    val customerPassword = "김찬우입니다."

    val buyItem = BuyItem(
        goodsId = 1,
        quantity = 1,
    )

    //    비즈니스 로직
    val transactionTemplate = MysqlTransactionTemplate()
    val goodsService = GoodsService()
    val lockTemplate = SynchronizedLockTemplate()
    val discountable = DiscountWithCoupon()
    val purchasable = PurchasableImpl()
    val payable = CardPayment(
        card = customerCard,
        password = customerPassword,
        toAccount = marketAccount,
        paymentGateway = tossPay,
    )

    val buyGoodsUseCase = BuyGoodsUseCaseImpl(
        transactionTemplate = transactionTemplate,
        goodsService = goodsService,
        lockTemplate = lockTemplate,
        discountable = discountable,
        purchasable = purchasable,
        payable = payable,
    )

    buyGoodsUseCase.buy(
        buyItem = buyItem,
        price = 900.toBigDecimal(),
    )
}