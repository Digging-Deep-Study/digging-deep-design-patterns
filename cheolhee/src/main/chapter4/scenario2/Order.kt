package main.chapter4.scenario2

import java.math.BigDecimal

data class OrderRequest(
    val userId: String,
    val items: List<OrderItem>,
)

data class Order(
    val id: String,
    val user: User,
    val items: List<OrderItem>
)

data class User(
    val id: String,
    val name: String,
)

data class OrderItem(
    val productId: String,
    val quantity: Int,
    val price: BigDecimal,
)