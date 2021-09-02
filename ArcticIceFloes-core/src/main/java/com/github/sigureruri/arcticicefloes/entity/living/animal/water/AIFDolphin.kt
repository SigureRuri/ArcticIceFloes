package com.github.sigureruri.arcticicefloes.entity.living.animal.water

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFDolphin(id: ArcticIceFloesEntityId) : AIFWaterAnimal(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.DOLPHIN)

}