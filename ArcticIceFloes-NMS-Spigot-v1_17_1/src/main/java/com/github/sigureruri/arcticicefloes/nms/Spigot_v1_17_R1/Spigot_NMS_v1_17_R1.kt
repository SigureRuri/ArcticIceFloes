package com.github.sigureruri.arcticicefloes.nms.Spigot_v1_17_R1

import com.github.sigureruri.arcticicefloes.entity.living.ai.Goal
import com.github.sigureruri.arcticicefloes.nms.NMS
import net.minecraft.world.entity.ai.goal.PathfinderGoalSelector
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftMob
import org.bukkit.entity.Mob

class Spigot_NMS_v1_17_R1 : NMS {

    override fun clearAiGoals(mob: Mob) {
        val nmsMob = (mob as CraftMob).handle
        nmsMob.bP = PathfinderGoalSelector(nmsMob.world.methodProfilerSupplier)
        nmsMob.bQ = PathfinderGoalSelector(nmsMob.world.methodProfilerSupplier)
    }

    override fun addGoalSelector(mob: Mob, priority: Int, goal: Goal) {
        val nmsMob = (mob as CraftMob).handle
        nmsMob.bP.a(priority, WrappedGoal(goal))
    }

    override fun addTargetSelector(mob: Mob, priority: Int, goal: Goal) {
        val nmsMob = (mob as CraftMob).handle
        nmsMob.bQ.a(priority, WrappedGoal(goal))
    }

}