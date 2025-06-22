package com.practice.chapter

fun main() {
    val pdfGenerator = PdfGenerator()
    val markdownGenerator = MarkdownGenerator()

    val documentData = DocumentData(
        title = "Sample Document",
        content = "This is the content of the document.",
        author = "John Doe"
    )

    println(pdfGenerator.generateDocument(documentData))
    println(markdownGenerator.generateDocument(documentData))
}

abstract class DocumentGenerator {
    // 템플릿 메서드 - 문서 생성의 전체 흐름 정의
    fun generateDocument(data: DocumentData): String {
        val document = StringBuilder()

        document.append(createHeader(data))
        document.append(createBody(data))
        document.append(createFooter(data))

        return formatDocument(document.toString())
    }

    // 추상 메서드들 - 하위 클래스에서 구현
    protected abstract fun createHeader(data: DocumentData): String
    protected abstract fun createBody(data: DocumentData): String
    protected abstract fun createFooter(data: DocumentData): String
    protected abstract fun formatDocument(content: String): String

    // 훅 메서드 - 필요시 하위 클래스에서 오버라이드
    protected fun addMetadata(data: DocumentData): String {
        return "" // 기본적으로는 빈 문자열
    }
}

class PdfGenerator : DocumentGenerator() {
    override fun createHeader(data: DocumentData): String {
        return "PDF Header: ${data.title}\n"
    }

    override fun createBody(data: DocumentData): String {
        return "PDF Body: ${data.content}\n"
    }

    override fun createFooter(data: DocumentData): String {
        return "PDF Footer: Author - ${data.author}\n"
    }

    override fun formatDocument(content: String): String {
        return "Formatted PDF Document:\n$content"
    }
}

class MarkdownGenerator : DocumentGenerator() {
    override fun createHeader(data: DocumentData): String {
        return "# ${data.title}\n"
    }

    override fun createBody(data: DocumentData): String {
        return "${data.content}\n"
    }

    override fun createFooter(data: DocumentData): String {
        return "\n*Author: ${data.author}*\n"
    }

    override fun formatDocument(content: String): String {
        return "Formatted Markdown Document:\n$content"
    }
}



data class DocumentData(
    val title: String,
    val content: String,
    val author: String
)
