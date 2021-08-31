package com.github.sigureruri.arcticicefloes.entity.living.monster.slime

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFMagmaCube(id: ArcticIceFloesEntityId) : AIFSlime(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.MAGMA_CUBE)

}