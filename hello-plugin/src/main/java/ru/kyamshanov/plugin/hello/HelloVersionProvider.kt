package ru.kyamshanov.plugin.hello

import org.pf4j.Extension
import org.pf4j.ExtensionPoint
import ru.kyamshanov.api.VersionProvider

@Extension
class HelloVersionProvider : VersionProvider, ExtensionPoint {
    override val version: Int = 2
}
