package main.chapter1.scenario2

class GoodsService(
    private val goodsRepository: GoodsRepository = GoodsRepositoryImpl(),
) {
    fun find(id: Long): GoodsEntity {
        return goodsRepository.findById(id)
            ?: throw IllegalArgumentException("상품이 존재하지 않습니다.")
    }
}