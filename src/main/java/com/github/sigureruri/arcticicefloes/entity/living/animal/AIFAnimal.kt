package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import com.github.sigureruri.arcticicefloes.entity.living.AIFAgeable
import org.bukkit.entity.Animals
import org.bukkit.entity.Entity

abstract class AIFAnimal(id: ArcticIceFloesEntityId) : AIFAgeable(id) {

    open val ageLock = true

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Animals) return

        entity.ageLock = ageLock
    }

}