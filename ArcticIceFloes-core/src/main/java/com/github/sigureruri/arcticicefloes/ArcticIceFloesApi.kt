package com.github.sigureruri.arcticicefloes

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityRegistry
import com.github.sigureruri.arcticicefloes.event.TickEvent
import com.github.sigureruri.arcticicefloes.listener.EntityListener
import com.github.sigureruri.arcticicefloes.nms.NMS
import org.bukkit.plugin.java.JavaPlugin

object ArcticIceFloesApi {

    lateinit var plugin: JavaPlugin
        private set

    lateinit var entityRegistry: ArcticIceFloesEntityRegistry
        private set

    lateinit var NMS: NMS
        private set

    private var enabled = false

    fun enable(javaPlugin: JavaPlugin, nms: NMS) {
        if (enabled) throw IllegalStateException("ArcticIceFloesApi has already enabled.")
        enabled = true
        plugin = javaPlugin
        NMS = nms

        entityRegistry = ArcticIceFloesEntityRegistry()

        listOf(
            EntityListener()
        ).forEach { plugin.server.pluginManager.registerEvents(it, plugin) }

        plugin.server.scheduler.runTaskTimer(plugin, Runnable {
            plugin.server.pluginManager.callEvent(TickEvent())
        }, 1, 1)
    }

}