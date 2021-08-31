package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.DyeColor
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Wolf

abstract class AIFWolf(id: ArcticIceFloesEntityId) : AIFTameableAnimal(id) {

    abstract val collarColor: DyeColor

    val isAngry = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.WOLF)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Wolf) return

        entity.collarColor = collarColor
        entity.isAngry = isAngry
    }

}