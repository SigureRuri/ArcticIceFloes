package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.entity.AIFEntity
import com.github.sigureruri.arcticicefloes.event.TickEvent
import com.github.sigureruri.arcticicefloes.util.AIFEntityHelper
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByBlockEvent
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.EntityRegainHealthEvent
import org.bukkit.event.entity.EntitySpawnEvent
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.bukkit.inventory.EquipmentSlot

class EntityListener : Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    fun onTick(event: TickEvent) {
        Bukkit.getWorlds().forEach { world ->
            world.entities.forEach { entity ->
                val tickEvent = AIFEntity.TickEvent(entity)
                AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.tick(tickEvent)
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onAttack(event: EntityDamageByEntityEvent) {
        val attacker = event.damager
        val victim = event.entity
        val attackEvent = AIFEntity.AttackEvent(attacker, victim, event.finalDamage, event.isCancelled)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(attacker)?.attack(attackEvent)

        event.damage = attackEvent.damage
        event.isCancelled = attackEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onHurt(event: EntityDamageEvent) {
        val entity = event.entity
        val damagerEntity = (event as? EntityDamageByEntityEvent)?.damager
        val damagerBlock = (event as? EntityDamageByBlockEvent)?.damager
        val hurtEvent = AIFEntity.HurtEvent(entity, event.finalDamage, event.cause, damagerEntity, damagerBlock, event.isCancelled)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.hurt(hurtEvent)

        event.damage = hurtEvent.damage
        event.isCancelled = hurtEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onRegainHealth(event: EntityRegainHealthEvent) {
        val entity = event.entity
        val regainHealthEvent = AIFEntity.RegainHealthEvent(entity, event.amount, event.regainReason, event.isCancelled)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.regainHealth(regainHealthEvent)

        event.amount = regainHealthEvent.amount
        event.isCancelled = regainHealthEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL)
    fun onClicked(event: PlayerInteractEntityEvent) {
        if (event.hand != EquipmentSlot.HAND) return
        val entity = event.rightClicked
        val clickedEvent = AIFEntity.ClickedEvent(entity, event.player, event.isCancelled)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.clicked(clickedEvent)

        event.isCancelled = clickedEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL)
    fun onSpawn(event: EntitySpawnEvent) {
        val entity = event.entity
        val spawnEvent = AIFEntity.SpawnEvent(entity)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.spawn(spawnEvent)
    }

    @EventHandler(priority = EventPriority.NORMAL)
    fun onDeath(event: EntityDeathEvent) {
        val entity = event.entity
        val deathEvent = AIFEntity.DeathEvent(entity)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.death(deathEvent)
    }

}