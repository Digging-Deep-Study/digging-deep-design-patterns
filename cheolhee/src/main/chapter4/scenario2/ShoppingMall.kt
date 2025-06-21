package main.chapter4.scenario2

class ShoppingMall(
    private val makeOrder: MakeOrder,
    private val payable: Payable,
    private val deliverable: Deliverable,
) {
    fun order(orderRequest: OrderRequest): Order {
        val order = makeOrder.make(orderRequest)
        val price = order.items.sumOf { it.price * it.quantity.toBigDecimal() }
        payable.pay(price)
        deliverable.deliver(order.id)
        return order
    }
}