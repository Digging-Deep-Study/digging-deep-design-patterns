package main.chapter3.scenario2

object Light {
    var state: State = State.OFF

    enum class State {
        ON, OFF
    }
}

class LightOnCommand : Command {
    override fun execute() {
        Light.state = Light.State.ON
        println("조명이 켜졌습니다.")
    }

    override fun undo() {
        Light.state = Light.State.OFF
        println("조명이 꺼졌습니다.")
    }
}

class LightOffCommand : Command {
    override fun execute() {
        Light.state = Light.State.OFF
        println("조명이 꺼졌습니다.")
    }

    override fun undo() {
        Light.state = Light.State.ON
        println("조명이 켜졌습니다.")
    }
}