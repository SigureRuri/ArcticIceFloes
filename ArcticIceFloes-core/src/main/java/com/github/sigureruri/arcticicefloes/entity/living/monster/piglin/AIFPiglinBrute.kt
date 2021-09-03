package com.github.sigureruri.arcticicefloes.entity.living.monster.piglin

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFPiglinBrute(id: AIFEntityId) : AIFAbstractPiglin(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.PIGLIN_BRUTE)

}