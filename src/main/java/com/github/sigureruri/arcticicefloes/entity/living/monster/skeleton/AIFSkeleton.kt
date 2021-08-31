package com.github.sigureruri.arcticicefloes.entity.living.monster.skeleton

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFSkeleton(id: ArcticIceFloesEntityId) : AIFAbstractSkeleton(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.SKELETON)

}