package main.chapter2.scenario2

interface Item {
    fun use()
}

enum class ItemType {
    WEAPON, ARMOR
}

class Weapon : Item {
    override fun use() = println("무기를 사용합니다.")
}

class Armor : Item {
    override fun use() = println("방어구를 사용합니다.")
}

object ItemCreator {
    fun createItem(
        type: ItemType,
    ) =
        when (type) {
            ItemType.WEAPON -> Weapon()
            ItemType.ARMOR -> Armor()
        }
}

fun main() {
    val weapon = ItemCreator.createItem(ItemType.WEAPON)
    val armor = ItemCreator.createItem(ItemType.ARMOR)

    weapon.use()
    armor.use()
}