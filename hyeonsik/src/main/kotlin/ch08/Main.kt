package main.ch08

fun main() {
    println("--- 전사 캐릭터 생성 ---")
    val warriorCreator = WarriorCreator()
    val warriorCreationProcess = warriorCreator.createCharacter()
    warriorCreationProcess.forEach { println(it) }

    println("\n--- 마법사 캐릭터 생성 ---")
    val mageCreator = MageCreator()
    val mageCreationProcess = mageCreator.createCharacter()
    mageCreationProcess.forEach { println(it) }

    println("\n--- 궁수 캐릭터 생성 ---")
    val archerCreator = ArcherCreator()
    val archerCreationProcess = archerCreator.createCharacter()
    archerCreationProcess.forEach { println(it) }
}
