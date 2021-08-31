package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Bee
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFBee(id: ArcticIceFloesEntityId) : AIFAnimal(id) {

    open val anger = 0

    open val hasNectar = false

    open val hasStung = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.BEE)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Bee) return

        entity.anger = anger
        entity.setHasNectar(hasNectar)
        entity.setHasStung(hasStung)
    }

}