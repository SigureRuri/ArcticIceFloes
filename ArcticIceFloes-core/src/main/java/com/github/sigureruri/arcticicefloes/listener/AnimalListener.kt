package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.entity.living.animal.AIFAnimal
import com.github.sigureruri.arcticicefloes.util.AIFEntityHelper
import org.bukkit.entity.Animals
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityEnterLoveModeEvent

class AnimalListener : Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onEnterLoveMode(event: EntityEnterLoveModeEvent) {
        val entity = event.entity as? Animals ?: return
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFAnimal ?: return
        val enterLoveModeEvent = AIFAnimal.EnterLoveModeEvent(entity, event.humanEntity, event.ticksInLove, event.isCancelled)
        aifEntity.enterLoveMode(enterLoveModeEvent)

        event.ticksInLove = enterLoveModeEvent.ticksInLove
        event.isCancelled = enterLoveModeEvent.isCancelled
    }

}