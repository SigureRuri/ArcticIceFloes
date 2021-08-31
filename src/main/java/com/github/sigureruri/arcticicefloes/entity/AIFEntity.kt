package com.github.sigureruri.arcticicefloes.entity

import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageEvent

abstract class AIFEntity(val id: ArcticIceFloesEntityId) {

    open val name: String? = null

    open val nameVisible = false

    open val isSilent = false

    open val hasGravity = true

    open val isInvulnerable = false

    open val isGlowing = false

    open val isVisualFire = false

    open val scoreboardTags: Set<String> = emptySet()


    open fun tick(entity: Entity) {}

    open fun attack(entity: Entity, victim: Entity, damage: Double, cause: EntityDamageEvent, isCancelled: Boolean) {}

    open fun damaged(entity: Entity, damager: Entity?, damage: Double, cause: EntityDamageEvent.DamageCause, isCancelled: Boolean) {}

    open fun clicked(entity: Entity, player: Player, isCancelled: Boolean) {}

    open fun spawn(entity: Entity) {}

    open fun despawn(entity: Entity) {}

    open fun death(entity: Entity) {}

    abstract fun spawnBaseEntity(location: Location): Entity?

    protected open fun applyEntity(entity: Entity) {
        entity.customName = name
        entity.isCustomNameVisible = nameVisible
        entity.isSilent = isSilent
        entity.setGravity(hasGravity)
        entity.isInvulnerable = isInvulnerable
        entity.isGlowing = isGlowing
        entity.isVisualFire = isVisualFire
        scoreboardTags.forEach { entity.addScoreboardTag(it) }

    }

    fun spawn(location: Location): Boolean {
        val entity = spawnBaseEntity(location)?.apply {
            applyEntity(this)
        }
        return entity != null
    }

}