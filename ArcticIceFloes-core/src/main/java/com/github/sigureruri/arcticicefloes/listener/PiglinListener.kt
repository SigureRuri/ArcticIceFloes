package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.entity.living.monster.piglin.AIFPiglin
import com.github.sigureruri.arcticicefloes.util.AIFEntityHelper
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.PiglinBarterEvent

class PiglinListener : Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onAnger(event: PiglinBarterEvent) {
        val entity = event.entity
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFPiglin ?: return
        val barterEvent = AIFPiglin.BarterEvent(entity, event.input, event.outcome, event.isCancelled)
        aifEntity.barter(barterEvent)

        event.isCancelled = barterEvent.isCancelled
    }

}