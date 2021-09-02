package com.github.sigureruri.arcticicefloes.entity.living.golem

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.DyeColor
import org.bukkit.Location
import org.bukkit.block.BlockFace
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Shulker

abstract class AIFShulker(id: ArcticIceFloesEntityId) : AIFGolem(id) {

    abstract val color: DyeColor

    open val attachedFace = BlockFace.DOWN

    open val peek = 0.0f

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.SHULKER)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Shulker) return

        entity.color = color
        entity.attachedFace = attachedFace
        entity.peek = peek
    }

}