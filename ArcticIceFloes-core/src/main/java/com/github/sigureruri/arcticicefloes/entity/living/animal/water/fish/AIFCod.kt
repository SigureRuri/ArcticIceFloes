package com.github.sigureruri.arcticicefloes.entity.living.animal.water.fish

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFCod(id: AIFEntityId) : AIFFish(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.COD)

}