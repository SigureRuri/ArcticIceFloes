package com.github.sigureruri.arcticicefloes.entity.living.monster.piglin

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Piglin
import org.bukkit.inventory.ItemStack

abstract class AIFPiglin(id: AIFEntityId) : AIFAbstractPiglin(id) {

    open val isBaby = false

    open val isAbleToHunt = true

    open val barterList: Set<Material> = emptySet()

    open val interestList: Set<Material> = emptySet()

    open fun barter(event: BarterEvent) {}

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.PIGLIN)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Piglin) return

        if (isBaby) entity.setBaby()
        entity.setIsAbleToHunt(isAbleToHunt)
        barterList.forEach { entity.addBarterMaterial(it) }
        interestList.forEach { entity.addMaterialOfInterest(it) }
    }

    data class BarterEvent(
        val entity: Piglin,
        val input: ItemStack,
        val outcome: List<ItemStack>,
        var isCancelled: Boolean
    )

}