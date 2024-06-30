/*
 * Provide gradle tasks for assemble plugin pf4j
 *
 * Required properties in gradle.properies located in plugin sub project (e.g. hello-plugin/gradle.properies):
 * - pluginClass : class with pakage witch extends Plugin (from pf4j)
 * - pluginId : plugin name
 * - pluginProvider : author
 * - pluginDependencies
 *
 */

plugins {
    kotlin("jvm")
}

tasks.withType<Jar> {
    manifest {
        attributes["Plugin-Class"] = "${project.property("pluginClass")}"
        attributes["Plugin-Id"] = "${project.property("pluginId")}"
        attributes["Plugin-Version"] = "${archiveVersion}"
        attributes["Plugin-Provider"] = "${project.property("pluginProvider")}"
        attributes["Plugin-Dependencies"] = "${project.property("pluginDependencies")}"
    }
}

val pluginAssembleTask = tasks.create<Jar>("plugin-assemble") {
    group = "plugin"

    archiveBaseName = "plugin-${project.property("pluginId")}"
    into("classes") {
        with(tasks.jar.get())
    }
    into("lib") {
        from(configurations.runtimeClasspath)
    }
    archiveExtension = "zip"
}

tasks.create<Copy>("put-in-plugins") {
    group = "plugin"

    val pluginsDir = File(rootProject.projectDir, "plugins")
    from(pluginAssembleTask)
    into(pluginsDir)
}
