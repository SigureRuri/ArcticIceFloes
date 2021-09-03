package com.github.sigureruri.arcticicefloes.entity.living.monster.slime

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import com.github.sigureruri.arcticicefloes.entity.living.AIFMob
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Slime

abstract class AIFSlime(id: AIFEntityId) : AIFMob(id) {

    open val size = 3

    open fun split(event: SplitEvent) {}

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.SLIME)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Slime) return

        entity.size = size
    }

    data class SplitEvent(val entity: Slime, var count: Int, var isCancelled: Boolean)

}