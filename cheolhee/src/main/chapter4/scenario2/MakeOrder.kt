package main.chapter4.scenario2

interface MakeOrder {
    fun make(orderRequest: OrderRequest): Order
}