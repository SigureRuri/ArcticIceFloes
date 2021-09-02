package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.entity.living.animal.AIFTameableAnimal
import com.github.sigureruri.arcticicefloes.util.AIFEntityHelper
import org.bukkit.entity.Tameable
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityTameEvent

class TameableAnimalListener : Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onTamed(event: EntityTameEvent) {
        val entity = event.entity as? Tameable ?: return
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFTameableAnimal ?: return
        val tamedEvent = AIFTameableAnimal.TamedEvent(entity, event.owner, event.isCancelled)
        aifEntity.tamed(tamedEvent)

        event.isCancelled = tamedEvent.isCancelled
    }

}