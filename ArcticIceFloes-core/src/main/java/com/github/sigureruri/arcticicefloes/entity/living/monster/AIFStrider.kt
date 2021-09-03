package com.github.sigureruri.arcticicefloes.entity.living.monster

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import com.github.sigureruri.arcticicefloes.entity.living.animal.AIFAnimal
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Strider

abstract class AIFStrider(id: AIFEntityId) : AIFAnimal(id) {

    open val hasSaddle = false

    open val isShivering = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.STRIDER)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Strider) return

        entity.setSaddle(hasSaddle)
        entity.isShivering = isShivering
    }
}