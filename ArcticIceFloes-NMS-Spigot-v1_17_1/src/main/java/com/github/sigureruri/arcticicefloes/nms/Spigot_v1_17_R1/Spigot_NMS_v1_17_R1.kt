package com.github.sigureruri.arcticicefloes.nms.Spigot_v1_17_R1

import com.github.sigureruri.arcticicefloes.entity.living.ai.Goal
import com.github.sigureruri.arcticicefloes.nms.NMS
import net.minecraft.world.entity.ai.attributes.AttributeBase
import net.minecraft.world.entity.ai.attributes.AttributeModifiable
import net.minecraft.world.entity.ai.goal.PathfinderGoalSelector
import org.bukkit.attribute.Attribute
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftLivingEntity
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftMob
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob

class Spigot_NMS_v1_17_R1 : NMS {

    override val navigation = Navigation()

    override val goals = Goals()

    override fun clearAiGoals(mob: Mob) {
        val nmsMob = (mob as CraftMob).handle
        nmsMob.bP = PathfinderGoalSelector(nmsMob.world.methodProfilerSupplier)
        nmsMob.bQ = PathfinderGoalSelector(nmsMob.world.methodProfilerSupplier)
    }

    override fun addGoalSelector(mob: Mob, priority: Int, goal: Goal) {
        val nmsMob = (mob as CraftMob).handle
        nmsMob.bP.a(priority, WrappedNMSGoal(goal))
    }

    override fun addTargetSelector(mob: Mob, priority: Int, goal: Goal) {
        val nmsMob = (mob as CraftMob).handle
        nmsMob.bQ.a(priority, WrappedNMSGoal(goal))
    }

    @Suppress("UNCHECKED_CAST")
    override fun registerAttribute(entity: LivingEntity, attribute: Attribute) {
        val nmsMob = (entity as CraftLivingEntity).handle
        val nmsAttributeMap = nmsMob.attributeMap
        val convertedAttribute = Util.convertAttribute(attribute)

        val registeredAttributesMapField = nmsAttributeMap::class.java.getDeclaredField("b").apply { isAccessible = true }
        val registeredAttributesMap = registeredAttributesMapField.get(nmsAttributeMap) as HashMap<AttributeBase, AttributeModifiable>
        registeredAttributesMap[convertedAttribute] = AttributeModifiable(convertedAttribute, AttributeModifiable::getAttribute)
    }

}