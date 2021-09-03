package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Ocelot

abstract class AIFOcelot(id: AIFEntityId) : AIFAnimal(id) {

    val isTrusting = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.OCELOT)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Ocelot) return

        entity.isTrusting = isTrusting
    }

}