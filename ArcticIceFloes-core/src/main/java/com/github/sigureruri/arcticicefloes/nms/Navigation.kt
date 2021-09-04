package com.github.sigureruri.arcticicefloes.nms

import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.Mob

interface Navigation {

    fun moveTo(mob: Mob, target: Location, speed: Double)

    fun moveTo(mob: Mob, target: Entity, speed: Double)

}