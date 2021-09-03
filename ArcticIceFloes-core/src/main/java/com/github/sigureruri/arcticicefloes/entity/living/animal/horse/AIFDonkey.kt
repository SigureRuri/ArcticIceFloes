package com.github.sigureruri.arcticicefloes.entity.living.animal.horse

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFDonkey(id: AIFEntityId) : AIFChestedHorse(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.DONKEY)

}