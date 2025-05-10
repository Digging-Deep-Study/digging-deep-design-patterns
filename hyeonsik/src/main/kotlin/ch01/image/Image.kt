package main.ch01.image

import main.ch01.algorithm.Algorithm

abstract class Image(
    private val content: String,
    protected var algorithm: Algorithm,
) {

    /**
     * 압축된 이미지를 반환
     */
    fun getContent() = algorithm.compress(content)

}