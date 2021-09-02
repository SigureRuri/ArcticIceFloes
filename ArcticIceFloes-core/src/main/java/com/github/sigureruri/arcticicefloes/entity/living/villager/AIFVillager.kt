package com.github.sigureruri.arcticicefloes.entity.living.villager

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Villager

abstract class AIFVillager(id: ArcticIceFloesEntityId) : AIFAbstractVillager(id) {

    abstract val profession: Villager.Profession

    abstract val villagerType: Villager.Type

    open val villagerLevel = 1

    open val villagerExperience = 0

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.VILLAGER)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Villager) return

        entity.profession = profession
        entity.villagerType = villagerType
        entity.villagerLevel = villagerLevel
        entity.villagerExperience = villagerExperience
    }

}