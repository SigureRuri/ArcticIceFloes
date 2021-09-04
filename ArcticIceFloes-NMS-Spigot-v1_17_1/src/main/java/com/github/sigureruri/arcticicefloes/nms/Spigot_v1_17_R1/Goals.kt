package com.github.sigureruri.arcticicefloes.nms.Spigot_v1_17_R1

import com.github.sigureruri.arcticicefloes.entity.living.ai.Goal
import com.github.sigureruri.arcticicefloes.nms.Goals
import net.minecraft.server.level.EntityPlayer
import net.minecraft.world.entity.EntityLiving
import net.minecraft.world.entity.ai.goal.PathfinderGoalAvoidTarget
import net.minecraft.world.entity.ai.goal.PathfinderGoalFleeSun
import net.minecraft.world.entity.ai.goal.PathfinderGoalFloat
import net.minecraft.world.entity.ai.goal.PathfinderGoalLeapAtTarget
import net.minecraft.world.entity.ai.goal.PathfinderGoalLookAtPlayer
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack
import net.minecraft.world.entity.ai.goal.PathfinderGoalPanic
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomLookaround
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomStroll
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalHurtByTarget
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftCreature
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftMob
import org.bukkit.entity.Creature
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob

class Goals : Goals {

    override fun MeleeAttackGoal(creature: Creature, speedModifier: Double, followingTargetEvenIfNotSeen: Boolean): Goal {
        val nmsMob = (creature as? CraftCreature)?.handle ?: throw IllegalArgumentException()
        val nsmGoal = PathfinderGoalMeleeAttack(nmsMob, speedModifier, followingTargetEvenIfNotSeen)
        return WrappedAIFGoal(nsmGoal)
    }

    override fun HurtByTargetGoal(creature: Creature): Goal {
        val nmsMob = (creature as? CraftCreature)?.handle ?: throw IllegalArgumentException()
        val nsmGoal = PathfinderGoalHurtByTarget(nmsMob)
        return WrappedAIFGoal(nsmGoal)
    }

    override fun FleeSunGoal(creature: Creature, speedModifier: Double): Goal {
        val nmsMob = (creature as? CraftCreature)?.handle ?: throw IllegalArgumentException()
        val nsmGoal = PathfinderGoalFleeSun(nmsMob, speedModifier)
        return WrappedAIFGoal(nsmGoal)
    }

    override fun AvoidEntityGoal(creature: Creature, maxDist: Float, walkSpeedModifier: Double, sprintSpeedModifier: Double, predicate: (LivingEntity) -> Boolean): Goal {
        val nmsMob = (creature as? CraftCreature)?.handle ?: throw IllegalArgumentException()
        val nsmGoal = PathfinderGoalAvoidTarget(nmsMob, EntityLiving::class.java, maxDist, walkSpeedModifier, sprintSpeedModifier) {
            predicate(it.bukkitEntity as LivingEntity)
        }
        return WrappedAIFGoal(nsmGoal)
    }

    override fun FloatGoal(mob: Mob): Goal {
        val nmsMob = (mob as? CraftMob)?.handle ?: throw IllegalArgumentException()
        val nsmGoal = PathfinderGoalFloat(nmsMob)
        return WrappedAIFGoal(nsmGoal)
    }

    override fun LeapAtTargetGoal(mob: Mob, speed: Float): Goal {
        val nmsMob = (mob as? CraftMob)?.handle ?: throw IllegalArgumentException()
        val nsmGoal = PathfinderGoalLeapAtTarget(nmsMob, speed)
        return WrappedAIFGoal(nsmGoal)
    }

    override fun LookAtPlayerGoal(mob: Mob, lookDistance: Float, probability: Float): Goal {
        val nmsMob = (mob as? CraftMob)?.handle ?: throw IllegalArgumentException()
        val nsmGoal = PathfinderGoalLookAtPlayer(nmsMob, EntityPlayer::class.java, lookDistance, probability)
        return WrappedAIFGoal(nsmGoal)
    }

    override fun PanicGoal(creature: Creature, speedModifier: Double): Goal {
        val nmsMob = (creature as? CraftCreature)?.handle ?: throw IllegalArgumentException()
        val nsmGoal = PathfinderGoalPanic(nmsMob, speedModifier)
        return WrappedAIFGoal(nsmGoal)
    }

    override fun RandomLookAroundGoal(mob: Mob): Goal {
        val nmsMob = (mob as? CraftMob)?.handle ?: throw IllegalArgumentException()
        val nsmGoal = PathfinderGoalRandomLookaround(nmsMob)
        return WrappedAIFGoal(nsmGoal)
    }

    override fun RandomStrollGoal(creature: Creature, speedModifier: Double, interval: Int, checkNoActionTime: Boolean): Goal {
        val nmsMob = (creature as? CraftCreature)?.handle ?: throw IllegalArgumentException()
        val nsmGoal = PathfinderGoalRandomStroll(nmsMob, speedModifier, interval, checkNoActionTime)
        return WrappedAIFGoal(nsmGoal)
    }

    override fun NearestAttackableTargetGoal(
        mob: Mob,
        randomInterval: Int,
        mustSee: Boolean,
        mustReach: Boolean,
        predicate: (LivingEntity) -> Boolean
    ): Goal {
        val nmsMob = (mob as? CraftMob)?.handle ?: throw IllegalArgumentException()
        val nsmGoal = PathfinderGoalNearestAttackableTarget(nmsMob, EntityLiving::class.java, randomInterval, mustSee, mustReach) { entityLiving ->
            predicate(entityLiving.bukkitEntity as LivingEntity)
        }

        return WrappedAIFGoal(nsmGoal)
    }

}