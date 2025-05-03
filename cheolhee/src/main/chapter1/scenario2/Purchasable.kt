package main.chapter1.scenario2

interface Purchasable {
    fun purchase(
        goods: Goods,
        quantity: Int,
    )
}