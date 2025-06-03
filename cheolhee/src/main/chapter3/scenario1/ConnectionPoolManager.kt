package main.chapter3.scenario1

import java.util.*

class ConnectionPoolManager {
    private val properties = ConfigurationScanner.load()
    val connection = Connection.of(properties)
    val connectionPools = JdbcTemplate.connect()
}

class ConfigurationScanner {
    companion object {
        fun load(): Map<String, String> = mapOf(
            "url" to "jdbc://mysql",
            "port" to "3306",
            "user" to "root",
            "password" to "abcd1234",
            "pool" to "5",
        )
    }
}

data class Connection private constructor(
    val url: String,
    val port: Int,
    val user: String,
    val password: String,
    val pool: Int,
) {
    companion object {
        fun of(properties: Map<String, String>) =
            with(properties) {
                Connection(
                    url = getValue("url"),
                    port = getValue("port").toInt(),
                    user = getValue("user"),
                    password = getValue("password"),
                    pool = getValue("pool").toInt(),
                )
            }
    }
}

data class ConnectionPool(
    val hash: String,
    var status: ConnectionPoolStatus,
    val query: String? = null,
)

enum class ConnectionPoolStatus {
    USABLE,
    POSSESSION,
}

object JdbcTemplate {
    fun connect() = Database.connections.apply {
        if (this.isEmpty()) throw IllegalStateException("사용가능한 커넥션 풀이 없습니다.")
    }
}

object Database {
    private val _connections = (1..300).map {
        ConnectionPool(
            hash = UUID.randomUUID().toString(),
            status = ConnectionPoolStatus.USABLE,
        )
    }.toMutableList()

    val connections = synchronized(_connections) {
        _connections.filter { it.status == ConnectionPoolStatus.USABLE }
            .take(5)
            .onEach { it.status = ConnectionPoolStatus.POSSESSION }
    }
}