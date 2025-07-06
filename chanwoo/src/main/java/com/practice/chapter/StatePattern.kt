package com.practice.chapter

fun main() {
    val player = MusicPlayer()

    player.play()
    player.pause()
    player.play()
    player.stop()
    player.pause()
}

interface PlayerState {
    fun play(context: MusicPlayer)
    fun pause(context: MusicPlayer)
    fun stop(context: MusicPlayer)
}

class StoppedState : PlayerState {
    override fun play(context: MusicPlayer) {
        println("play")
        context.setState(PlayingState())
    }

    override fun pause(context: MusicPlayer) {
        throw RuntimeException("재생 중이 아닙니다. 먼저 재생해주세요.")
    }

    override fun stop(context: MusicPlayer) {
        throw RuntimeException("이미 정지 상태입니다.")
    }
}

class PlayingState : PlayerState {
    override fun play(context: MusicPlayer) {
        throw RuntimeException("이미 재생 중입니다.")
    }

    override fun pause(context: MusicPlayer) {
        println("pause")
        context.setState(PausedState())
    }

    override fun stop(context: MusicPlayer) {
        println("stop")
        context.setState(StoppedState())
    }
}

class PausedState : PlayerState {
    override fun play(context: MusicPlayer) {
        println("resume")
        context.setState(PlayingState())
    }

    override fun pause(context: MusicPlayer) {
        throw RuntimeException("이미 일시 정지 상태입니다.")
    }

    override fun stop(context: MusicPlayer) {
        println("stop")
        context.setState(StoppedState())
    }
}

class MusicPlayer {
    private var state: PlayerState = StoppedState()

    fun setState(newState: PlayerState) {
        state = newState
    }

    fun play() = state.play(this)
    fun pause() = state.pause(this)
    fun stop() = state.stop(this)
}
