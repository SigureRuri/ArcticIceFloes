package com.github.sigureruri.arcticicefloes.entity.living.monster.piglin

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Piglin

abstract class AIFPiglin(id: ArcticIceFloesEntityId) : AIFAbstractPiglin(id) {

    open val isBaby = false

    open val isAbleToHunt = true

    open val barterList: Set<Material> = emptySet()

    open val interestList: Set<Material> = emptySet()

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

}