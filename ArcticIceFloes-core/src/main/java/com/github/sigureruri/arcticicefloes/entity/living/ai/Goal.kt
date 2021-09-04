package com.github.sigureruri.arcticicefloes.entity.living.ai

import java.util.*

abstract class Goal {

    open var flags = EnumSet.noneOf(Flag::class.java)
        set(value) {
            flags.clear()
            field = value
        }

    abstract fun canUse(): Boolean

    open fun canContinueToUse(): Boolean = canUse()

    open fun isInterruptable(): Boolean = true

    open fun start() {}

    open fun stop() {}

    open fun tick() {}

    override fun toString() = javaClass.simpleName

    enum class Flag {
        MOVE, LOOK, JUMP, TARGET
    }

}
