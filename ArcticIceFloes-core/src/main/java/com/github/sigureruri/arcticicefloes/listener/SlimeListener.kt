package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.entity.living.monster.slime.AIFSlime
import com.github.sigureruri.arcticicefloes.util.AIFEntityHelper
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.SlimeSplitEvent

class SlimeListener : Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onSplit(event: SlimeSplitEvent) {
        val entity = event.entity
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFSlime ?: return
        val splitEvent = AIFSlime.SplitEvent(entity, event.count, event.isCancelled)
        aifEntity.split(splitEvent)

        event.count = splitEvent.count
        event.isCancelled = splitEvent.isCancelled
    }

}