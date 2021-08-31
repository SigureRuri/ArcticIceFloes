package com.github.sigureruri.arcticicefloes.entity

import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFEnderCrystal(id: ArcticIceFloesEntityId) : AIFEntity(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.ENDER_CRYSTAL)

}