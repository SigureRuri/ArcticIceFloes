package com.github.sigureruri.arcticicefloes.entity.living.animal.horse

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFZombieHorse(id: ArcticIceFloesEntityId) : AIFAbstractHorse(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.ZOMBIE_HORSE)

}