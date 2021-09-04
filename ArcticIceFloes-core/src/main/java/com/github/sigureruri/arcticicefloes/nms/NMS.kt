package com.github.sigureruri.arcticicefloes.nms

import com.github.sigureruri.arcticicefloes.entity.living.ai.Goal
import org.bukkit.attribute.Attribute
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob

interface NMS {

    val navigation: Navigation

    val goals: Goals

    fun clearAiGoals(mob: Mob)

    fun addGoalSelector(mob: Mob, priority: Int, goal: Goal)

    fun addTargetSelector(mob: Mob, priority: Int, goal: Goal)

    fun registerAttribute(entity: LivingEntity, attribute: Attribute)

}