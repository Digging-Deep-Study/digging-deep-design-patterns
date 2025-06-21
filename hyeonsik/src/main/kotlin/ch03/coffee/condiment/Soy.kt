package main.ch03.coffee.condiment

import main.ch03.coffee.Beverage
import main.ch03.coffee.CondimentDecorator

class Soy(
    beverage: Beverage,
) : CondimentDecorator(
    beverage = beverage
) {
    override var description: String = ""
        get() = beverage.description + ", 두유"

    override fun cost(): Double {
        return beverage.cost() + .15
    }
}
