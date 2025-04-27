package main.chapter1.weather

fun main() {
    val weatherData = WeatherData(temperature = 80f, humidity = 65f, pressure = 30.4f)
    val currentConditionsDisplay = CurrentConditionsDisplay(weatherData)
    val statisticsDisplay = StatisticsDisplay(weatherData)
    val forecastDisplay = ForecastDisplay(weatherData)

    weatherData.changeMeasurements(82f, 70f, 29.2f)
    println("--------------------")
    weatherData.changeMeasurements(78f, 90f, 29.2f)
    println("--------------------")
    weatherData.changeMeasurements(85f, 85f, 29.2f)
}