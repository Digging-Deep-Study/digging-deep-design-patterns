package main.chapter5.scenario1

fun main() {
    val inventory = Inventory(
        equipment = listOf(
            Equipment(name = "Sword", quantity = 1, type = "Weapon", level = 5),
            Equipment(name = "Shield", quantity = 1, type = "Armor", level = 3)
        ),
        consumables = listOf(
            Consumable(name = "Health Potion", quantity = 10, effect = "Restores 50 HP"),
            Consumable(name = "Mana Potion", quantity = 5, effect = "Restores 30 MP")
        ),
        questItems = listOf(
            QuestItem(name = "Ancient Artifact", quantity = 1, questId = "Q123"),
            QuestItem(name = "Mystic Scroll", quantity = 2, questId = "Q456")
        )
    )

    inventory.equipment.forEach { println("Equipment: ${it.name}, Type: ${it.type}, Level: ${it.level}") }
}

data class Inventory(
    val equipment: List<Equipment>,
    val consumables: List<Consumable>,
    val questItems: List<QuestItem>,
)

abstract class Item {
    abstract val name: String
    abstract val quantity: Int
}

data class Equipment(
    override val name: String,
    override val quantity: Int,
    val type: String,
    val level: Int,
): Item()

data class Consumable(
    override val name: String,
    override val quantity: Int,
    val effect: String,
): Item()

data class QuestItem(
    override val name: String,
    override val quantity: Int,
    val questId: String,
): Item()