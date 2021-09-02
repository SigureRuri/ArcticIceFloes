package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.entity.living.monster.zombie.AIFZombifiedPiglin
import com.github.sigureruri.arcticicefloes.util.AIFEntityHelper
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.PigZombieAngerEvent

class ZombifiedPiglinListener : Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onAnger(event: PigZombieAngerEvent) {
        val entity = event.entity
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFZombifiedPiglin ?: return
        val angerEvent = AIFZombifiedPiglin.AngerEvent(entity, event.newAnger, event.target, event.isCancelled)
        aifEntity.anger(angerEvent)

        event.newAnger = angerEvent.newAnger
        event.isCancelled = angerEvent.isCancelled
    }

}