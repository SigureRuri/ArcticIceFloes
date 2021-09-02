package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import com.github.sigureruri.arcticicefloes.entity.living.AIFAgeable
import org.bukkit.entity.Animals
import org.bukkit.entity.Entity
import org.bukkit.entity.HumanEntity

abstract class AIFAnimal(id: ArcticIceFloesEntityId) : AIFAgeable(id) {

    open val ageLock = true

    open fun enterLoveMode(event: EnterLoveModeEvent) {}

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Animals) return

        entity.ageLock = ageLock
    }

    data class EnterLoveModeEvent(
        val entity: Animals,
        val humanEntity: HumanEntity?,
        var ticksInLove: Int,
        var isCancelled: Boolean
    )

}