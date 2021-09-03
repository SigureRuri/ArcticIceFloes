package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.entity.AnimalTamer
import org.bukkit.entity.Entity
import org.bukkit.entity.Tameable

abstract class AIFTameableAnimal(id: AIFEntityId) : AIFAnimal(id) {

    val isTamed = false

    open fun tamed(event: TamedEvent) {}

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Tameable) return

        entity.isTamed = isTamed
    }

    data class TamedEvent(val entity: Tameable, val owner: AnimalTamer, var isCancelled: Boolean)

}