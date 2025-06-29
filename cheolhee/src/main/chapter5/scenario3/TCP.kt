package main.chapter5.scenario3

fun main() {
    val tcp = TCP()

    tcp.open()
    tcp.receiveMessage()

    tcp.receiveMessage()

    tcp.receiveMessage()
    tcp.close()
}

sealed interface State {
    fun open()
    fun close()
}

class CloseStatus : State {
    override fun open() {
        println("TCP 커넥션을 열었습니다.")
    }
    override fun close() {
        error("TCP 커넥션이 이미 닫혀 있습니다. close()를 다시 호출할 수 없습니다.")
    }
}

class ListenStatus : State {
    override fun open() {
        error("TCP 커넥션이 이미 열려 있습니다. open()을 다시 호출할 수 없습니다.")
    }
    override fun close() {
        println("TCP 커넥션을 닫았습니다.")
    }
}

class EstablishedStatus : State {
    override fun open() {
        error("TCP 커넥션이 이미 열려 있습니다. open()을 다시 호출할 수 없습니다.")
    }
    override fun close() {
        println("TCP 커넥션을 닫았습니다.")
    }
}

class FinWaitStatus : State {
    override fun open() {
        error("TCP 커넥션이 이미 열려 있습니다. open()을 다시 호출할 수 없습니다.")
    }
    override fun close() {
        println("TCP 커넥션을 닫았습니다.")
    }
}

object Heap {
    var data = mutableListOf<String>()
}

class TCP(
    private var state: State = CloseStatus()
) {
    private val closeStatus: State = CloseStatus()
    private val listenStatus: State = ListenStatus()
    private val establishedStatus: State = EstablishedStatus()
    private val finWaitStatus: State = FinWaitStatus()

    fun receiveMessage() {
        when (state) {
            is CloseStatus -> error("TCP Connection이 닫혀 있습니다. 먼저 open()을 호출하세요.")

            is ListenStatus -> {
                println("연결 요청(SYN)을 수신했습니다.")
                state = establishedStatus
            }

            is EstablishedStatus -> {
                println("데이터 메시지를 수신했습니다.")
                Heap.data.add("데이터 메시지")
                state = finWaitStatus
            }

            is FinWaitStatus -> {
                println("잔여 데이터를 수신했습니다. (종료 중인 연결)")
            }
        }
    }

    fun open() {
        state.open()
        when (state) {
            is CloseStatus -> {
                state = listenStatus
            }

            is ListenStatus,
            is EstablishedStatus,
            is FinWaitStatus -> {}
        }
    }

    fun close() {
        state.close()
        when (state) {
            is CloseStatus -> {}

            is ListenStatus,
            is EstablishedStatus,
            is FinWaitStatus -> {
                state = closeStatus
            }
        }
    }
}
