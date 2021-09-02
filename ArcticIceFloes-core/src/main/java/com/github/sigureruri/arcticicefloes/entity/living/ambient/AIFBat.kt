package com.github.sigureruri.arcticicefloes.entity.living.ambient

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Bat
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFBat(id: ArcticIceFloesEntityId) : AIFAmbient(id) {

    open val isAwake = true

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.BAT)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Bat) return

        entity.isAwake = isAwake
    }

}