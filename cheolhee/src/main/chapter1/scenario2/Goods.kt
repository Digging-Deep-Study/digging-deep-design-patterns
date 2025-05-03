package main.chapter1.scenario2

import java.math.BigDecimal

data class Goods(
    val name: String,
    val price: BigDecimal,
    val stock: Stock,
)