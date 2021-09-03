package com.github.sigureruri.arcticicefloes.loottable

import org.bukkit.entity.LivingEntity
import org.bukkit.inventory.ItemStack

interface AIFLootTable {

    fun generateItems(entity: LivingEntity): List<ItemStack>

}