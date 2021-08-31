package com.github.sigureruri.arcticicefloes.util

import com.github.sigureruri.arcticicefloes.ArcticIceFloes
import com.github.sigureruri.arcticicefloes.entity.AIFEntity
import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import org.bukkit.NamespacedKey
import org.bukkit.entity.Entity
import org.bukkit.persistence.PersistentDataType

object AIFEntityHelper {

    fun getAIFEntityFromBukkitEntity(entity: Entity): AIFEntity? {
        val strId = entity.persistentDataContainer.get(
            NamespacedKey(
                ArcticIceFloes.plugin,
                "id"
            ),
            PersistentDataType.STRING
        ) ?: return null
        val id = try {
            ArcticIceFloesEntityId.of(strId)
        } catch (e: IllegalArgumentException) {
            return null
        }

        return ArcticIceFloes.entityRegistry.get(id)
    }

    fun isAIFEntity(entity: Entity) = getAIFEntityFromBukkitEntity(entity) != null

}