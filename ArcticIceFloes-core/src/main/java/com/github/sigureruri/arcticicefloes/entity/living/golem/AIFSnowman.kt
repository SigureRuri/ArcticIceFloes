package com.github.sigureruri.arcticicefloes.entity.living.golem

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Snowman

abstract class AIFSnowman(id: AIFEntityId) : AIFGolem(id) {

    open val isDerp = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.SNOWMAN)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Snowman) return

        entity.isDerp = isDerp
    }

}