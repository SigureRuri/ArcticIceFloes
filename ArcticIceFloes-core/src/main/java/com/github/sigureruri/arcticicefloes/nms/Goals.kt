package com.github.sigureruri.arcticicefloes.nms

import com.github.sigureruri.arcticicefloes.entity.living.ai.Goal
import org.bukkit.entity.Creature
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob

interface Goals {

    fun MeleeAttackGoal(creature: Creature, speedModifier: Double, followingTargetEvenIfNotSeen: Boolean): Goal

    fun FleeSunGoal(creature: Creature, speedModifier: Double): Goal

    fun AvoidEntityGoal(creature: Creature, maxDist: Float, walkSpeedModifier: Double, sprintSpeedModifier: Double, predicate: (LivingEntity) -> Boolean): Goal

    fun FloatGoal(mob: Mob): Goal

    fun LeapAtTargetGoal(mob: Mob, speed: Float): Goal

    fun LookAtPlayerGoal(mob: Mob, lookDistance: Float, probability: Float): Goal

    fun PanicGoal(creature: Creature, speedModifier: Double): Goal

    fun RandomLookAroundGoal(mob: Mob): Goal

    fun RandomStrollGoal(creature: Creature, speedModifier: Double, interval: Int, checkNoActionTime: Boolean): Goal

    fun HurtByTargetGoal(creature: Creature): Goal

    fun NearestAttackableTargetGoal(mob: Mob, randomInterval: Int, mustSee: Boolean, mustReach: Boolean, predicate: (LivingEntity) -> Boolean): Goal

}