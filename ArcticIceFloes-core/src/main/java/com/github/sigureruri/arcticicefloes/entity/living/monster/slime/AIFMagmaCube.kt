package com.github.sigureruri.arcticicefloes.entity.living.monster.slime

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFMagmaCube(id: AIFEntityId) : AIFSlime(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.MAGMA_CUBE)

}