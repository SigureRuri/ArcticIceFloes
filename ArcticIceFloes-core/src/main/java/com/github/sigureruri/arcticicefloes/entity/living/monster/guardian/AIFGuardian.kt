package com.github.sigureruri.arcticicefloes.entity.living.monster.guardian

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import com.github.sigureruri.arcticicefloes.entity.living.monster.AIFMonster
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Guardian

abstract class AIFGuardian(id: AIFEntityId) : AIFMonster(id) {

    open val hasLaser = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.GUARDIAN)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Guardian) return

        entity.setLaser(hasLaser)
    }

}