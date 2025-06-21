package ch03.coffee

import io.kotest.core.spec.style.StringSpec
import main.ch03.coffee.Beverage
import main.ch03.coffee.beverage.*
import main.ch03.coffee.condiment.*

class StarbuzzCoffee : StringSpec({

    "순수 에스프레소" {
        val beverage = Espresso()

        printBeverageInfo(beverage)
    }

    "더블모카 휘핑크림" {
        var beverage: Beverage = DarkRoast()
        beverage = Mocha(beverage)
        beverage = Mocha(beverage)
        beverage = Whip(beverage)

        printBeverageInfo(beverage)
    }

    "하우스블렌디드 조합" {
        var beverage: Beverage = HouseBlend()
        beverage = Soy(beverage)
        beverage = Mocha(beverage)
        beverage = Whip(beverage)

        printBeverageInfo(beverage)
    }

})

private fun printBeverageInfo(beverage: Beverage) {
    println("주문메뉴: ${beverage.description}, 가격: $${beverage.cost()}")
}
