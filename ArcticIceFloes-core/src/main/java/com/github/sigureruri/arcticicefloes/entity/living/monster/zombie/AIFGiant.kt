package com.github.sigureruri.arcticicefloes.entity.living.monster.zombie

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import com.github.sigureruri.arcticicefloes.entity.living.monster.AIFMonster
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFGiant(id: AIFEntityId) : AIFMonster(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.GIANT)

}