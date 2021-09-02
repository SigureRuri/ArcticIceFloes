package com.github.sigureruri.arcticicefloes.entity.living.monster.hoglin

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import com.github.sigureruri.arcticicefloes.entity.living.monster.AIFMonster
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Zoglin

abstract class AIFZoglin(id: ArcticIceFloesEntityId) : AIFMonster(id) {

    open val isBaby = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.ZOGLIN)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Zoglin) return

        if (isBaby) entity.setBaby()
    }

}