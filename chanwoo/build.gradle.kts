plugins {
    id("java")
    kotlin("jvm") version "2.1.21"
}

group = "com.practice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.netty:netty-all:4.2.1.Final")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}