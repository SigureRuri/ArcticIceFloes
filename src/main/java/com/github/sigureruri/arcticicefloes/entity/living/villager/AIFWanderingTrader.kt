package com.github.sigureruri.arcticicefloes.entity.living.villager

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFWanderingTrader(id: ArcticIceFloesEntityId) : AIFAbstractVillager(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.WANDERING_TRADER)

}