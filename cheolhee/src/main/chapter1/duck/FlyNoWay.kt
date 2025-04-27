package main.chapter1.duck

class FlyNoWay: FlyBehavior {
    override fun fly() {
        println("I can't fly!")
    }
}