plugins {
    kotlin("jvm")
    kotlin("kapt")
    id("plugin-assemble")
}

group = "ru.kyamshanov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(projects.api)
    implementation(libs.pf4j)
    kapt(libs.pf4j)
    implementation(libs.slf4j.simple)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
