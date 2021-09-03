package com.github.sigureruri.arcticicefloes.entity.living.monster.illager

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFVindicator(id: AIFEntityId) : AIFIllager(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.VINDICATOR)

}