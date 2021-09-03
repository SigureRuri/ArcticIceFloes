package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Goat

abstract class AIFGoat(id: AIFEntityId) : AIFAnimal(id) {

    open val isScreaming = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.GOAT)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Goat) return

        entity.isScreaming = isScreaming
    }

}