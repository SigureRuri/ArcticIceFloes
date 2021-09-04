package com.github.sigureruri.arcticicefloes.nms.Spigot_v1_17_R1

import com.github.sigureruri.arcticicefloes.nms.Navigation
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftEntity
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftMob
import org.bukkit.entity.Entity
import org.bukkit.entity.Mob

class Navigation : Navigation {

    override fun moveTo(mob: Mob, target: Location, speed: Double) {
        val nmsMob = (mob as? CraftMob)?.handle ?: return
        nmsMob.navigation.a(target.x, target.y, target.z, speed)
    }

    override fun moveTo(mob: Mob, target: Entity, speed: Double) {
        val nmsMob = (mob as? CraftMob)?.handle ?: return
        val nmsTarget = (mob as? CraftEntity)?.handle ?: return
        nmsMob.navigation.a(nmsTarget, speed)
    }

}