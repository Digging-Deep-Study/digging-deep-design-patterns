package main.chapter1.scenario2

import java.math.BigDecimal

interface Discountable {
    fun discount(
        goodsEntity: GoodsEntity,
        quantity: Int,
    ): BigDecimal
}