package main.chapter2.cafe

import java.math.BigDecimal

fun main() {
    var beverage: Beverage = HouseBlend(Beverage.Size.TALL)
    beverage = Mocha(beverage)
    beverage = Soy(beverage)
    beverage = Whip(beverage)

    println("${beverage.description} \$${beverage.price}")

    println("---------------------------------")
    println("사용자가 espresso와 mocha, whip을 선택한 경우")

    val beverageType = BeverageType.ESPRESSO
    val condiments = listOf(Condiment.MOCHA, Condiment.WHIP)

    val order = BeverageOrder(
        beverageType = beverageType,
        size = Beverage.Size.GRANDE,
        condiments = condiments,
    )

    val beverageV2 = createBeverage(order)
    println("${beverageV2.description} \$${beverageV2.price}")
}

abstract class Beverage {
    enum class Size {
        TALL,
        GRANDE,
        VENTI,
    }
    abstract val size: Size
    abstract val description: String
    abstract val price: BigDecimal
}

class Espresso(
    override val size: Size,
) : Beverage() {
    override val description: String
        get() = "Espresso"
    override val price: BigDecimal
        get() = 2000.toBigDecimal()
}

class HouseBlend(
    override val size: Size,
) : Beverage() {
    override val description: String
        get() = "House Blend Coffee"
    override val price: BigDecimal
        get() = 1500.toBigDecimal()
}

class DarkRoast(
    override val size: Size,
) : Beverage() {
    override val description: String
        get() = "Dark Roast Coffee"
    override val price: BigDecimal
        get() = 2000.toBigDecimal()
}

class Decaf(
    override val size: Size,
) : Beverage() {
    override val description: String
        get() = "Decaf Coffee"
    override val price: BigDecimal
        get() = 2000.toBigDecimal()
}

abstract class CondimentDecorator(
    val beverage: Beverage,
) : Beverage() {
    override val description: String
        get() = beverage.description
    override val price: BigDecimal
        get() = beverage.price
}

class Mocha(
    beverage: Beverage,
) : CondimentDecorator(beverage) {
    override val size: Size
        get() = beverage.size

    override val description: String
        get() = "${super.description}, Mocha"

    override val price: BigDecimal
        get() = super.price + 500.toBigDecimal()
}

class Soy(
    beverage: Beverage,
) : CondimentDecorator(beverage) {
    override val size: Size
        get() = beverage.size

    override val description: String
        get() = "${super.description}, Soy"

    override val price: BigDecimal
        get() = super.price + 300.toBigDecimal()
}

class Whip(
    beverage: Beverage,
) : CondimentDecorator(beverage) {
    override val size: Size
        get() = beverage.size

    override val description: String
        get() = "${super.description}, Whip"

    override val price: BigDecimal
        get() = super.price + 200.toBigDecimal()
}

enum class BeverageType {
    ESPRESSO,
    HOUSE_BLEND,
    DARK_ROAST,
    DECAF,
}

enum class Condiment {
    MOCHA,
    SOY,
    WHIP,
}

data class BeverageOrder(
    val beverageType: BeverageType,
    val size: Beverage.Size,
    val condiments: List<Condiment> = emptyList(),
)

fun createBeverage(
    beverageOrder: BeverageOrder,
): Beverage {
    val beverage = when (beverageOrder.beverageType) {
        BeverageType.ESPRESSO -> Espresso(beverageOrder.size)
        BeverageType.HOUSE_BLEND -> HouseBlend(beverageOrder.size)
        BeverageType.DARK_ROAST -> DarkRoast(beverageOrder.size)
        BeverageType.DECAF -> Decaf(beverageOrder.size)
    }

    return beverageOrder.condiments.fold(beverage) { acc, condiment ->
        when (condiment) {
            Condiment.MOCHA -> Mocha(acc)
            Condiment.SOY -> Soy(acc)
            Condiment.WHIP -> Whip(acc)
        }
    }
}