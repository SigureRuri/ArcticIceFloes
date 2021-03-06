package com.github.sigureruri.arcticicefloes.entity.living.monster.illager

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.entity.Spellcaster

abstract class AIFSpellcaster(id: AIFEntityId) : AIFIllager(id) {

    open fun spellcast(event: SpellcastEvent) {}

    data class SpellcastEvent(val spellcaster: Spellcaster, val spell: Spellcaster.Spell, var isCancelled: Boolean)

}