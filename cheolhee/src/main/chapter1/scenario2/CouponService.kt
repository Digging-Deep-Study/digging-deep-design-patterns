package main.chapter1.scenario2

import java.math.BigDecimal

class CouponService {
    fun find() = Coupon(
        name = "10% 쿠폰",
        percentage = 10.toBigDecimal(),
    )
}

data class Coupon(
    val name: String,
    val percentage: BigDecimal,
)