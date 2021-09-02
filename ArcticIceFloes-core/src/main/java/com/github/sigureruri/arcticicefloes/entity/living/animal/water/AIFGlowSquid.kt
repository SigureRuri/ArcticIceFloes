package com.github.sigureruri.arcticicefloes.entity.living.animal.water

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.GlowSquid

abstract class AIFGlowSquid(id: ArcticIceFloesEntityId) : AIFWaterAnimal(id) {

    open val darkTicksRemaining = 0

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.GLOW_SQUID)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is GlowSquid) return

        entity.darkTicksRemaining = darkTicksRemaining
    }

}