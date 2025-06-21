package main.chapter4.scenario2

import java.math.BigDecimal

interface Payable {
    fun pay(amount: BigDecimal)
}