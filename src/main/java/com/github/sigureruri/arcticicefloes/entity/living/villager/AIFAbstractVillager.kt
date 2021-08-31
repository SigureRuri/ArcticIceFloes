package com.github.sigureruri.arcticicefloes.entity.living.villager

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import com.github.sigureruri.arcticicefloes.entity.living.AIFAgeable
import org.bukkit.entity.AbstractVillager
import org.bukkit.entity.Entity
import org.bukkit.inventory.ItemStack

abstract class AIFAbstractVillager(id: ArcticIceFloesEntityId) : AIFAgeable(id) {

    open val ageLock = true

    open val inventory = Inventory(emptyMap())

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        entity as AbstractVillager

        entity.ageLock = ageLock
        inventory.items.forEach { (slot, itemStack) -> entity.inventory.setItem(slot, itemStack) }

    }

    data class Inventory(val items: Map<Int, ItemStack>)

}