package com.github.sigureruri.arcticicefloes.entity.living.monster.piglin

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFPiglinBrute(id: ArcticIceFloesEntityId) : AIFAbstractPiglin(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.PIGLIN_BRUTE)

}