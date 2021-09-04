package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.ArcticIceFloesApi
import com.github.sigureruri.arcticicefloes.event.TickEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.server.PluginDisableEvent

class SpawnerListener : Listener {

    @EventHandler
    fun onTick(event: TickEvent) {
        ArcticIceFloesApi.spawnerManager.getAll().forEach {
            it.tick()
        }
    }

    @EventHandler
    fun onDisable(event: PluginDisableEvent) {
        if (event.plugin.name == ArcticIceFloesApi.plugin.name) {
            ArcticIceFloesApi.spawnerManager.removeSpawnedEntities()
        }
    }

}