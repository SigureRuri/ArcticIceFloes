package com.github.sigureruri.arcticicefloes.entity.living.monster.zombie

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.PigZombie

abstract class AIFZombifiedPiglin(id: AIFEntityId) : AIFZombie(id) {

    open val isAngry = false

    open fun anger(event: AngerEvent) {}

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.ZOMBIFIED_PIGLIN)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is PigZombie) return

        entity.isAngry = isAngry
    }

    data class AngerEvent(
        val entity: PigZombie,
        var newAnger: Int,
        val target: Entity?,
        var isCancelled: Boolean
    )

}