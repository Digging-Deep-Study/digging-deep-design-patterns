package main.ch03.coffee

abstract class Beverage(
    open var description: String = "제목 없음",
    open var size: Size = Size.TALL,
) {

    abstract fun cost(): Double

}

enum class Size {
    TALL, GRANDE, VENTI
}
