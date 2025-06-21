package main.ch03.coffee

abstract class CondimentDecorator(
    val beverage: Beverage,
) : Beverage() {
}