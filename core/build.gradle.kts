plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow")
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
    implementation(projects.api)
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "ru.kyamshanov.core.MainKt"
    }
}

tasks.test {
    useJUnitPlatform()
}