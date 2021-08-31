package com.github.sigureruri.arcticicefloes.entity.living.monster

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Creeper
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFCreeper(
    id: ArcticIceFloesEntityId
) : AIFMonster(id) {

    open val fuseTicks = 30

    open val explosionRadius = 3

    open val isPowered = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.CREEPER)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Creeper) return

        entity.fuseTicks = fuseTicks
        entity.explosionRadius = explosionRadius
        entity.isPowered = isPowered
    }

}