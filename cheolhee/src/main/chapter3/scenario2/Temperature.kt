package main.chapter3.scenario2

object Temperature {
    var value = 20
}

class IncreaseTemperatureCommand : Command {
    override fun execute() {
        Temperature.value += 1
        require(Temperature.value <= 40) {
            Temperature.value -= 1
            "40도면 식물 다 타죽어요"
        }

        println("온도를 ${Temperature.value}도로 증가시켰습니다.")
    }

    override fun undo() {
        Temperature.value -= 1
        require(Temperature.value >= 0) {
            Temperature.value += 1
            "0도면 식물 다 얼어요"
        }

        println("온도를 ${Temperature.value}도로 감소시켰습니다.")
    }
}

class DecreaseTemperatureCommand : Command {
    override fun execute() {
        Temperature.value -= 1
        require(Temperature.value >= 0) {
            Temperature.value += 1
            "0도면 식물 다 얼어요"
        }

        println("온도를 ${Temperature.value}도로 감소시켰습니다.")
    }

    override fun undo() {
        Temperature.value += 1
        require(Temperature.value <= 40) {
            Temperature.value -= 1
            "40도면 식물 다 타죽어요"
        }

        println("온도를 ${Temperature.value}도로 증가시켰습니다.")
    }
}