package main.ch07.facade

fun main() {
    val videoFacade = VideoPlayerFacade()
    val outputs = videoFacade.playVideo("my_favorite_movie.mp4")

    outputs.forEach { println(it) }
}
