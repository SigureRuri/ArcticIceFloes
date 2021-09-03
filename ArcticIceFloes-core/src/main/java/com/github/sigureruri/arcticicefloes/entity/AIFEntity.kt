package com.github.sigureruri.arcticicefloes.entity

import com.github.sigureruri.arcticicefloes.ArcticIceFloesApi
import org.bukkit.Location
import org.bukkit.NamespacedKey
import org.bukkit.block.Block
import org.bukkit.block.BlockState
import org.bukkit.entity.Entity
import org.bukkit.entity.Item
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityRegainHealthEvent
import org.bukkit.event.entity.EntityTransformEvent
import org.bukkit.persistence.PersistentDataType

abstract class AIFEntity(val id: AIFEntityId) {

    open val name: String? = null

    open val nameVisible = false

    open val isSilent = false

    open val hasGravity = true

    open val isInvulnerable = false

    open val isGlowing = false

    open val isVisualFire = false

    open val scoreboardTags: Set<String> = emptySet()


    open fun tick(event: TickEvent) {}

    open fun attack(event: AttackEvent) {}

    open fun hurt(event: HurtEvent) {}

    open fun regainHealth(event: RegainHealthEvent) {}

    open fun clicked(event: ClickedEvent) {}

    open fun teleportByPortal(event: TeleportByPortalEvent) {}

    open fun interactBlock(event: InteractBlockEvent) {}

    open fun dropItem(event: DropItemEvent) {}

    open fun pickupItem(event: PickupItemEvent) {}

    open fun changeAir(event: ChangeAirEvent) {}

    open fun transform(event: TransformEvent) {}

    open fun formBlock(event: FormBlockEvent) {}

    open fun spawn(event: SpawnEvent) {}


    abstract fun spawnBaseEntity(location: Location): Entity?

    protected open fun applyEntity(entity: Entity) {
        entity.customName = name
        entity.isCustomNameVisible = nameVisible
        entity.isSilent = isSilent
        entity.setGravity(hasGravity)
        entity.isInvulnerable = isInvulnerable
        entity.isGlowing = isGlowing
        entity.isVisualFire = isVisualFire
        scoreboardTags.forEach { entity.addScoreboardTag(it) }
    }

    fun spawn(location: Location): Boolean {
        val entity = spawnBaseEntity(location)?.apply {
            applyEntity(this)

            persistentDataContainer.set(
                NamespacedKey(ArcticIceFloesApi.plugin, "id"),
                PersistentDataType.STRING,
                id.toString()
            )
        }
        return entity != null
    }


    data class TickEvent(val entity: Entity)

    data class AttackEvent(
        val entity: Entity,
        val victim: Entity,
        var damage: Double,
        var isCancelled: Boolean
    )

    data class HurtEvent(
        val entity: Entity,
        var damage: Double,
        val cause: EntityDamageEvent.DamageCause,
        val damagerEntity: Entity?,
        val damagerBlock: Block?,
        var isCancelled: Boolean
    )

    data class RegainHealthEvent(
        val entity: Entity,
        var amount: Double,
        val reason: EntityRegainHealthEvent.RegainReason,
        var isCancelled: Boolean
    )

    data class ClickedEvent(
        val entity: Entity,
        val player: Player,
        var isCancelled: Boolean
    )

    data class TeleportByPortalEvent(
        val entity: Entity,
        var from: Location,
        var to: Location?,
        var searchRadius: Int,
        var isCancelled: Boolean
    )

    data class InteractBlockEvent(
        val entity: Entity,
        val block: Block,
        var isCancelled: Boolean
    )

    data class DropItemEvent(
        val entity: Entity,
        val item: Item,
        var isCancelled: Boolean
    )

    data class PickupItemEvent(
        val entity: Entity,
        val item: Item,
        val remaining: Int,
        var isCancelled: Boolean
    )

    data class ChangeAirEvent(
        val entity: Entity,
        var amount: Int,
        var isCancelled: Boolean
    )

    data class TransformEvent(
        val entity: Entity,
        val transformedEntities: List<Entity>,
        val reason: EntityTransformEvent.TransformReason,
        var isCancelled: Boolean
    )

    data class FormBlockEvent(
        val entity: Entity,
        val block: Block,
        val blockState: BlockState,
        var isCancelled: Boolean
    )

    data class SpawnEvent(val entity: Entity)

}