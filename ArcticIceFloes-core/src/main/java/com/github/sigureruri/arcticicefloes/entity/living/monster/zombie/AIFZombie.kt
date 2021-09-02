package com.github.sigureruri.arcticicefloes.entity.living.monster.zombie

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import com.github.sigureruri.arcticicefloes.entity.living.monster.AIFMonster
import org.bukkit.Location
import org.bukkit.entity.Ageable
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Zombie

abstract class AIFZombie(id: ArcticIceFloesEntityId) : AIFMonster(id) {

    open val isBaby = false

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.ZOMBIE)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Zombie) return

        if (isBaby) (entity as Ageable).setBaby()
    }

}