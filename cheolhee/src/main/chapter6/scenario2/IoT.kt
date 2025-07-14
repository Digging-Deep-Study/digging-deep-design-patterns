package main.chapter6.scenario2

sealed interface Command {
    fun execute()
}

class CompositeCommand : Command {
    private val commands = mutableListOf<Command>()

    fun add(command: Command) = commands.add(command)

    override fun execute() {
        commands.forEach { it.execute() }
    }
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

class TurnOnCommand(private val device: Device) : Command {
    override fun execute() = device.turnOn()
}

class TurnOffCommand(private val device: Device) : Command {
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

class MobileApp : Observer {
    override fun update(command: Command) {
        when(command) {
            is TurnOnCommand -> command.execute()
            is TurnOffCommand -> command.execute()
            is CompositeCommand -> command.execute()
        }
    }
}
