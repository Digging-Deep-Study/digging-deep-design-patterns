package com.practice.chapter

fun main() {
    val tossGateway = TossGateway()
    val imPortGateway = ImPortGateway()

    val tossAdapter = TossAdapter(tossGateway)
    val imPortAdapter = ImPortAdapter(imPortGateway)

    tossAdapter.refund("12345")
    tossAdapter.processPayment(100.0)
    println(tossAdapter.getStatus("12345"))

    imPortAdapter.refund( "67890")
    imPortAdapter.processPayment(200.0)
    println(imPortAdapter.getStatus("67890"))
}

fun processPaymentGateway(gateway: PaymentGateway, amount: Double) {
    gateway.processPayment(amount)
}

interface PaymentGateway {
    fun processPayment(amount: Double)
    fun refund(transactionId: String)
    fun getStatus(transactionId: String): String
}

class TossGateway {
    fun makePayment(amount: Double) {
        println("Processing payment of $$amount through Toss Gateway")
    }

    fun cancelPayment(transactionId: String) {
        println("Cancelling payment with transaction ID: $transactionId in Toss Gateway")
    }

    fun checkPaymentStatus(transactionId: String): String {
        return "Status of transaction $transactionId in Toss Gateway"
    }
}

class ImPortGateway {
    fun makePayment(amount: Double) {
        println("Initiating payment of $$amount through ImPort Gateway")
    }

    fun cancelPayment(transactionId: String) {
        println("Reversing payment with transaction ID: $transactionId in ImPort Gateway")
    }

    fun checkPaymentStatus(transactionId: String): String {
        return "Status of transaction $transactionId in ImPort Gateway"
    }
}

class TossAdapter(private val tossGateway: TossGateway) : PaymentGateway {
    override fun processPayment(amount: Double) {
        tossGateway.makePayment(amount)
    }

    override fun refund(transactionId: String) {
        tossGateway.cancelPayment(transactionId)
    }

    override fun getStatus(transactionId: String): String {
        return tossGateway.checkPaymentStatus(transactionId)
    }
}

class ImPortAdapter(private val tossAdapter: ImPortGateway) : PaymentGateway {
    override fun processPayment(amount: Double) {
        tossAdapter.makePayment(amount)
    }

    override fun refund(transactionId: String) {
        tossAdapter.cancelPayment(transactionId)
    }

    override fun getStatus(transactionId: String): String {
        return tossAdapter.checkPaymentStatus(transactionId)
    }
}