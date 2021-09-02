package com.github.sigureruri.arcticicefloes.entity.living.monster

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFBlaze(id: ArcticIceFloesEntityId) : AIFMonster(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.BLAZE)

}