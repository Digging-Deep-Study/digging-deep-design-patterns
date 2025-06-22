package main.ch07.adapter.source

import DataSource
import main.ch07.adapter.library.MySqlDataSource
import main.ch07.adapter.library.PostgreSqlDataSource

class MySqlDataSourceAdapter(private val mySqlDataSource: MySqlDataSource): DataSource() {
    override fun connect() {
        mySqlDataSource.connect()
    }

    override fun query(query: String): String {
        var adaptedQuery = query

        if (adaptedQuery.contains("GET_CURRENT_DATETIME()", ignoreCase = true)) {
            println("MySqlDataSourceAdapter: 'GET_CURRENT_DATETIME()'을 MySQL의 'NOW()'로 치환합니다.")
            adaptedQuery = adaptedQuery.replace("GET_CURRENT_DATETIME()", "NOW()")
        }

        return mySqlDataSource.executeQuery(adaptedQuery)
    }
}

class PostgreSqlDataSourceAdapter(private val postgreSqlDataSource: PostgreSqlDataSource): DataSource() {
    override fun connect() {
        postgreSqlDataSource.connect()
    }

    override fun query(query: String): String {
        var adaptedQuery = query

        if (adaptedQuery.contains("GET_CURRENT_DATETIME()", ignoreCase = true)) {
            println("PostgreSqlDataSourceAdapter: 'GET_CURRENT_DATETIME()'을 PostgreSQL의 'CURRENT_TIMESTAMP'로 치환합니다.")
            adaptedQuery = adaptedQuery.replace("GET_CURRENT_DATETIME()", "CURRENT_TIMESTAMP")
        }

        return postgreSqlDataSource.run(adaptedQuery) // PostgreSqlDataSource는 run() 메서드 사용
    }
}
