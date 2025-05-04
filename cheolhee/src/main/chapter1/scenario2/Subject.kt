package main.chapter1.scenario2

interface Subject {
    fun registerObserver(vararg observer: Observer)
    fun removeObserver(vararg observer: Observer)
    fun notifyObservers()
}