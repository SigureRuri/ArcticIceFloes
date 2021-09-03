package com.github.sigureruri.arcticicefloes.entity.living.monster

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Creeper
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.LightningStrike
import org.bukkit.event.entity.CreeperPowerEvent

abstract class AIFCreeper(
    id: AIFEntityId
) : AIFMonster(id) {

    open val fuseTicks = 30

    open val explosionRadius = 3

    open val isPowered = false

    open fun powered(event: PoweredEvent) {}

    open fun explode(event: ExplodeEvent) {}

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.CREEPER)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Creeper) return

        entity.fuseTicks = fuseTicks
        entity.explosionRadius = explosionRadius
        entity.isPowered = isPowered
    }

    data class PoweredEvent(val entity: Creeper, val lightning: LightningStrike?, val cause: CreeperPowerEvent.PowerCause, var isCancelled: Boolean)

    data class ExplodeEvent(val entity: Creeper, val location: Location, var yield: Float, var isCancelled: Boolean)

}