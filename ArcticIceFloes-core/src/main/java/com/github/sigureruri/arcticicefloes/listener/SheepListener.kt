package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.entity.living.animal.AIFSheep
import com.github.sigureruri.arcticicefloes.util.AIFEntityHelper
import org.bukkit.entity.Sheep
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.SheepDyeWoolEvent
import org.bukkit.event.entity.SheepRegrowWoolEvent
import org.bukkit.event.player.PlayerShearEntityEvent

class SheepListener : Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onDyedWool(event: SheepDyeWoolEvent) {
        val entity = event.entity
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFSheep ?: return
        val dyedEvent = AIFSheep.DyedWoolEvent(entity, event.color, event.isCancelled)
        aifEntity.dyed(dyedEvent)

        event.color = dyedEvent.color
        event.isCancelled = dyedEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onShearedWool(event: PlayerShearEntityEvent) {
        val entity = event.entity as? Sheep ?: return
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFSheep ?: return
        val shearedWoolEvent = AIFSheep.ShearedWoolEvent(entity, event.hand, event.item, event.isCancelled)
        aifEntity.sheared(shearedWoolEvent)

        event.isCancelled = shearedWoolEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onRegrowWol(event: SheepRegrowWoolEvent) {
        val entity = event.entity
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFSheep ?: return
        val regrowWoolEvent = AIFSheep.RegrowWoolEvent(entity, event.isCancelled)
        aifEntity.regrowWool(regrowWoolEvent)

        event.isCancelled = regrowWoolEvent.isCancelled
    }

}