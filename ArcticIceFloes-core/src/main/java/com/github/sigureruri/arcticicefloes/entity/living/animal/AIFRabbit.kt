package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Rabbit

abstract class AIFRabbit(id: AIFEntityId) : AIFAnimal(id) {

    abstract val rabbitType: Rabbit.Type

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.RABBIT)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Rabbit) return

        entity.rabbitType = rabbitType
    }

}