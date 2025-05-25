package main.chapter2.scenario2

interface CarFactory {
    fun orderCar(type: String): Car {
        val engine = createEngine()
        val tire = createTire()
        val body = createBody()
        val car = createCar(
            engine = engine,
            tire = tire,
            body = body
        )

        println("Car: ${car.name}, Engine: ${engine.type}, Tire: ${tire.size}, Body: ${body.color}")
        return car
    }

    fun createEngine(): Engine
    fun createTire(): Tire
    fun createBody(): Body
    fun createCar(engine: Engine, tire: Tire, body: Body): Car
}

class Engine(val type: String)
class Tire(val size: Int)
class Body(val color: String)

interface SportsCarPartFactory : CarPartFactory
interface SUVPartFactory : CarPartFactory

class FerrariPartFactory : SportsCarPartFactory, CarFactory {
    override fun createEngine() = Engine("V8")
    override fun createTire() = Tire(20)
    override fun createBody() = Body("Red")
    override fun createCar(engine: Engine, tire: Tire, body: Body) = Ferrari(this)
}

class LamborghiniPartFactory : SportsCarPartFactory, CarFactory {
    override fun createEngine() = Engine("V10")
    override fun createTire() = Tire(21)
    override fun createBody() = Body("Yellow")
    override fun createCar(engine: Engine, tire: Tire, body: Body) = Lamborghini(this)
}

class PorschePartFactory : SportsCarPartFactory, CarFactory {
    override fun createEngine() = Engine("Flat-6")
    override fun createTire() = Tire(19)
    override fun createBody() = Body("Blue")
    override fun createCar(engine: Engine, tire: Tire, body: Body) = Porsche(this)
}

class JeepPartFactory : SUVPartFactory, CarFactory {
    override fun createEngine() = Engine("V6")
    override fun createTire() = Tire(18)
    override fun createBody() = Body("Green")
    override fun createCar(engine: Engine, tire: Tire, body: Body) = Jeep(this)
}

class RangeRoverPartFactory : SUVPartFactory, CarFactory {
    override fun createEngine() = Engine("V8")
    override fun createTire() = Tire(19)
    override fun createBody() = Body("Black")
    override fun createCar(engine: Engine, tire: Tire, body: Body) = RangeRover(this)
}

