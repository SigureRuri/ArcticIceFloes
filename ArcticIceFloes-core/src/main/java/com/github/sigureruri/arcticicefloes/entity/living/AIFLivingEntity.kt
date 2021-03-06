package com.github.sigureruri.arcticicefloes.entity.living

import com.github.sigureruri.arcticicefloes.ArcticIceFloesApi
import com.github.sigureruri.arcticicefloes.entity.AIFEntity
import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import com.github.sigureruri.arcticicefloes.loottable.AIFLootTable
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect

abstract class AIFLivingEntity(id: AIFEntityId) : AIFEntity(id) {

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

    open val potionEffects: List<PotionEffect> = emptyList()

    open val lootTable: AIFLootTable? = null

    open fun shootBow(event: ShootBowEvent) {}

    open fun breed(event: BreedEvent) {}

    open fun death(event: DeathEvent) {}

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

        attributes.forEach { (attribute, value) ->
            ArcticIceFloesApi.NMS.registerAttribute(entity, attribute)
            entity.getAttribute(attribute)?.baseValue = value
        }

        equipments.forEach { entity.equipment?.setItem(it.key, it.value) }
        equipmentsDropChance[EquipmentSlot.HAND]?.let { entity.equipment?.itemInMainHandDropChance = it }
        equipmentsDropChance[EquipmentSlot.OFF_HAND]?.let { entity.equipment?.itemInOffHandDropChance = it }
        equipmentsDropChance[EquipmentSlot.HEAD]?.let { entity.equipment?.helmetDropChance = it }
        equipmentsDropChance[EquipmentSlot.CHEST]?.let { entity.equipment?.chestplateDropChance = it }
        equipmentsDropChance[EquipmentSlot.LEGS]?.let { entity.equipment?.leggingsDropChance = it }
        equipmentsDropChance[EquipmentSlot.FEET]?.let { entity.equipment?.bootsDropChance = it }

        entity.addPotionEffects(potionEffects)
    }

    data class ShootBowEvent(
        val entity: LivingEntity,
        val consumable: ItemStack?,
        val bow: ItemStack?,
        val force: Float,
        val hand: EquipmentSlot,
        var projectile: Entity,
        var shouldConsumeItem: Boolean,
        var isCancelled: Boolean
    )

    data class BreedEvent(
        val entity: LivingEntity,
        val mother: LivingEntity,
        val father: LivingEntity,
        val breeder: LivingEntity?,
        val bredWith: ItemStack?,
        var experience: Int,
        var isCancelled: Boolean
    )

    data class DeathEvent(val entity: Entity)

}