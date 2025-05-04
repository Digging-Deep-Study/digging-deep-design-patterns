package main.chapter1.scenario2

interface GoodsRepository {
    fun update(goodsEntity: GoodsEntity)
    fun findById(id: Long): GoodsEntity?
}

class GoodsRepositoryImpl : GoodsRepository {
    private val goodsList = mutableListOf<GoodsEntity>()
    init {
        (0..10).forEach { index ->
            val goodsEntity = GoodsEntity(
                id = index.toLong(),
                name = "상품$index",
                price = 1000.toBigDecimal() * index.toBigDecimal(),
                _quantity = index,
            )
            goodsList.add(goodsEntity)
        }
    }

    override fun findById(id: Long) =
        goodsList.find { it.id == id }

    override fun update(
        goodsEntity: GoodsEntity,
    ) {
        val goods = goodsList.find { it.id == goodsEntity.id }
            ?: throw IllegalArgumentException("상품이 존재하지 않습니다.")

        goodsList.remove(goods)
        goodsList.add(goodsEntity)
    }
}