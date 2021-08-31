package com.github.sigureruri.arcticicefloes.entity.living

import com.github.sigureruri.arcticicefloes.entity.AIFEntity
import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack

abstract class AIFLivingEntity(id: ArcticIceFloesEntityId) : AIFEntity(id) {

    open val hasAI = true

    open val arrowsInBody = 0

    open val canPickupItems = false

    open val isCollidable = true

    open val isGliding = false

    open val isInvisible = false

    open val maximumAir = 20

    open val remainingAir = 20

    open val isSwimming = false

    open val removeWhenFarAway = true

    open val attributes: Map<Attribute, Double> = emptyMap()

    open val equipments: Map<EquipmentSlot, ItemStack> = emptyMap()

    open val equipmentsDropChance: Map<EquipmentSlot, Float> = emptyMap()

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is LivingEntity) return

        entity.setAI(hasAI)
        entity.arrowsInBody = arrowsInBody
        entity.canPickupItems = canPickupItems
        entity.isCollidable = isCollidable
        entity.isGliding = isGliding
        entity.isInvisible = isInvisible
        entity.maximumAir = maximumAir
        entity.remainingAir = remainingAir
        entity.isSwimming = isSwimming
        entity.removeWhenFarAway = removeWhenFarAway

        attributes.forEach { entity.getAttribute(it.key)?.baseValue = it.value }

        equipments.forEach { entity.equipment?.setItem(it.key, it.value) }
        equipmentsDropChance[EquipmentSlot.HAND]?.let { entity.equipment?.itemInMainHandDropChance = it }
        equipmentsDropChance[EquipmentSlot.OFF_HAND]?.let { entity.equipment?.itemInOffHandDropChance = it }
        equipmentsDropChance[EquipmentSlot.HEAD]?.let { entity.equipment?.helmetDropChance = it }
        equipmentsDropChance[EquipmentSlot.CHEST]?.let { entity.equipment?.chestplateDropChance = it }
        equipmentsDropChance[EquipmentSlot.LEGS]?.let { entity.equipment?.leggingsDropChance = it }
        equipmentsDropChance[EquipmentSlot.FEET]?.let { entity.equipment?.bootsDropChance = it }
    }

}