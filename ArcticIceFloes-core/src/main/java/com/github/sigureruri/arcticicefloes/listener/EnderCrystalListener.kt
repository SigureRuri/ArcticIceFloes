package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.entity.AIFEnderCrystal
import com.github.sigureruri.arcticicefloes.util.AIFEntityHelper
import org.bukkit.entity.EnderCrystal
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityExplodeEvent

class EnderCrystalListener : Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onExplode(event: EntityExplodeEvent) {
        val entity = event.entity as? EnderCrystal ?: return
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFEnderCrystal ?: return
        val explodeEvent = AIFEnderCrystal.ExplodeEvent(entity, event.location, event.yield, event.isCancelled)
        aifEntity.explode(explodeEvent)

        event.yield = explodeEvent.yield
        event.isCancelled = explodeEvent.isCancelled
    }

}