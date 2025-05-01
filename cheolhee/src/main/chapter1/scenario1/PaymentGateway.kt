package main.chapter1.scenario1

import java.math.BigDecimal

interface PaymentGateway {
    fun executePayment(
        fromAccount: BankAccount,
        toAccount: BankAccount,
        amount: BigDecimal,
        currency: Currency,
    )
}

class GooglePay : PaymentGateway {
    override fun executePayment(
        fromAccount: BankAccount,
        toAccount: BankAccount,
        amount: BigDecimal,
        currency: Currency,
    ) {
        println(
            "GooglePay로 ${fromAccount.accountHolder}님의 ${fromAccount.bank}: ${fromAccount.accountNumber} 계좌에서 ${toAccount.accountHolder}님의 ${toAccount.bank}: ${toAccount.accountNumber} 계좌로 ${amount}${currency.value}를 송금합니다."
        )
    }
}

class ApplePay : PaymentGateway {
    override fun executePayment(
        fromAccount: BankAccount,
        toAccount: BankAccount,
        amount: BigDecimal,
        currency: Currency,
    ) {
        println(
            "ApplePay로 ${fromAccount.accountHolder}님의 ${fromAccount.bank}: ${fromAccount.accountNumber} 계좌에서 ${toAccount.accountHolder}님의 ${toAccount.bank}: ${toAccount.accountNumber} 계좌로 ${amount}${currency.value}를 송금합니다."
        )
    }
}

class KakaoPay : PaymentGateway {
    override fun executePayment(
        fromAccount: BankAccount,
        toAccount: BankAccount,
        amount: BigDecimal,
        currency: Currency,
    ) {
        println(
            "KakaoPay로 ${fromAccount.accountHolder}님의 ${fromAccount.bank}: ${fromAccount.accountNumber} 계좌에서 ${toAccount.accountHolder}님의 ${toAccount.bank}: ${toAccount.accountNumber} 계좌로 ${amount}${currency.value}를 송금합니다."
        )
    }
}

class TossPay : PaymentGateway {
    override fun executePayment(
        fromAccount: BankAccount,
        toAccount: BankAccount,
        amount: BigDecimal,
        currency: Currency,
    ) {
        println(
            "TossPay로 ${fromAccount.accountHolder}님의 ${fromAccount.bank}: ${fromAccount.accountNumber} 계좌에서 ${toAccount.accountHolder}님의 ${toAccount.bank}: ${toAccount.accountNumber} 계좌로 ${amount}${currency.value}를 송금합니다."
        )
    }
}