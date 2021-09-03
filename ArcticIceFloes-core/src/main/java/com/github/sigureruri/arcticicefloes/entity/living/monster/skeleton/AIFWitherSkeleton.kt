package com.github.sigureruri.arcticicefloes.entity.living.monster.skeleton

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFWitherSkeleton(id: AIFEntityId) : AIFAbstractSkeleton(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.WITHER_SKELETON)

}