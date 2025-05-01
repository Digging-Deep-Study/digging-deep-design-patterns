package main.chapter1.scenario1

import java.math.BigDecimal

class CardPayment(
    private val card: Card,
    private val password: String,
    private val toAccount: BankAccount,
    private val paymentGateway: PaymentGateway,
): Payable {
    private val bankClientFactory = BankClientFactory()
    override fun pay(
        amount: BigDecimal,
        currency: Currency,
    ) {
        val bankClient = bankClientFactory.getClient(card.bank)
        val fromAccount = bankClient.fetchAccount(card, password)

        paymentGateway.executePayment(
            fromAccount = fromAccount,
            toAccount = toAccount,
            amount = amount,
            currency = currency,
        )
    }
}