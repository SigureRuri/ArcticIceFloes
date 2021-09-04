package com.github.sigureruri.arcticicefloes.nms.Spigot_v1_17_R1

import com.github.sigureruri.arcticicefloes.entity.living.ai.Goal
import net.minecraft.world.entity.ai.goal.PathfinderGoal
import java.util.*

class WrappedAIFGoal(private val nmsGoal: PathfinderGoal) : Goal() {

    override var flags: EnumSet<Flag>?
        get() {
            return EnumSet.copyOf(nmsGoal.i().map { Util.convertFlag(it) })
        }
        set(value) {
            nmsGoal.a(EnumSet.copyOf(value?.map { Util.convertFlag(it) }))
        }

    override fun canUse(): Boolean {
        return nmsGoal.a()
    }

    override fun canContinueToUse(): Boolean {
        return nmsGoal.b()
    }

    override fun isInterruptable(): Boolean {
        return nmsGoal.C_()
    }

    override fun start() {
        return nmsGoal.c()
    }

    override fun stop() {
        return nmsGoal.d()
    }

    override fun tick() {
        return nmsGoal.e()
    }

}