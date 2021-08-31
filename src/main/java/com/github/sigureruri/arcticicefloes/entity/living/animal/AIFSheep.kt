package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.DyeColor
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Sheep

abstract class AIFSheep(id: ArcticIceFloesEntityId) : AIFAnimal(id) {

    abstract val color: DyeColor

    val isSheared = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.SHEEP)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Sheep) return

        entity.color = color
        entity.isSheared = isSheared
    }

}