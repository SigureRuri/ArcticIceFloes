package com.github.sigureruri.arcticicefloes.nms.Paper_v1_17_R1

import com.destroystokyo.paper.util.set.OptimizedSmallEnumSet
import com.github.sigureruri.arcticicefloes.entity.living.ai.Goal
import net.minecraft.world.entity.ai.goal.PathfinderGoal
import java.util.*

class WrappedNMSGoal(private val goal: Goal) : PathfinderGoal() {

    override fun a(): Boolean {
        return goal.canUse()
    }

    override fun b(): Boolean {
        return goal.canContinueToUse()
    }

    override fun C_(): Boolean {
        return goal.isInterruptable()
    }

    override fun c() {
        goal.start()
    }

    override fun d() {
        goal.stop()
    }

    override fun e() {
        goal.tick()
    }

    override fun a(var0: EnumSet<Type>) {
        goal.flags = EnumSet.copyOf(var0.map { Util.convertFlag(it) })
    }

    // Minecraft内の使用用途的にこの実装で問題は起きないはず
    override fun getGoalTypes(): OptimizedSmallEnumSet<Type> {
        return OptimizedSmallEnumSet(Type::class.java).apply {
            addAllUnchecked(goal.flags.map { Util.convertFlag(it) })
        }
    }

}