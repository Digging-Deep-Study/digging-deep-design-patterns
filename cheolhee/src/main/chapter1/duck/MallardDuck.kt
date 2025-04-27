package main.chapter1.duck

class MallardDuck(
    flyBehavior: FlyBehavior = FlyWithWings(),
    quackBehavior: QuackBehavior = Quack(),
): Duck(flyBehavior, quackBehavior)