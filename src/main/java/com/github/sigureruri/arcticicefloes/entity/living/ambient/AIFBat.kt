package com.github.sigureruri.arcticicefloes.entity.living.ambient

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.entity.Bat
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFBat(
    id: ArcticIceFloesEntityId
) : AIFAmbient(id, EntityType.BAT) {

    open val isAwake = true

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        entity as Bat

        entity.isAwake = isAwake
    }

}