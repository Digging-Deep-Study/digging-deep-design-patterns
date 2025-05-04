package main.chapter1.scenario2

interface Purchasable {
    fun purchase(
        goodsEntity: GoodsEntity,
        quantity: Int,
    )
}

class PurchasableImpl(
    private val goodsRepository: GoodsRepository = GoodsRepositoryImpl(),
) : Purchasable {

    override fun purchase(
        goodsEntity: GoodsEntity,
        quantity: Int,
    ) {
        if (goodsEntity.quantity < quantity) throw IllegalArgumentException("구매 수량이 재고 수량보다 많습니다.")
        goodsEntity.quantity -= quantity

        goodsRepository.update(goodsEntity)
    }
}