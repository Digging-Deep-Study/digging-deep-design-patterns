package main.chapter2.pizza

fun main() {
    val nyStore = NYStylePizzaStore()
    val chicagoStore = ChicagoStylePizzaStore()

    val nyPizza = nyStore.orderPizza("cheese")
    println("Ethan ordered a ${nyPizza.javaClass.simpleName}")

    val chicagoPizza = chicagoStore.orderPizza("veggie")
    println("Ethan ordered a ${chicagoPizza.javaClass.simpleName}")
}

abstract class PizzaStore {
    abstract fun createPizza(type: String): Pizza

    fun orderPizza(type: String) =
        createPizza(type).apply {
            prepare()
            bake()
            cut()
            box()
        }
}

interface Pizza {
    fun prepare()
    fun bake() { println("Baking") }
    fun cut() { println("Cutting") }
    fun box() { println("Boxing") }
}

class NYStylePizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        val ingredientFactory = NYStylePizzaIngredientFactory()
        return when (type) {
            "cheese" -> CheesePizza(ingredientFactory)
            "veggie" -> VeggiePizza(ingredientFactory)
            else -> throw IllegalArgumentException("Unknown pizza type: $type")
        }
    }
}

class ChicagoStylePizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        val ingredientFactory = ChicagoStylePizzaIngredientFactory()
        return when (type) {
            "cheese" -> CheesePizza(ingredientFactory)
            "veggie" -> VeggiePizza(ingredientFactory)
            else -> throw IllegalArgumentException("Unknown pizza type: $type")
        }
    }
}

interface PizzaIngredientFactory {
    fun createDough(): Dough
    fun createSauce(): Sauce
    fun createCheese(): Cheese
    fun createVeggies(): List<Veggie>
    fun createPepperoni(): Pepperoni
    fun createClam(): Clam
}

class NYStylePizzaIngredientFactory : PizzaIngredientFactory {
    override fun createDough(): Dough = MilkDough()
    override fun createSauce(): Sauce = HotSauce()
    override fun createCheese(): Cheese = MozzarellaCheese()
    override fun createVeggies(): List<Veggie> = listOf(GrilledAnion(), GrilledGarlic())
    override fun createPepperoni(): Pepperoni = SlicedPepperoni()
    override fun createClam(): Clam = FreshClam()
}

class ChicagoStylePizzaIngredientFactory : PizzaIngredientFactory {
    override fun createDough(): Dough = MilkDough()
    override fun createSauce(): Sauce = HotSauce()
    override fun createCheese(): Cheese = MozzarellaCheese()
    override fun createVeggies(): List<Veggie> = listOf(GrilledAnion(), GrilledGarlic())
    override fun createPepperoni(): Pepperoni = SlicedPepperoni()
    override fun createClam(): Clam = FreshClam()
}

abstract class Veggie {
    abstract val name: String
}

abstract class Dough {
    abstract val name: String
    override fun toString(): String {
        return name
    }
}

abstract class Sauce {
    abstract val name: String
    override fun toString() = name
}

abstract class Cheese {
    abstract val name: String
    override fun toString() = name
}

abstract class Pepperoni {
    abstract val name: String
    override fun toString() = name
}

abstract class Clam {
    abstract val name: String
    override fun toString() = name
}

class MilkDough : Dough() {
    override val name: String
        get() = "Milk Dough"
    override fun toString() = name
}

class HotSauce : Sauce() {
    override val name: String
        get() = "NY Style Sauce"
    override fun toString() = name
}

class MozzarellaCheese : Cheese() {
    override val name: String
        get() = "Mozzarella Cheese"
    override fun toString() = name
}

class GrilledAnion : Veggie() {
    override val name: String
        get() = "Grilled Onion"
    override fun toString() = name
}

class GrilledGarlic : Veggie() {
    override val name: String
        get() = "Grilled Garlic"
    override fun toString() = name
}

class SlicedPepperoni : Pepperoni() {
    override val name: String
        get() = "Sliced Pepperoni"
    override fun toString() = name
}

class FreshClam : Clam() {
    override val name: String
        get() = "Fresh Clam"
    override fun toString() = name
}

class CheesePizza(
    private val ingredientFactory: PizzaIngredientFactory,
) : Pizza {
    private val dough = ingredientFactory.createDough()
    private val sauce = ingredientFactory.createSauce()
    private val cheese = ingredientFactory.createCheese()

    override fun prepare() {
        println("Preparing $dough, $sauce, $cheese")
    }
}

class VeggiePizza(
    private val ingredientFactory: PizzaIngredientFactory,
) : Pizza {
    private val dough = ingredientFactory.createDough()
    private val sauce = ingredientFactory.createSauce()
    private val cheese = ingredientFactory.createCheese()
    private val veggies = ingredientFactory.createVeggies()

    override fun prepare() {
        println("Preparing $dough, $sauce, $cheese, $veggies")
    }
}