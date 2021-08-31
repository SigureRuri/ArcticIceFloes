package com.github.sigureruri.arcticicefloes.entity.living.monster

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFEndermite(id: ArcticIceFloesEntityId) : AIFMonster(id) {

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.ENDERMITE)

}