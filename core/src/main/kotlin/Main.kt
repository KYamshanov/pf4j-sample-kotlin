package ru.kyamshanov

import org.pf4j.DefaultPluginManager
import org.pf4j.PluginManager

fun main() {
    val pluginManager: PluginManager = DefaultPluginManager()
    pluginManager.loadPlugins()
    pluginManager.startPlugins()
}
