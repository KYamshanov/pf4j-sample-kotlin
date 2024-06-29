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
    kapt(libs.pf4j)

    implementation(libs.slf4j.simple)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)

}

tasks.withType<Jar> {
    manifest {
        attributes["Plugin-Class"] = "${project.property("pluginClass")}"
        attributes["Plugin-Id"] = "${project.property("pluginId")}"
        attributes["Plugin-Version"] = "${archiveVersion}"
        attributes["Plugin-Provider"] = "${project.property("pluginProvider")}"
        attributes["Plugin-Dependencies"] = "${project.property("pluginDependencies")}"
        attributes["Plugin-Class"] = "${project.property("pluginClass")}"
    }
}

tasks.create<Jar>("plugin") {
    archiveBaseName = "plugin-${project.property("pluginId")}"
    into("classes") {
        with(tasks.jar.get())
    }
    into("lib") {
        from(configurations.compileClasspath)
    }
    archiveExtension = "zip"
}
