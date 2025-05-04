package main.chapter1.scenario2

import java.math.BigDecimal

data class Goods(
    val id: Long,
    val quantity: Int,
    val price: BigDecimal,
) {
    init {
        require(quantity > 0) { "구매 수량은 0보다 커야 합니다." }
        require(price > BigDecimal.ZERO) { "구매 가격은 0보다 커야 합니다." }
    }
}

data class GoodsEntity(
    val id: Long,
    val name: String,
    val price: BigDecimal,
    private var _quantity: Int,
    val observers: MutableList<Observer> = mutableListOf(),
): Subject {
    init {
        require(_quantity >= 0) { "재고는 0개 이상이어야 합니다." }
    }

    private var alreadyIssued: Boolean = false

    var quantity: Int = _quantity
        set(value) {
            field = value
            if (field < 10) {
                if (alreadyIssued.not()) {
                    alreadyIssued = true
                    notifyObservers()
                }
            }

            if (field < 0) {
                throw IllegalStateException("재고가 부족합니다.")
            }
        }

    override fun registerObserver(vararg observer: Observer) {
        for (obs in observer) {
            observers.add(obs)
        }
    }

    override fun removeObserver(vararg observer: Observer) {
        for (obs in observer) {
            observers.remove(obs)
        }
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update(this)
        }
    }
}