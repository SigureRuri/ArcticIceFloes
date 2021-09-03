package com.github.sigureruri.arcticicefloes.entity.living.monster.illager

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import com.github.sigureruri.arcticicefloes.entity.living.AIFMob
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Vex

abstract class AIFVex(id: AIFEntityId) : AIFMob(id) {

    open val isCharging = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.VEX)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Vex) return

        entity.isCharging = isCharging
    }

}