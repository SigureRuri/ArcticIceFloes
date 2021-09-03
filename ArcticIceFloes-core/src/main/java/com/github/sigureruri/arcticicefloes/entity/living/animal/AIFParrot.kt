package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Parrot

abstract class AIFParrot(id: AIFEntityId) : AIFTameableAnimal(id) {

    abstract val variant: Parrot.Variant

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.PARROT)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Parrot) return

        entity.variant = variant
    }

}