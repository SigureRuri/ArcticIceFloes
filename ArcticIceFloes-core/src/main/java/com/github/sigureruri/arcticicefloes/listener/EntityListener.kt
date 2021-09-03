package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.entity.AIFEntity
import com.github.sigureruri.arcticicefloes.event.TickEvent
import com.github.sigureruri.arcticicefloes.util.AIFEntityHelper
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.EntityBlockFormEvent
import org.bukkit.event.entity.EntityAirChangeEvent
import org.bukkit.event.entity.EntityDamageByBlockEvent
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDropItemEvent
import org.bukkit.event.entity.EntityInteractEvent
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.entity.EntityPortalEvent
import org.bukkit.event.entity.EntityRegainHealthEvent
import org.bukkit.event.entity.EntitySpawnEvent
import org.bukkit.event.entity.EntityTransformEvent
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

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onClicked(event: PlayerInteractEntityEvent) {
        if (event.hand != EquipmentSlot.HAND) return
        val entity = event.rightClicked
        val clickedEvent = AIFEntity.ClickedEvent(entity, event.player, event.isCancelled)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.clicked(clickedEvent)

        event.isCancelled = clickedEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onTeleportedByPortal(event: EntityPortalEvent) {
        val entity = event.entity
        val teleportByPortalEvent = AIFEntity.TeleportByPortalEvent(entity, event.from, event.to, event.searchRadius, event.isCancelled)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.teleportByPortal(teleportByPortalEvent)

        event.from = teleportByPortalEvent.from
        event.to = teleportByPortalEvent.to
        event.searchRadius = teleportByPortalEvent.searchRadius
        event.isCancelled = teleportByPortalEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onInteractBlock(event: EntityInteractEvent) {
        val entity = event.entity
        val interactBlockEvent = AIFEntity.InteractBlockEvent(entity, event.block, event.isCancelled)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.interactBlock(interactBlockEvent)

        event.isCancelled = interactBlockEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onDropItem(event: EntityDropItemEvent) {
        val entity = event.entity
        val dropItemEvent = AIFEntity.DropItemEvent(entity, event.itemDrop, event.isCancelled)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.dropItem(dropItemEvent)

        event.isCancelled = dropItemEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onPickupItem(event: EntityPickupItemEvent) {
        val entity = event.entity
        val pickupItemEvent = AIFEntity.PickupItemEvent(entity, event.item, event.remaining, event.isCancelled)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.pickupItem(pickupItemEvent)

        event.isCancelled = pickupItemEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onChangeAir(event: EntityAirChangeEvent) {
        val entity = event.entity
        val airChangeEvent = AIFEntity.ChangeAirEvent(entity, event.amount, event.isCancelled)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.changeAir(airChangeEvent)

        event.amount = airChangeEvent.amount
        event.isCancelled = airChangeEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onTransform(event: EntityTransformEvent) {
        val entity = event.entity
        val transformEvent = AIFEntity.TransformEvent(entity, event.transformedEntities, event.transformReason, event.isCancelled)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.transform(transformEvent)

        event.isCancelled = transformEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onFromBlock(event: EntityBlockFormEvent) {
        val entity = event.entity
        val formBlockEvent = AIFEntity.FormBlockEvent(entity, event.block, event.newState, event.isCancelled)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.formBlock(formBlockEvent)

        event.isCancelled = formBlockEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL)
    fun onSpawn(event: EntitySpawnEvent) {
        val entity = event.entity
        val spawnEvent = AIFEntity.SpawnEvent(entity)
        AIFEntityHelper.getAIFEntityFromBukkitEntity(entity)?.spawn(spawnEvent)
    }

}