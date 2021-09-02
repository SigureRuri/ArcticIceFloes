package com.github.sigureruri.arcticicefloes.entity.living.monster.zombie

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Villager
import org.bukkit.entity.ZombieVillager

abstract class AIFZombieVillager(id: ArcticIceFloesEntityId) : AIFZombie(id) {

    abstract val villagerProfession: Villager.Profession

    abstract val villagerType: Villager.Type

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.ZOMBIE_VILLAGER)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is ZombieVillager) return

        entity.villagerProfession = villagerProfession
        entity.villagerType = villagerType
    }

}