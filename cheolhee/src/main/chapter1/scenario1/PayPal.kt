package main.chapter1.scenario1

import java.math.BigDecimal

class PayPal(
    private val email: String,
    private val password: String,
    private val toAccount: BankAccount,
    private val paymentGateway: PaymentGateway,
): Payable {
    private val payPalClient = PayPalClient()

    override fun pay(
        amount: BigDecimal,
        currency: Currency,
    ) {
        val fromAccount = payPalClient.fetchAccount(email, password)

        paymentGateway.executePayment(
            fromAccount = fromAccount,
            toAccount = toAccount,
            amount = amount,
            currency = currency,
        )
    }
}

class PayPalClient {
    fun fetchAccount(email: String, password: String): BankAccount {
        return BankAccount(
            accountNumber = "1234567890",
            accountHolder = email,
            bank = Bank.random(),
        )
    }
}