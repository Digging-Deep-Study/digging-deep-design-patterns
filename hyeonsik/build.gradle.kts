plugins {
    kotlin("jvm") version "1.9.10"
}

repositories {
    mavenCentral()
}

dependencies {
    // Kotest 의존성 추가
    testImplementation("io.kotest:kotest-runner-junit5:5.7.2") // Kotest 실행기
    testImplementation("io.kotest:kotest-assertions-core:5.7.2") // Kotest Assertion
    testImplementation("io.kotest:kotest-property:5.7.2") // Property-based Testing (선택 사항)
}

tasks.test {
    useJUnitPlatform() // JUnit 플랫폼 사용
}
