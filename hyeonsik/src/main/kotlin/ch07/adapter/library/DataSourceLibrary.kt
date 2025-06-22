package main.ch07.adapter.library

class MySqlDataSource {
    fun connect() {
        println("MySQL 데이터베이스에 연결되었습니다.")
    }
    fun executeQuery(query: String): String {
        if (query.contains("NOW()", ignoreCase = true)) {
            return "MySQL 쿼리 결과: 현재 날짜/시간 데이터 (NOW() 처리됨)"
        }
        return "MySQL 쿼리 결과: $query"
    }
}

class PostgreSqlDataSource {
    fun connect() {
        println("PostgreSQL 데이터베이스에 연결되었습니다.")
    }
    fun run(query: String): String {
        if (query.contains("CURRENT_TIMESTAMP", ignoreCase = true)) {
            return "PostgreSQL 쿼리 결과: 현재 날짜/시간 데이터 (CURRENT_TIMESTAMP 처리됨)"
        }
        return "PostgreSQL 쿼리 결과: $query"
    }
}
