package com.github.sigureruri.arcticicefloes

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityRegistry
import com.github.sigureruri.arcticicefloes.event.TickEvent
import com.github.sigureruri.arcticicefloes.listener.EntityListener
import com.github.sigureruri.arcticicefloes.nms.NMS
import com.github.sigureruri.arcticicefloes.nms.v1_17_R1.NMS_v1_17_R1
import org.bukkit.plugin.java.JavaPlugin

class ArcticIceFloes : JavaPlugin() {

    override fun onEnable() {
        enable(this)
    }

    companion object {

        lateinit var plugin: JavaPlugin
            private set

        lateinit var entityRegistry: ArcticIceFloesEntityRegistry
            private set

        lateinit var NMS: NMS
            private set

        private var enabled = false

        fun enable(javaPlugin: JavaPlugin) {
            if (enabled) throw IllegalStateException("ArcticIceFloes has already enabled.")
            enabled = true
            plugin = javaPlugin

            entityRegistry = ArcticIceFloesEntityRegistry()

            NMS = NMS_v1_17_R1()

            listOf(
                EntityListener()
            ).forEach { plugin.server.pluginManager.registerEvents(it, plugin) }

            plugin.server.scheduler.runTaskTimer(plugin, Runnable {
                plugin.server.pluginManager.callEvent(TickEvent())
            }, 1, 1)

            // TODO: DEBUG
            Debug(plugin)
        }

    }

}