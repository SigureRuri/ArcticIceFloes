package com.github.sigureruri.arcticicefloes.entity

import org.bukkit.Location
import org.bukkit.entity.EnderCrystal
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFEnderCrystal(id: ArcticIceFloesEntityId) : AIFEntity(id) {

    open val isShowingBottom = true

    open fun explode(event: ExplodeEvent) {}

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.ENDER_CRYSTAL)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is EnderCrystal) return

        entity.isShowingBottom = isShowingBottom
    }

    data class ExplodeEvent(val entity: EnderCrystal, val location: Location, var yield: Float, var isCancelled: Boolean)

}