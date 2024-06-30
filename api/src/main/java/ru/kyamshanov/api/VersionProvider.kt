package ru.kyamshanov.api

import org.pf4j.ExtensionPoint

interface VersionProvider : ExtensionPoint {
    val version: Int
}
