package com.github.sigureruri.arcticicefloes.entity.living.animal.horse

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import com.github.sigureruri.arcticicefloes.entity.living.animal.AIFTameableAnimal
import org.bukkit.Material
import org.bukkit.entity.AbstractHorse
import org.bukkit.entity.Entity
import org.bukkit.inventory.ItemStack

abstract class AIFAbstractHorse(id: AIFEntityId) : AIFTameableAnimal(id) {

    open val hasSaddle = false

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        entity as AbstractHorse

        if (hasSaddle) entity.inventory.saddle = ItemStack(Material.SADDLE)
    }

}