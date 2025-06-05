package main.chapter3.scenario2

object GarageDoor {
    var state: State = State.CLOSED

    enum class State {
        OPENED, CLOSED
    }
}

class GarageDoorOpen : Command {
    override fun execute() {
        if (GarageDoor.state == GarageDoor.State.OPENED) return
        GarageDoor.state = GarageDoor.State.OPENED

        println("차고 문이 열렸습니다.")
    }

    override fun undo() {
        if (GarageDoor.state == GarageDoor.State.CLOSED) return
        GarageDoor.state = GarageDoor.State.CLOSED

        println("차고 문이 닫혔습니다.")
    }
}

class GarageDoorClose : Command {
    override fun execute() {
        if (GarageDoor.state == GarageDoor.State.CLOSED) return
        GarageDoor.state = GarageDoor.State.CLOSED

        println("차고 문이 닫혔습니다.")
    }

    override fun undo() {
        if (GarageDoor.state == GarageDoor.State.OPENED) return
        GarageDoor.state = GarageDoor.State.OPENED

        println("차고 문이 열렸습니다.")
    }
}