package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.entity.Axolotl
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFAxolotl(id: AIFEntityId) : AIFAnimal(id) {

    abstract val variant: Axolotl.Variant

    open val isPlayingDead = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.AXOLOTL)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Axolotl) return

        entity.variant = variant
        entity.isPlayingDead = isPlayingDead
    }

}