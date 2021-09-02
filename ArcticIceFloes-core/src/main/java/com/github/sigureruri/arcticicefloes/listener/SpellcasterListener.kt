package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.entity.living.monster.illager.AIFSpellcaster
import com.github.sigureruri.arcticicefloes.util.AIFEntityHelper
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntitySpellCastEvent

class SpellcasterListener : Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onSpellcast(event: EntitySpellCastEvent) {
        val entity = event.entity
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFSpellcaster ?: return
        val spellcastEvent = AIFSpellcaster.SpellcastEvent(entity, event.spell, event.isCancelled)
        aifEntity.spellcast(spellcastEvent)

        event.isCancelled = spellcastEvent.isCancelled
    }

}