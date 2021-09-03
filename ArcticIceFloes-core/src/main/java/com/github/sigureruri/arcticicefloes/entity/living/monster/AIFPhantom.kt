package com.github.sigureruri.arcticicefloes.entity.living.monster

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import com.github.sigureruri.arcticicefloes.entity.living.AIFMob
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Phantom

abstract class AIFPhantom(id: AIFEntityId) : AIFMob(id) {

    open val size = 0

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.PHANTOM)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Phantom) return

        entity.size = size
    }

}