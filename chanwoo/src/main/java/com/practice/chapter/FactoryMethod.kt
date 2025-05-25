package com.practice.chapter

fun main() {
    val wordApp: Application = WordApplication()
    val pdfApp: Application = PdfApplication()
    val htmlApp: Application = HtmlApplication()

    val document = wordApp.createDocument()
    document.save()
    document.close()
}

abstract class Document {
    abstract fun create()
    abstract fun open()
    abstract fun save()
    abstract fun close()
}

class WordDocument : Document() {
    override fun create() {
        println("Word 문서를 생성합니다.")
    }

    override fun open() {
        println("Word 문서를 엽니다.")
    }

    override fun save() {
        println("Word 문서를 저장합니다.")
    }

    override fun close() {
        println("Word 문서를 닫습니다.")
    }
}

class PdfDocument : Document() {
    override fun create() {
        println("PDF 문서를 생성합니다.")
    }

    override fun open() {
        println("PDF 문서를 엽니다.")
    }

    override fun save() {
        println("PDF 문서를 저장합니다.")
    }

    override fun close() {
        println("PDF 문서를 닫습니다.")
    }
}

class HtmlDocument : Document() {
    override fun create() {
        println("HTML 문서를 생성합니다.")
    }

    override fun open() {
        println("HTML 문서를 엽니다.")
    }

    override fun save() {
        println("HTML 문서를 저장합니다.")
    }

    override fun close() {
        println("HTML 문서를 닫습니다.")
    }
}

abstract class Application {
    abstract fun createDocument(): Document
}

class WordApplication : Application() {
    override fun createDocument(): Document {
        return WordDocument()
    }
}

class PdfApplication : Application() {
    override fun createDocument(): Document {
        return PdfDocument()
    }
}

class HtmlApplication : Application() {
    override fun createDocument(): Document {
        return HtmlDocument()
    }
}