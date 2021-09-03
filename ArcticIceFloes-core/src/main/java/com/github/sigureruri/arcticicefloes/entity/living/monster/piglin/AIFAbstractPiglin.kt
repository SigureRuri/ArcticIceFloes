package com.github.sigureruri.arcticicefloes.entity.living.monster.piglin

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import com.github.sigureruri.arcticicefloes.entity.living.monster.AIFMonster
import org.bukkit.entity.Entity
import org.bukkit.entity.PiglinAbstract

abstract class AIFAbstractPiglin(id: AIFEntityId) : AIFMonster(id) {

    val isImmuneToZombification = true

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is PiglinAbstract) return

        entity.isImmuneToZombification = isImmuneToZombification
    }

}