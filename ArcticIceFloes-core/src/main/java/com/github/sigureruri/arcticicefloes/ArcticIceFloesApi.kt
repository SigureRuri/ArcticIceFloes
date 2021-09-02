package com.github.sigureruri.arcticicefloes

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityRegistry
import com.github.sigureruri.arcticicefloes.event.TickEvent
import com.github.sigureruri.arcticicefloes.listener.AnimalListener
import com.github.sigureruri.arcticicefloes.listener.CreeperListener
import com.github.sigureruri.arcticicefloes.listener.EntityListener
import com.github.sigureruri.arcticicefloes.listener.LivingEntityListener
import com.github.sigureruri.arcticicefloes.listener.PiglinListener
import com.github.sigureruri.arcticicefloes.listener.SheepListener
import com.github.sigureruri.arcticicefloes.listener.SlimeListener
import com.github.sigureruri.arcticicefloes.listener.SpellcasterListener
import com.github.sigureruri.arcticicefloes.listener.TameableAnimalListener
import com.github.sigureruri.arcticicefloes.listener.ZombifiedPiglinListener
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
            EntityListener(),
            LivingEntityListener(),
            AnimalListener(),
            TameableAnimalListener(),
            SlimeListener(),
            SheepListener(),
            CreeperListener(),
            SpellcasterListener(),
            PiglinListener(),
            ZombifiedPiglinListener()
        ).forEach { plugin.server.pluginManager.registerEvents(it, plugin) }

        plugin.server.scheduler.runTaskTimer(plugin, Runnable {
            plugin.server.pluginManager.callEvent(TickEvent())
        }, 1, 1)
    }

}