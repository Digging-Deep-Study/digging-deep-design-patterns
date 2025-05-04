package main.chapter1.scenario2

import main.chapter1.scenario1.Currency
import main.chapter1.scenario1.Payable
import java.math.BigDecimal

interface BuyGoodsUseCase {
    fun buy(
        buyItem: BuyItem,
        price: BigDecimal,
    )

//    fun buy(
//        buyItems: List<BuyItem>,
//    )
}

class BuyGoodsUseCaseImpl(
    private val transactionTemplate: TransactionTemplate,
    private val goodsService: GoodsService,
    private val lockTemplate: LockTemplate,
    private val discountable: Discountable,
    private val purchasable: Purchasable,
    private val payable: Payable,
) : BuyGoodsUseCase {

    private val noticeAlarm = NotificationAlarm(NoticeService())
    private val emailAlarm = EmailAlarm(email = "ekxk1234@gmail.com")

    override fun buy(
        buyItem: BuyItem,
        price: BigDecimal,
    ) {
        lockTemplate.lock {
            transactionTemplate.transaction {
                val goodsEntity = goodsService.find(buyItem.goodsId)

                goodsEntity.registerObserver(noticeAlarm, emailAlarm)

                val discountedPrice = discountable.discount(
                    goodsEntity = goodsEntity,
                    quantity = buyItem.quantity,
                )

                purchasable.purchase(
                    goodsEntity = goodsEntity,
                    quantity = buyItem.quantity,
                )

                require(price == discountedPrice) { "구매 가격이 상품 가격과 일치하지 않습니다. 상품 금액: $discountedPrice, 결제 요청 금액: $price" }

                payable.pay(
                    amount = discountedPrice,
                    currency = Currency.KRW,
                )
            }
        }
    }
}