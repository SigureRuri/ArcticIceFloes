package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Fox

abstract class AIFFox(id: ArcticIceFloesEntityId) : AIFAnimal(id) {

    abstract val foxType: Fox.Type

    open val isCrouching = false

    open val isSleeping = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.FOX)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Fox) return

        entity.foxType = foxType
        entity.isCrouching = isCrouching
        entity.isSleeping = isSleeping
    }

}