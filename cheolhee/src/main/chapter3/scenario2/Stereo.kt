package main.chapter3.scenario2

object Stereo {
    var state: State = State.OFF
    var volume: Int = 20

    enum class State {
        ON, OFF
    }
}

class StereoOnForCD : Command {
    override fun execute() {
        Stereo.state = Stereo.State.ON
        Stereo.volume += 1

        require(Stereo.volume < 100) {
            Stereo.volume -= 1
            "볼륨은 100을 넘을 수 없습니다."
        }

        println("볼륨을 올렸습니다. 현재 볼륨: ${Stereo.volume}")
    }

    override fun undo() {
        Stereo.state = Stereo.State.ON
        Stereo.volume -= 1

        require(Stereo.volume >= 0) {
            Stereo.volume += 1
            "볼륨은 0보다 작을 수 없습니다."
        }

        println("볼륨을 줄였습니다. 현재 볼륨: ${Stereo.volume}")
    }
}

class StereoOff : Command {
    override fun execute() {
        Stereo.state = Stereo.State.OFF

        println("음소거되었습니다.")
    }

    override fun undo() {
        Stereo.state = Stereo.State.ON

        println("음소거가 해제되었습니다. 현재 볼륨: ${Stereo.volume}")
    }
}