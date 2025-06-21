package main.ch03.coffee.beverage

import main.ch03.coffee.Beverage

class HouseBlend : Beverage(
    description = "하우스 블랜드 커피",
) {

    override fun cost(): Double {
        return .89
    }

}