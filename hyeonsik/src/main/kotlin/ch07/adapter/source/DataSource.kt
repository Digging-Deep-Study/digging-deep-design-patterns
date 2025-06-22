abstract class DataSource {
    abstract fun connect()
    abstract fun query(query: String): String
}

