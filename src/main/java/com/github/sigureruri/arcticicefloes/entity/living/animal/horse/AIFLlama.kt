package com.github.sigureruri.arcticicefloes.entity.living.animal.horse

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Llama
import org.bukkit.inventory.ItemStack

abstract class AIFLlama(id: ArcticIceFloesEntityId) : AIFChestedHorse(id) {

    abstract val color: Llama.Color

    open val decor: ItemStack? = null

    open val strength = 1

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.LLAMA)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Llama) return

        entity.color = color
        entity.inventory.decor = decor
        entity.strength = strength
    }

}