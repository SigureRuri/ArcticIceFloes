package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.entity.Entity
import org.bukkit.entity.Tameable

abstract class AIFTameableAnimal(id: ArcticIceFloesEntityId) : AIFAnimal(id) {

    val isTamed = false

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Tameable) return

        entity.isTamed = isTamed
    }

}