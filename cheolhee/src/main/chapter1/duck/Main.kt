package main.chapter1.duck

fun main() {
    val mallardDuck: Duck = MallardDuck()
    mallardDuck.fly()
    mallardDuck.quack()
    mallardDuck.display()
    mallardDuck.swim()

    println("--------------------")

    val rocketDuck: Duck = MallardDuck(FlyRocketPowered())
    rocketDuck.fly()
    rocketDuck.quack()
    rocketDuck.display()
    rocketDuck.swim()
}