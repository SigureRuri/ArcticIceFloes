package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.DyeColor
import org.bukkit.Location
import org.bukkit.entity.Cat
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFCat(id: ArcticIceFloesEntityId) : AIFTameableAnimal(id) {

    abstract val catType: Cat.Type

    abstract val collarColor: DyeColor

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.CAT)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Cat) return

        entity.catType = catType
        entity.collarColor = collarColor
    }

}