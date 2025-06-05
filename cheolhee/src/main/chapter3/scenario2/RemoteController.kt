package main.chapter3.scenario2

class RemoteController(
    private vararg val command: Command,
) {
    val commands: MutableList<Pair<Int, Command>> = mutableListOf()

    init {
        command.forEachIndexed { index, it ->
            val hasIndex = commands has { it.first == index }
            if (hasIndex) throw IllegalArgumentException("이미 등록된 인덱스입니다: $index")

            commands.add(index to it)
        }
    }

    fun addCommand(index: Int, command: Command) {
        val hasIndex = commands has { it.first == index }
        if (hasIndex) throw IllegalArgumentException("이미 등록된 인덱스입니다: $index")

        commands.add(index to command)
    }
}

infix fun <T> Iterable<T>.has(predicate: (T) -> Boolean) =
    this.any(predicate)

fun Pair<Int, Command>.executeCommand() =
    second.execute()

fun Pair<Int, Command>.undoCommand() =
    second.undo()