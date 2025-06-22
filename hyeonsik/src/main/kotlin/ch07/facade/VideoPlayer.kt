package main.ch07.facade

class VideoStreamDecoder {
    fun decode(fileName: String): String {
        return "$fileName 디코딩 중..."
    }

    fun close(): String {
        return "디코더 종료."
    }
}

class AudioRenderer {
    fun renderAudio(decodedData: String): String {
        return "$decodedData 오디오 렌더링 중..."
    }
}

class SceneRenderer {
    fun renderScene(decodedData: String): String {
        return "$decodedData 장면 렌더링 중..."
    }
}

class VideoPlayer {
    fun playMedia(fileName: String): String {
        return "비디오 파일 재생 시작: $fileName"
    }

    fun stopMedia(fileName: String): String {
        return "비디오 파일 재생 완료: $fileName"
    }
}

class VideoPlayerFacade {
    private val decoder = VideoStreamDecoder()
    private val audioRenderer = AudioRenderer()
    private val sceneRenderer = SceneRenderer()
    private val videoPlayer = VideoPlayer()

    fun playVideo(fileName: String): List<String> {
        val log = mutableListOf<String>()

        log.add(videoPlayer.playMedia(fileName))
        val decodedData = decoder.decode(fileName)
        log.add(decodedData)

        // while (true){  // 매 프레임마다 렌더링한다고 대충 가정 ...
            log.add(audioRenderer.renderAudio(decodedData))
            log.add(sceneRenderer.renderScene(decodedData))
        // }

        log.add(videoPlayer.stopMedia(fileName))
        log.add(decoder.close())

        return log
    }
}

