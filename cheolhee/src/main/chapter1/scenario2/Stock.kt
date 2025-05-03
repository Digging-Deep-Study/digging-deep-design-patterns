package main.chapter1.scenario2

data class Stock(
    var quantity: Int,
    val observers: MutableList<Observer> = mutableListOf(),
) {
    private var issued: Boolean = false
    private var _quantity: Int = quantity
        set(value) {
            field = value
            if (field < 10) {
                if (!issued) {
                    issued = true
                    notifyObservers()
                }
            }
        }

    fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    private fun notifyObservers() {
        for (observer in observers) {
            observer.update(this)
        }
    }
}

