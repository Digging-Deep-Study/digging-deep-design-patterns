package ch02

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.mpp.log
import main.ch02.logger.Log4j
import main.ch02.loggingsystem.*

class ECommerceApplicationTest : StringSpec({

    "Logger 인터페이스를 통해 Log4j를 사용하여 로그를 기록할 수 있다" {
        // 로깅 시스템 설정
        println("===============[ECommerceApplicationTest] 로그시스템 초기화======================================")
        val log4j = Log4j()
        val consolePrinter = ConsolePrinter()
        val fileExtractor = FileExtractor()
        val prometheusAgent = PrometheusAgent()
        val onCallSystem = OnCallSystem()

        log4j.addObserver(consolePrinter)
        log4j.addObserver(fileExtractor)
        log4j.addObserver(prometheusAgent)
        log4j.addObserver(onCallSystem)

        // 어플리케이션 동작
        println("===============[ECommerceApplicationTest] 어플리케이션 시작======================================")
        val app = ECommerceApplication(log4j)

        app.processOrder("12345")
        app.handleUserError("홍길동")
        app.handleAbnormalOrderProcessing("홍길동")

        // 일부 로깅 시스템 제거
        println("===============[ECommerceApplicationTest] 로그시스템 일부제거======================================")
        log4j.removeObserver(fileExtractor)
        log4j.removeObserver(prometheusAgent)

        // 어플리케이션 동작
        println("===============[ECommerceApplicationTest] 어플리케이션 동작======================================")
        app.processOrder("67890")
        app.handleUserError("김철수")
        app.handleAbnormalOrderProcessing("김철수")
    }
})
