package main.chapter1.weather

class StatisticsDisplay(
    weatherData: WeatherData,
    private var temperature: Float = 0f,
    private var humidity: Float = 0f,
    private var pressure: Float = 0f,
) : Observer, DisplayElement {
    init {
        weatherData.registerObserver(this)
    }

    override fun update(
        temperature: Float,
        humidity: Float,
        pressure: Float,
    ) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        display()
    }

    override fun display() {
        println("Statistics: $temperature F degrees and $humidity% humidity and $pressure pressure")
    }
}