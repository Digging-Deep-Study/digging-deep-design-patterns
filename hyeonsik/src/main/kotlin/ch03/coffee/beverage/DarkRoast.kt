package main.ch03.coffee.beverage

import main.ch03.coffee.Beverage

class DarkRoast : Beverage(
    description = "다크로스트 커피",
) {

    override fun cost(): Double {
        return .99
    }

}