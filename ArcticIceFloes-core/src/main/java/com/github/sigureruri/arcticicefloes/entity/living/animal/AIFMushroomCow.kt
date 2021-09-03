package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.MushroomCow

abstract class AIFMushroomCow(id: AIFEntityId) : AIFCow(id) {

    abstract val variant: MushroomCow.Variant

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.MUSHROOM_COW)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is MushroomCow) return

        entity.variant = variant
    }

}