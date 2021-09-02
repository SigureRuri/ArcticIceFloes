package com.github.sigureruri.arcticicefloes.entity.living.golem

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFIronGolem(id: ArcticIceFloesEntityId) : AIFGolem(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.IRON_GOLEM)

}