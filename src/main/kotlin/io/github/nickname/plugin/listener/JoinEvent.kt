package io.github.nickname.plugin.listener

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class JoinEvent: Listener {
    @EventHandler
    fun PlayerJoinEvent.onJoin() {
        joinMessage(Component.text("Hello, ${player.name}!", NamedTextColor.AQUA))
    }
}