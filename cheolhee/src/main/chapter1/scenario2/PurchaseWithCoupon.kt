package main.chapter1.scenario2

import java.math.BigDecimal

class DiscountWithCoupon(
    private val couponService: CouponService = CouponService(),
) : Discountable {
    override fun discount(
        goodsEntity: GoodsEntity,
        quantity: Int,
    ): BigDecimal {
        val coupon = couponService.find()
        val discountAmount = goodsEntity.price * coupon.percentage / 100.toBigDecimal()

        return goodsEntity.price - discountAmount
    }
}