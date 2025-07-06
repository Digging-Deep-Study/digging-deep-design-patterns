package com.practice.chapter

fun main() {
    val news = EnumerableNews(
        listOf(
            SportsNews("Sports Update", "Local team wins championship!"),
            ItNews("Tech News", "New smartphone released with amazing features!")
        )
    )

    while (news.hasNext()) {
        val currentNews = news.next()
        println("Title: ${currentNews.title}, Content: ${currentNews.content}")
    }
}

class EnumerableNews(
    private val newsList: List<News>
) : Iterator<News> {
    private var currentIndex = 0

    override fun hasNext(): Boolean {
        return currentIndex < newsList.size
    }

    override fun next(): News {
        if(!hasNext()) {
            throw NoSuchElementException("No more elements in the iterator")
        }
        return newsList[currentIndex++]
    }
}

sealed class News(
    val title: String,
    val content: String
)

class SportsNews(title: String, content: String) : News(title, content)
class ItNews(title: String, content: String) : News(title, content)