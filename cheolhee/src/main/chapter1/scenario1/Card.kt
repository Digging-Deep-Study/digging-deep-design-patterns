package main.chapter1.scenario1

data class Card(
    val cardNumber: String,
    val cardHolder: String,
    val expirationDate: String,
    val cvv: String,
    val bank: Bank,
)