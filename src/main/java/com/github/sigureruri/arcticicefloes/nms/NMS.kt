package com.github.sigureruri.arcticicefloes.nms

import com.github.sigureruri.arcticicefloes.entity.living.ai.Goal
import org.bukkit.entity.Mob

interface NMS {

    fun clearAiGoals(mob: Mob)

    fun addGoalSelector(mob: Mob, priority: Int, goal: Goal)

    fun addTargetSelector(mob: Mob, priority: Int, goal: Goal)

}