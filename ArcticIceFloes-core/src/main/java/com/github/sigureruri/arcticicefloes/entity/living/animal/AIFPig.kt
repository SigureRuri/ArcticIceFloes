package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Pig

abstract class AIFPig(id: ArcticIceFloesEntityId) : AIFAnimal(id) {

    open val hasSaddle = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.PIG)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Pig) return

        entity.setSaddle(hasSaddle)
    }

}