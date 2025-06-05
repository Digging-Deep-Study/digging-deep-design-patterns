package main.chapter3.scenario2

fun main() {
    val remoteController = RemoteController(
        LightOnCommand(),
        LightOffCommand(),
        CeilingFanHigh(),
        CeilingFanOff(),
        StereoOnForCD(),
        StereoOff(),
        GarageDoorOpen(),
        GarageDoorClose(),
        IncreaseTemperatureCommand(),
        DecreaseTemperatureCommand(),
    )

    remoteController.commands[0].executeCommand()
    remoteController.commands[1].executeCommand()
    remoteController.commands[2].executeCommand()
    remoteController.commands[3].executeCommand()
    remoteController.commands[4].executeCommand()
    remoteController.commands[5].executeCommand()
    remoteController.commands[5].undoCommand()
    remoteController.commands[6].executeCommand()
    remoteController.commands[7].executeCommand()
    remoteController.commands[8].executeCommand()
    remoteController.commands[9].executeCommand()
}