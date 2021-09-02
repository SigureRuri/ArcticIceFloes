package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Ocelot

abstract class AIFOcelot(id: ArcticIceFloesEntityId) : AIFAnimal(id) {

    val isTrusting = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.OCELOT)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Ocelot) return

        entity.isTrusting = isTrusting
    }

}