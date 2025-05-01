package main.chapter1.scenario1

import java.math.BigDecimal

interface Payable {
    fun pay(
        amount: BigDecimal,
        currency: Currency,
    )
}