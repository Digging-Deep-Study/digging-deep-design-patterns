package main.chapter1.weather

interface Observer {
    fun update(
        temperature: Float,
        humidity: Float,
        pressure: Float,
    )
}