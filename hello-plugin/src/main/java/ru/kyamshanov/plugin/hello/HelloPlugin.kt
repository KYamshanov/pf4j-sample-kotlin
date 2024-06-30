package ru.kyamshanov.plugin.hello

import org.pf4j.Plugin
import org.slf4j.LoggerFactory

class HelloPlugin : Plugin() {

    private val logger: org.slf4j.Logger? = LoggerFactory.getLogger(HelloPlugin::class.java)

    override fun start() {
        logger?.info("HelloPlugin.start()")
    }

    override fun stop() {
        logger?.info("HelloPlugin.stop()")
    }
}
