package io.github.nickname.plugin.utils

import io.github.nickname.plugin.PluginCore.Companion.instance
import org.bukkit.event.Listener

object RegisterListener {
    fun listeners(vararg listener: Listener) {
        listener.forEach {
            instance.apply {
                server.pluginManager.registerEvents(it, instance)
            }
        }
    }
}