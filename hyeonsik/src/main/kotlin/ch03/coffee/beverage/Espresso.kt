package main.ch03.coffee.beverage

import main.ch03.coffee.Beverage

class Espresso : Beverage(
    description = "에스프레소",
) {

    override fun cost(): Double {
        return 1.99
    }

}