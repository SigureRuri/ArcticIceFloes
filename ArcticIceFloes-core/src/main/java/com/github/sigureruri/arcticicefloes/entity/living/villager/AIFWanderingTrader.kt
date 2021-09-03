package com.github.sigureruri.arcticicefloes.entity.living.villager

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFWanderingTrader(id: AIFEntityId) : AIFAbstractVillager(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.WANDERING_TRADER)

}