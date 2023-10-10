package io.github.nickname.plugin.kommand

import io.github.monun.kommand.kommand
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.plugin.Plugin

class BasicCommand(plugin: Plugin) {
    init {
        val rootNodeList: List<String> = listOf("test", "kotlin")
        plugin.apply {
            kommand {
                rootNodeList[0] {
                    executes {
                        player.sendMessage(Component.text("TEST was successfully activated!", NamedTextColor.AQUA))
                    }
                }
                rootNodeList[1] {
                    executes {
                        player.sendMessage(Component.text("Kotlin is god!", NamedTextColor.RED))
                    }
                }
            }
        }
    }
}