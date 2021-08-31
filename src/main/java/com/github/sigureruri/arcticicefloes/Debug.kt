package com.github.sigureruri.arcticicefloes

import net.minecraft.world.entity.ai.goal.PathfinderGoalLeapAtTarget
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget
import net.minecraft.world.entity.player.EntityHuman
import org.bukkit.Material
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPig
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin

class Debug(plugin: JavaPlugin) : Listener {

    init {
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    @EventHandler
    fun onClick(event: PlayerInteractEvent) {
        if (event.item?.type == Material.WARPED_FUNGUS_ON_A_STICK) {
            event.player.world.spawnEntity(event.player.location, EntityType.PIG).apply {
                this as CraftPig

                handle.bQ.a(0, PathfinderGoalNearestAttackableTarget<EntityHuman>(handle, EntityHuman::class.java, true))
                handle.bP.a(1, PathfinderGoalLeapAtTarget(handle, 1f))
            }
        }
    }

}