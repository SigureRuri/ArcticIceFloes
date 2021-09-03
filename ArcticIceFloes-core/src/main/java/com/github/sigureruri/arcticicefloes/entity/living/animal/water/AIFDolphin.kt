package com.github.sigureruri.arcticicefloes.entity.living.animal.water

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFDolphin(id: AIFEntityId) : AIFWaterAnimal(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.DOLPHIN)

}