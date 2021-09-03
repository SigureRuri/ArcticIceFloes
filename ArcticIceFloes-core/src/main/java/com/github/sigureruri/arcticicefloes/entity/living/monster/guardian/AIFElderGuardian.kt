package com.github.sigureruri.arcticicefloes.entity.living.monster.guardian

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFElderGuardian(id: AIFEntityId) : AIFGuardian(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.ELDER_GUARDIAN)

}