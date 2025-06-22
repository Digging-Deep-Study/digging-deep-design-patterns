package main.ch07.adapter

import DataSource
import main.ch07.adapter.library.MySqlDataSource
import main.ch07.adapter.library.PostgreSqlDataSource
import main.ch07.adapter.source.MySqlDataSourceAdapter
import main.ch07.adapter.source.PostgreSqlDataSourceAdapter

fun main() {
    println("--- MySQL 어댑터 테스트 ---")
    val mySqlAdapter: DataSource = MySqlDataSourceAdapter(MySqlDataSource())
    mySqlAdapter.connect()
    println(mySqlAdapter.query("SELECT GET_CURRENT_DATETIME() AS current_time FROM dual"))
    println(mySqlAdapter.query("SELECT * FROM users WHERE id = 1")) // 변환 X

    println("\n--- PostgreSQL 어댑터 테스트 ---")
    val postgreSqlAdapter: DataSource = PostgreSqlDataSourceAdapter(PostgreSqlDataSource())
    postgreSqlAdapter.connect()
    println(postgreSqlAdapter.query("SELECT GET_CURRENT_DATETIME() AS current_time"))
    println(postgreSqlAdapter.query("SELECT product_name FROM products WHERE price > 100")) // 변환 X
}