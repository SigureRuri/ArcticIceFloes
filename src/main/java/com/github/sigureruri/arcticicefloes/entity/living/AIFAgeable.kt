package com.github.sigureruri.arcticicefloes.entity.living

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.entity.Ageable
import org.bukkit.entity.Entity

abstract class AIFAgeable(id: ArcticIceFloesEntityId) : AIFMob(id) {

    open val isBaby = false

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Ageable) return

        if (isBaby) entity.setBaby()
    }

}