package main.chapter4.scenario1

import java.math.BigDecimal
import java.util.UUID
import kotlin.random.Random

class TossPayClient {
    fun pay(
        fromAccount: BankAccount,
        toAccount: BankAccount,
        amount: BigDecimal,
        currency: Currency,
    ): TransactionId {
        println(
            """
                TossPay로 ${fromAccount.accountHolder}님의 ${fromAccount.bank}: ${fromAccount.accountNumber} 계좌에서
                ${toAccount.accountHolder}님의 ${toAccount.bank}: ${toAccount.accountNumber} 계좌로
                ${amount}${currency.value}를 송금합니다.
            """.trimIndent()
        )

        return TransactionId(
            id = UUID.randomUUID().toString()
        )
    }
}

class TossPayAdapter(
    private val tossPayClient: TossPayClient,
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
    ) =
        tossPayClient.pay(
            fromAccount = BankAccount(
                bank = Bank.valueOf(fromBank),
                accountNumber = fromAccountNumber,
                accountHolder = fromAccountHolder,
            ),
            toAccount = BankAccount(
                bank = Bank.valueOf(toBank),
                accountNumber = toAccountNumber,
                accountHolder = toAccountHolder,
            ),
            amount = amount,
            currency = Currency.valueOf(currency.uppercase())
        )

    fun refund(
        transactionId: TransactionId,
    ) {
        println("TossPay에서 트랜잭션 ID ${transactionId.id}에 대한 환불 요청을 처리합니다.")
    }

    fun getProgress(
        transactionId: TransactionId,
    ): Status {
        println("TossPay에서 트랜잭션 ID ${transactionId.id}의 상태를 조회합니다.")
        return Random.nextBoolean().let {
            if (it) Status.SUCCESS else Status.FAILURE
        }
    }
}

data class BankAccount(
    val bank: Bank,
    val accountNumber: String,
    val accountHolder: String,
)

enum class Bank {
    TOSS, KAKAO, GOOGLE, APPLE
}

enum class Currency(val value: String) {
    KRW("원"), USD("달러"), EUR("유로")
}

enum class Status {
    SUCCESS, FAILURE
}

@JvmInline
value class TransactionId(val id: String)