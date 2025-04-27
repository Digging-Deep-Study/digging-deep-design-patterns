package main.chapter1.weather

class WeatherData(
    private val observers: MutableList<Observer> = mutableListOf(),
    private var temperature: Float,
    private var humidity: Float,
    private var pressure: Float,
): Subject {
    override fun registerObserver(
        observer: Observer,
    ) {
        observers.add(observer)
    }

    override fun removeObserver(
        observer: Observer,
    ) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.parallelStream().forEach { observer ->
            observer.update(temperature, humidity, pressure)
        }
    }

    private fun measurementsChanged() {
        notifyObservers()
    }

    fun changeMeasurements(
        temperature: Float = this.temperature,
        humidity: Float = this.humidity,
        pressure: Float = this.pressure,
    ) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }
}