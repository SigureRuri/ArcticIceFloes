package com.github.sigureruri.arcticicefloes

import com.github.sigureruri.arcticicefloes.entity.AIFEntityRegistry
import com.github.sigureruri.arcticicefloes.event.TickEvent
import com.github.sigureruri.arcticicefloes.listener.AnimalListener
import com.github.sigureruri.arcticicefloes.listener.CreeperListener
import com.github.sigureruri.arcticicefloes.listener.EnderCrystalListener
import com.github.sigureruri.arcticicefloes.listener.EntityListener
import com.github.sigureruri.arcticicefloes.listener.LivingEntityListener
import com.github.sigureruri.arcticicefloes.listener.PiglinListener
import com.github.sigureruri.arcticicefloes.listener.SheepListener
import com.github.sigureruri.arcticicefloes.listener.SlimeListener
import com.github.sigureruri.arcticicefloes.listener.SpawnerListener
import com.github.sigureruri.arcticicefloes.listener.SpellcasterListener
import com.github.sigureruri.arcticicefloes.listener.TameableAnimalListener
import com.github.sigureruri.arcticicefloes.listener.ZombifiedPiglinListener
import com.github.sigureruri.arcticicefloes.nms.NMS
import com.github.sigureruri.arcticicefloes.spawner.AIFSpawnerManager
import com.github.sigureruri.arcticicefloes.spawner.SpawnerDebug
import org.bukkit.plugin.java.JavaPlugin

object ArcticIceFloesApi {

    lateinit var plugin: JavaPlugin
        private set

    lateinit var entityRegistry: AIFEntityRegistry
        private set

    lateinit var spawnerManager: AIFSpawnerManager

    lateinit var NMS: NMS
        private set

    private var enabled = false

    fun enable(javaPlugin: JavaPlugin, nms: NMS) {
        if (enabled) throw IllegalStateException("ArcticIceFloesApi has already enabled.")
        enabled = true
        plugin = javaPlugin
        NMS = nms

        entityRegistry = AIFEntityRegistry()
        spawnerManager = AIFSpawnerManager()

        listOf(
            EntityListener(),
            EnderCrystalListener(),
            LivingEntityListener(),
            AnimalListener(),
            TameableAnimalListener(),
            SlimeListener(),
            SheepListener(),
            CreeperListener(),
            SpellcasterListener(),
            PiglinListener(),
            ZombifiedPiglinListener(),
            SpawnerListener()
        ).forEach { plugin.server.pluginManager.registerEvents(it, plugin) }

        plugin.server.scheduler.runTaskTimer(plugin, Runnable {
            plugin.server.pluginManager.callEvent(TickEvent())
        }, 1, 1)
    }

}