package ch02

import main.ch02.logger.Logger

class ECommerceApplication(private val logger: Logger) {

    fun processOrder(orderId: String) {
        logger.info("주문이 처리되었습니다: $orderId")
    }

    fun handleUserError(userId: String) {
        logger.warn("사용자 정보가 누락되었습니다: $userId")
    }

    fun handleAbnormalOrderProcessing(userId: String) {
        logger.error("주문 처리 실패: 결제는 완료되었으나 주문이 누락되었습니다: ($userId)")
    }

}
