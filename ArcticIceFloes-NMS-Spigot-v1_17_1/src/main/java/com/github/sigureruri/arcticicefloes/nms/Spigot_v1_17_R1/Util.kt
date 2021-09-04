package com.github.sigureruri.arcticicefloes.nms.Spigot_v1_17_R1

import com.github.sigureruri.arcticicefloes.entity.living.ai.Goal
import net.minecraft.world.entity.ai.attributes.GenericAttributes
import net.minecraft.world.entity.ai.goal.PathfinderGoal
import org.bukkit.attribute.Attribute

object Util {

    fun convertFlag(flag: Goal.Flag) = when(flag) {
        Goal.Flag.MOVE -> PathfinderGoal.Type.a
        Goal.Flag.LOOK -> PathfinderGoal.Type.b
        Goal.Flag.JUMP -> PathfinderGoal.Type.c
        Goal.Flag.TARGET -> PathfinderGoal.Type.d
    }

    fun convertFlag(flag: PathfinderGoal.Type) = when(flag) {
        PathfinderGoal.Type.a -> Goal.Flag.MOVE
        PathfinderGoal.Type.b -> Goal.Flag.LOOK
        PathfinderGoal.Type.c -> Goal.Flag.JUMP
        PathfinderGoal.Type.d -> Goal.Flag.TARGET
    }

    fun convertAttribute(attribute: Attribute) = when (attribute) {
        Attribute.GENERIC_MAX_HEALTH -> GenericAttributes.a
        Attribute.GENERIC_FOLLOW_RANGE -> GenericAttributes.b
        Attribute.GENERIC_KNOCKBACK_RESISTANCE -> GenericAttributes.c
        Attribute.GENERIC_MOVEMENT_SPEED -> GenericAttributes.d
        Attribute.GENERIC_FLYING_SPEED -> GenericAttributes.e
        Attribute.GENERIC_ATTACK_DAMAGE -> GenericAttributes.f
        Attribute.GENERIC_ATTACK_KNOCKBACK -> GenericAttributes.g
        Attribute.GENERIC_ATTACK_SPEED -> GenericAttributes.h
        Attribute.GENERIC_ARMOR -> GenericAttributes.i
        Attribute.GENERIC_ARMOR_TOUGHNESS -> GenericAttributes.j
        Attribute.GENERIC_LUCK -> GenericAttributes.k
        Attribute.HORSE_JUMP_STRENGTH -> GenericAttributes.l
        Attribute.ZOMBIE_SPAWN_REINFORCEMENTS -> GenericAttributes.m
    }

}