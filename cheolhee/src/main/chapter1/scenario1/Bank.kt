package main.chapter1.scenario1

enum class Bank {
    KAKAO,
    TOSS,
    SHINHAN, ;

    companion object {
        fun random() = entries.random()
    }
}