package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.entity.living.monster.AIFCreeper
import com.github.sigureruri.arcticicefloes.util.AIFEntityHelper
import org.bukkit.entity.Creeper
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.CreeperPowerEvent
import org.bukkit.event.entity.EntityExplodeEvent

class CreeperListener : Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onPowered(event: CreeperPowerEvent) {
        val entity = event.entity
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFCreeper ?: return
        val poweredEvent = AIFCreeper.PoweredEvent(entity, event.lightning, event.cause, event.isCancelled)
        aifEntity.powered(poweredEvent)

        event.isCancelled = poweredEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onExplode(event: EntityExplodeEvent) {
        val entity = event.entity as? Creeper ?: return
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFCreeper ?: return
        val explodeEvent = AIFCreeper.ExplodeEvent(entity, event.location, event.yield, event.isCancelled)
        aifEntity.explode(explodeEvent)

        event.yield = explodeEvent.yield
        event.isCancelled = explodeEvent.isCancelled
    }

}