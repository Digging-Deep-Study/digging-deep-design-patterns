package main.chapter1.duck

abstract class Duck(
    private val flyBehavior: FlyBehavior,
    private val quackBehavior: QuackBehavior,
): FlyBehavior by flyBehavior,
    QuackBehavior by quackBehavior {

    fun swim() {
        println("Duck is swimming")
    }
    fun display() {
        println("Duck is displaying")
    }
}