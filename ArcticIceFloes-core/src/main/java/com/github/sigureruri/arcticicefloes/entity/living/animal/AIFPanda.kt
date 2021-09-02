package com.github.sigureruri.arcticicefloes.entity.living.animal

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Panda

abstract class AIFPanda(id: ArcticIceFloesEntityId) : AIFAnimal(id) {

    abstract val mainGene: Panda.Gene

    abstract val hiddenGene: Panda.Gene

    override fun spawnBaseEntity(location: Location): Entity? =
        location.world?.spawnEntity(location, EntityType.PANDA)

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Panda) return

        entity.mainGene = mainGene
        entity.hiddenGene = hiddenGene
    }

}