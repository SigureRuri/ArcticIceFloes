package com.github.sigureruri.arcticicefloes.entity.living.animal.water.fish

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.PufferFish

abstract class AIFPufferFish(id: ArcticIceFloesEntityId) : AIFFish(id) {

    val puffState = 0

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.PUFFERFISH)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is PufferFish) return

        entity.puffState = puffState
    }

}