package com.github.sigureruri.arcticicefloes.entity.living.animal.horse

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFTraderLlama(id: ArcticIceFloesEntityId) : AIFLlama(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.TRADER_LLAMA)

}