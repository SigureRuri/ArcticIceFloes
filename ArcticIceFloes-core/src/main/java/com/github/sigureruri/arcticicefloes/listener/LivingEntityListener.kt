package com.github.sigureruri.arcticicefloes.listener

import com.github.sigureruri.arcticicefloes.entity.living.AIFLivingEntity
import com.github.sigureruri.arcticicefloes.util.AIFEntityHelper
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityBreedEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.EntityShootBowEvent

class LivingEntityListener : Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onShootBow(event: EntityShootBowEvent) {
        val entity = event.entity
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFLivingEntity ?: return
        val shootBowEvent = AIFLivingEntity.ShootBowEvent(
            event.entity,
            event.consumable,
            event.bow,
            event.force,
            event.hand,
            event.projectile,
            event.shouldConsumeItem(),
            event.isCancelled
        )
        aifEntity.shootBow(shootBowEvent)

        event.projectile = shootBowEvent.projectile
        event.setConsumeItem(shootBowEvent.shouldConsumeItem)
        event.isCancelled = shootBowEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    fun onBreed(event: EntityBreedEvent) {
        val entity = event.entity
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFLivingEntity ?: return
        val breedEvent = AIFLivingEntity.BreedEvent(
            event.entity,
            event.mother,
            event.father,
            event.breeder,
            event.bredWith,
            event.experience,
            event.isCancelled
        )
        aifEntity.breed(breedEvent)

        event.experience = breedEvent.experience
        event.isCancelled = breedEvent.isCancelled
    }

    @EventHandler(priority = EventPriority.NORMAL)
    fun onDeath(event: EntityDeathEvent) {
        val entity = event.entity
        val aifEntity = AIFEntityHelper.getAIFEntityFromBukkitEntity(entity) as? AIFLivingEntity ?: return
        val deathEvent = AIFLivingEntity.DeathEvent(entity)
        aifEntity.death(deathEvent)
    }

}