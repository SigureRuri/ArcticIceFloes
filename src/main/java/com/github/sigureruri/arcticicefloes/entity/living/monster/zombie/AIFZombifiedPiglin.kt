package com.github.sigureruri.arcticicefloes.entity.living.monster.zombie

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.PigZombie

abstract class AIFZombifiedPiglin(id: ArcticIceFloesEntityId) : AIFZombie(id) {

    open val isAngry = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.ZOMBIFIED_PIGLIN)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is PigZombie) return

        entity.isAngry = isAngry
    }

}