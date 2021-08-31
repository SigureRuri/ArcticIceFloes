package com.github.sigureruri.arcticicefloes.entity.living.monster

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.block.data.BlockData
import org.bukkit.entity.Enderman
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

abstract class AIFEnderman(id: ArcticIceFloesEntityId) : AIFMonster(id) {

    open val block: BlockData? = null

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.ENDERMAN)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Enderman) return

        entity.carriedBlock = block
    }

}