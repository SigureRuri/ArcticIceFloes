package com.github.sigureruri.arcticicefloes.entity.living.animal.horse

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.entity.ChestedHorse
import org.bukkit.entity.Entity
import org.bukkit.inventory.ItemStack

abstract class AIFChestedHorse(id: ArcticIceFloesEntityId) : AIFAbstractHorse(id) {

    open val isCarryingChest = false

    open val chest = Chest(emptyMap())

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is ChestedHorse) return

        entity.isCarryingChest = isCarryingChest

        if (isCarryingChest) {
            chest.items.forEach { (slot, itemStack) ->
                entity.inventory.setItem(slot, itemStack)
            }
        }
    }

    data class Chest(val items: Map<Int, ItemStack>)

}