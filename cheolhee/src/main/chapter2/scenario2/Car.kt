package main.chapter2.scenario2

abstract class Car : Driveable {
    abstract val name: String
    abstract val maxSpeed: Int
}

abstract class SportsCar : Car()
abstract class SUV : Car()

interface CarPartFactory {
    fun createEngine(): Engine
    fun createTire(): Tire
    fun createBody(): Body
}

class Ferrari(
    private val carPartFactory: CarPartFactory,
) : SportsCar() {
    override val name: String = "Ferrari"
    override val maxSpeed: Int = 350
    override fun drive() {
        val engine = carPartFactory.createEngine()
        val tire = carPartFactory.createTire()
        val body = carPartFactory.createBody()
        println("${name}은 ${engine.type} 엔진과 ${tire.size}인치 타이어, ${body.color} 바디를 장착하고 최대 속도 ${maxSpeed}km/h로 주행합니다.")
    }
}

class Lamborghini(
    private val carPartFactory: CarPartFactory,
) : SportsCar() {
    override val name: String = "Lamborghini"
    override val maxSpeed: Int = 340
    override fun drive() {
        val engine = carPartFactory.createEngine()
        val tire = carPartFactory.createTire()
        val body = carPartFactory.createBody()

        println("${name}은 ${engine.type} 엔진과 ${tire.size}인치 타이어, ${body.color} 바디를 장착하고 최대 속도 ${maxSpeed}km/h로 주행합니다.")
    }
}

class Porsche(
    private val carPartFactory: CarPartFactory,
) : SportsCar() {
    override val name: String = "Porsche"
    override val maxSpeed: Int = 330
    override fun drive() {
        val engine = carPartFactory.createEngine()
        val tire = carPartFactory.createTire()
        val body = carPartFactory.createBody()

        println("${name}은 ${engine.type} 엔진과 ${tire.size}인치 타이어, ${body.color} 바디를 장착하고 최대 속도 ${maxSpeed}km/h로 주행합니다.")
    }
}

class Jeep(
    private val carPartFactory: CarPartFactory,
) : SUV() {
    override val name: String = "Jeep"
    override val maxSpeed: Int = 200
    override fun drive() {
        val engine = carPartFactory.createEngine()
        val tire = carPartFactory.createTire()
        val body = carPartFactory.createBody()

        println("${name}은 ${engine.type} 엔진과 ${tire.size}인치 타이어, ${body.color} 바디를 장착하고 최대 속도 ${maxSpeed}km/h로 주행합니다.")
    }
}

class RangeRover(
    private val carPartFactory: CarPartFactory,
) : SUV() {
    override val name: String = "Range Rover"
    override val maxSpeed: Int = 220
    override fun drive() {
        val engine = carPartFactory.createEngine()
        val tire = carPartFactory.createTire()
        val body = carPartFactory.createBody()

        println("${name}은 ${engine.type} 엔진과 ${tire.size}인치 타이어, ${body.color} 바디를 장착하고 최대 속도 ${maxSpeed}km/h로 주행합니다.")
    }
}