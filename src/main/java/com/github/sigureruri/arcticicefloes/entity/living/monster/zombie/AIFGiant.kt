package com.github.sigureruri.arcticicefloes.entity.living.monster.zombie

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import com.github.sigureruri.arcticicefloes.entity.living.monster.AIFMonster
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFGiant(id: ArcticIceFloesEntityId) : AIFMonster(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.GIANT)

}