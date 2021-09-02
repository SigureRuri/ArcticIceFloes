package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.DyeColor
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Sheep
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack

abstract class AIFSheep(id: ArcticIceFloesEntityId) : AIFAnimal(id) {

    abstract val color: DyeColor

    open val isSheared = false

    open fun dyed(event: DyedWoolEvent) {}

    open fun sheared(event: ShearedWoolEvent) {}

    open fun regrowWool(event: RegrowWoolEvent) {}

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.SHEEP)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Sheep) return

        entity.color = color
        entity.isSheared = isSheared
    }

    data class DyedWoolEvent(val entity: Sheep, var color: DyeColor, var isCancelled: Boolean)

    data class ShearedWoolEvent(val entity: Sheep, val hand: EquipmentSlot, val itemStack: ItemStack, var isCancelled: Boolean)

    data class RegrowWoolEvent(val entity: Sheep, var isCancelled: Boolean)

}