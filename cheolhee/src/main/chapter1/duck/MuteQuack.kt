package main.chapter1.duck

class MuteQuack: QuackBehavior {
    override fun quack() {
        println("<< Silence >>")
    }
}