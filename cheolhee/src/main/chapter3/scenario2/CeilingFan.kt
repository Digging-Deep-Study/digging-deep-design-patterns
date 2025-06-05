package main.chapter3.scenario2

object CeilingFan {
    var state: State = State.OFF

    enum class State {
        HIGH, MEDIUM, LOW, OFF
    }
}

class CeilingFanHigh : Command {
    override fun execute() {
        when (CeilingFan.state) {
            CeilingFan.State.HIGH -> return
            CeilingFan.State.MEDIUM -> CeilingFan.state = CeilingFan.State.HIGH
            CeilingFan.State.LOW -> CeilingFan.state = CeilingFan.State.MEDIUM
            CeilingFan.State.OFF -> CeilingFan.state = CeilingFan.State.LOW
        }

        println("${CeilingFan.state} 상태로 선풍기의 상태를 변경했습니다.")
    }

    override fun undo() {
        when (CeilingFan.state) {
            CeilingFan.State.HIGH -> CeilingFan.state = CeilingFan.State.MEDIUM
            CeilingFan.State.MEDIUM -> CeilingFan.state = CeilingFan.State.LOW
            CeilingFan.State.LOW -> CeilingFan.state = CeilingFan.State.OFF
            CeilingFan.State.OFF -> return
        }

        println("${CeilingFan.state} 상태로 선풍기의 상태를 변경했습니다.")
    }
}

class CeilingFanOff : Command {
    override fun execute() {
        when (CeilingFan.state) {
            CeilingFan.State.HIGH -> CeilingFan.state = CeilingFan.State.MEDIUM
            CeilingFan.State.MEDIUM -> CeilingFan.state = CeilingFan.State.LOW
            CeilingFan.State.LOW -> CeilingFan.state = CeilingFan.State.OFF
            CeilingFan.State.OFF -> return
        }

        println("${CeilingFan.state} 상태로 선풍기의 상태를 변경했습니다.")
    }

    override fun undo() {
        when (CeilingFan.state) {
            CeilingFan.State.HIGH -> return
            CeilingFan.State.MEDIUM -> CeilingFan.state = CeilingFan.State.HIGH
            CeilingFan.State.LOW -> CeilingFan.state = CeilingFan.State.MEDIUM
            CeilingFan.State.OFF -> CeilingFan.state = CeilingFan.State.LOW
        }

        println("${CeilingFan.state} 상태로 선풍기의 상태를 변경했습니다.")
    }
}