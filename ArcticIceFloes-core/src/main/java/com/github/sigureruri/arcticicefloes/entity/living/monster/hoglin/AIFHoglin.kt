package com.github.sigureruri.arcticicefloes.entity.living.monster.hoglin

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import com.github.sigureruri.arcticicefloes.entity.living.animal.AIFAnimal
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Hoglin

abstract class AIFHoglin(id: ArcticIceFloesEntityId) : AIFAnimal(id) {

    open val isAbleToBeHunted = true

    open val isImmuneToZombification = true

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.HOGLIN)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Hoglin) return

        entity.setIsAbleToBeHunted(isAbleToBeHunted)
        entity.isImmuneToZombification = isImmuneToZombification
    }

}