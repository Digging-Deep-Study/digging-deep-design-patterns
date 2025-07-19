package main.chapter6.scenario2

sealed interface Command {
    fun execute()
}

interface Device {
    var state: State
    fun turnOn()
    fun turnOff()
}

interface State {
    fun turnOn(device: Device)
    fun turnOff(device: Device)
}

interface UI {
    fun display()
}

object OnState : State {
    override fun turnOn(device: Device) {
        println("${device.javaClass.simpleName} is already ON")
    }

    override fun turnOff(device: Device) {
        println("${device.javaClass.simpleName} is turning OFF")
        device.state = OffState
    }
}

object OffState : State {
    override fun turnOn(device: Device) {
        println("${device.javaClass.simpleName} is turning ON")
        device.state = OnState
    }

    override fun turnOff(device: Device) {
        println("${device.javaClass.simpleName} is already OFF")
    }
}

class Light : Device {
    override var state: State = OffState
    override fun turnOn() = state.turnOn(this)
    override fun turnOff() = state.turnOff(this)
}

class AirConditioner : Device {
    override var state: State = OffState
    override fun turnOn() = state.turnOn(this)
    override fun turnOff() = state.turnOff(this)
}

class Boiler : Device {
    override var state: State = OffState
    override fun turnOn() = state.turnOn(this)
    override fun turnOff() = state.turnOff(this)
}

class TurnOnCommand(val device: Device) : Command {
    override fun execute() = device.turnOn()
}

class TurnOffCommand(val device: Device) : Command {
    override fun execute() = device.turnOff()
}

interface Subject {
    fun register(observer: Observer)
    fun unregister(observer: Observer)
    fun notify(command: Command)
}

interface Observer {
    fun update(command: Command)
}

class RemoteController : Subject {
    private val observers = mutableListOf<Observer>()

    override fun register(observer: Observer) {
        observers.add(observer)
    }

    override fun unregister(observer: Observer) {
        observers.remove(observer)
    }

    override fun notify(command: Command) {
        observers.forEach { it.update(command) }
    }

    fun press(command: Command) {
        command.execute()
        notify(command)
    }
}

class MobileApp : Observer, UI {
    private var lastChangedState: Device? = null
    private val light: Light = Light()
    private val airConditioner: AirConditioner = AirConditioner()
    private val boiler: Boiler = Boiler()

    override fun update(command: Command) {
        when(command) {
            is TurnOnCommand -> {
                when (command.device) {
                    is Light -> light.turnOn()
                    is AirConditioner -> airConditioner.turnOn()
                    is Boiler -> boiler.turnOn()
                }
                lastChangedState = command.device
            }
            is TurnOffCommand -> {
                when (command.device) {
                    is Light -> light.turnOff()
                    is AirConditioner -> airConditioner.turnOff()
                    is Boiler -> boiler.turnOff()
                }
                lastChangedState = command.device
            }
        }
        display()
    }

    override fun display() {
        requireNotNull(lastChangedState)
        when (lastChangedState) {
            is Light -> {
                when ((lastChangedState as Light).state) {
                    is OnState -> println("불이 켜진 UI를 표시합니다")
                    is OffState -> println("불이 꺼진 UI를 표시합니다")
                }
            }
            is AirConditioner -> {
                when ((lastChangedState as AirConditioner).state) {
                    is OnState -> println("에어컨이 켜진 UI를 표시합니다")
                    is OffState -> println("에어컨이 꺼진 UI를 표시합니다")
                }
            }
            is Boiler -> {
                when ((lastChangedState as Boiler).state) {
                    is OnState -> println("보일러가 켜진 UI를 표시합니다")
                    is OffState -> println("보일러가 꺼진 UI를 표시합니다")
                }
            }
        }
    }
}
