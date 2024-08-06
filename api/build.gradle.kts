plugins {
    kotlin("jvm")
    kotlin("kapt")
}

group = "ru.kyamshanov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.pf4j)
    kapt(libs.pf4j)
    implementation(libs.slf4j.simple)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}