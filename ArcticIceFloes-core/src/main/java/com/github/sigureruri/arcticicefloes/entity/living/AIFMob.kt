package com.github.sigureruri.arcticicefloes.entity.living

import com.github.sigureruri.arcticicefloes.ArcticIceFloesApi
import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import com.github.sigureruri.arcticicefloes.entity.living.ai.Goal
import org.bukkit.entity.Entity
import org.bukkit.entity.Mob

abstract class AIFMob(id: AIFEntityId) : AIFLivingEntity(id) {

    open val useCustomAI = false

    open val goalSelectors: List<Pair<Int, Goal>> = emptyList()

    open val targetSelectors: List<Pair<Int, Goal>> = emptyList()

    override fun applyEntity(entity: Entity) {
        super.applyEntity(entity)

        if (entity !is Mob) return

        if (useCustomAI) {
            ArcticIceFloesApi.NMS.clearAiGoals(entity)
            goalSelectors.forEach {
                ArcticIceFloesApi.NMS.addGoalSelector(entity, it.first, it.second)
            }
            targetSelectors.forEach {
                ArcticIceFloesApi.NMS.addGoalSelector(entity, it.first, it.second)
            }
        }
    }

}