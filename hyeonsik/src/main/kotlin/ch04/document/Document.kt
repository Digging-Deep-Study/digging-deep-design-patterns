abstract class Document {
    abstract fun open()
    abstract fun save()
    override fun toString(): String = this::class.simpleName ?: "문서"
}

class WordDocument : Document() {
    override fun open() {
        println("Word 문서를 엽니다.")
    }

    override fun save() {
        println("Word 문서를 저장합니다.")
    }
}

class PdfDocument : Document() {
    override fun open() {
        println("PDF 문서를 엽니다.")
    }

    override fun save() {
        println("PDF 문서를 저장합니다.")
    }
}

class HtmlDocument : Document() {
    override fun open() {
        println("HTML 문서를 엽니다.")
    }

    override fun save() {
        println("HTML 문서를 저장합니다.")
    }
}

// 생성자 (Creator)
abstract class Application {
    // 팩토리 메소드: 실제 어떤 문서를 생성할지는 서브클래스가 결정
    abstract fun createDocument(): Document

    fun newDocument(): Document {
        val doc = createDocument() // 팩토리 메소드 호출
        println("애플리케이션: 새 ${doc}를 생성했습니다.")
        doc.open()
        return doc
    }
}

// 구현
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


///////////////////////////////////////////////////////////////////////////////
//
// main
//
///////////////////////////////////////////////////////////////////////////////
fun main() {
    println("--- Word 애플리케이션 실행 ---")
    val wordApp: Application = WordApplication()
    val wordDoc = wordApp.newDocument()
    wordDoc.save()

    println("\n--- PDF 애플리케이션 실행 ---")
    val pdfApp: Application = PdfApplication()
    val pdfDoc = pdfApp.newDocument()
    pdfDoc.save()

    println("\n--- HTML 애플리케이션 실행 ---")
    val htmlApp: Application = HtmlApplication()
    val htmlDoc = htmlApp.newDocument()
    htmlDoc.save()

    println("\n--- 사용자가 PDF 애플리케이션을 직접 선택 ---")
    val mySpecificPdfApp = PdfApplication()
    val myPdf: Document = mySpecificPdfApp.createDocument()
    println("클라이언트: PdfApplication을 통해 ${myPdf}를 요청했습니다.")
    myPdf.open()
    myPdf.save()
}
