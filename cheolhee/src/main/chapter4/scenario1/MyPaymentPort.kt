package main.chapter4.scenario1

import java.math.BigDecimal

class MyPaymentPort(
    private val tossPayAdapter: TossPayAdapter,
) {
    fun pay(
        fromBank: String,
        fromAccountNumber: String,
        fromAccountHolder: String,
        toBank: String,
        toAccountNumber: String,
        toAccountHolder: String,
        amount: BigDecimal,
        currency: String,
    ) {
        tossPayAdapter.pay(
            fromBank = fromBank,
            fromAccountNumber = fromAccountNumber,
            fromAccountHolder = fromAccountHolder,
            toBank = toBank,
            toAccountNumber = toAccountNumber,
            toAccountHolder = toAccountHolder,
            amount = amount,
            currency = currency,
        )
    }

    fun refund(
        transactionId: String,
    ) {
        tossPayAdapter.refund(
            transactionId = TransactionId(transactionId)
        )
    }

    fun getProgress(
        transactionId: String,
    ): Boolean {
        val status = tossPayAdapter.getProgress(
            transactionId = TransactionId(transactionId)
        )

        return when (status) {
            Status.SUCCESS -> true
            Status.FAILURE -> false
        }
    }
}
