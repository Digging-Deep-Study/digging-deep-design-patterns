package com.practice.chapter

fun main() {
    val paymentService = PaymentService()
    val productService = ProductService()
    val paymentFacade = PaymentFacade(paymentService, productService)

    val productId = "12345"
    val amount = 100.0

    val result = paymentFacade.processPayment(productId, amount)
    println(result)
}

class PaymentService {
    fun createPayment(amount: Double): String {
        // Logic to create a payment
        return "Payment of $$amount created successfully."
    }
}

class ProductService {
    fun exists(productId: String): Boolean {
        // Logic to check if a product exists
        return true // Assume product exists for simplicity
    }
}

class PaymentFacade(
    private val paymentService: PaymentService,
    private val productService: ProductService
) {
    fun processPayment(productId: String, amount: Double): String {
        if (!productService.exists(productId)) {
            return "Product with ID $productId does not exist."
        }
        return paymentService.createPayment(amount)
    }
}