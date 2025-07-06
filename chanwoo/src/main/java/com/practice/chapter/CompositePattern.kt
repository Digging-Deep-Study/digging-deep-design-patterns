package com.practice.chapter

fun main() {
    val rootFolder = Folder("Root")
    val subFolder1 = Folder("SubFolder1")
    val subFolder2 = Folder("SubFolder2")

    val file1 = File("File1.txt", 100)
    val file2 = File("File2.txt", 200)

    subFolder1.add(file1)
    subFolder2.add(file2)

    rootFolder.add(subFolder1)
    rootFolder.add(subFolder2)

    println("Root folder contains:")
    println("${rootFolder.name} with size ${rootFolder.size}")
    rootFolder.components.forEach {
        println("- ${it.name} with size ${it.size}")
    }
}

sealed class FileComponent {
    abstract val name: String
    abstract val size: Int
}

class File(
    override val name: String,
    override val size: Int,
) : FileComponent()

class Folder(
    override val name: String,
) : FileComponent() {
    val components = mutableListOf<FileComponent>()

    override val size: Int
        get() = components.sumOf { it.size }

    fun add(component: FileComponent) {
        components.add(component)
    }

    fun remove(component: FileComponent) {
        components.remove(component)
    }
}