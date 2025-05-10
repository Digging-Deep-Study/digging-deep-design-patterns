package main.ch01

import main.ch01.file.FileExtension.toImage
import main.ch01.file.File

class Uploader {

    fun upload(file: File) {

        val image = file.toImage()
        val compressedContent = image.getContent()

        uploadToServer(compressedContent)

    }

    private fun uploadToServer(compressedContent: String) {
        println("[Uploader] 파일 업로드 성공! 내용: $compressedContent")
    }

}