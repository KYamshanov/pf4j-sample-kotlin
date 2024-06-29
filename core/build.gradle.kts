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
    testImplementation(kotlin("test"))

    implementation(libs.pf4j)

    implementation(libs.slf4j.simple)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
