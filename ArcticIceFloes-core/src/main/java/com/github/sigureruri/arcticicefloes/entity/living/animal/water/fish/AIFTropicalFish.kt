package com.github.sigureruri.arcticicefloes.entity.living.animal.water.fish

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.DyeColor
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.TropicalFish

abstract class AIFTropicalFish(id: AIFEntityId) : AIFFish(id) {

    abstract val bodyColor: DyeColor

    abstract val pattern: TropicalFish.Pattern

    abstract val patternColor: DyeColor

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.TROPICAL_FISH)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is TropicalFish) return

        entity.bodyColor = bodyColor
        entity.pattern = pattern
        entity.patternColor = patternColor
    }

}