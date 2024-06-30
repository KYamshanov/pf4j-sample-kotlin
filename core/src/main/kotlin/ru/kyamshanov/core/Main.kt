package ru.kyamshanov.core

import org.pf4j.DefaultPluginManager
import org.pf4j.PluginManager
import ru.kyamshanov.api.VersionProvider

fun main() {
    val pluginManager: PluginManager = DefaultPluginManager()
    pluginManager.loadPlugins()
    pluginManager.startPlugins()

    val greetings = pluginManager.getExtensions(VersionProvider::class.java)
    for (greeting in greetings) {
        println("Plugin version: ${greeting.version}")
    }
}
