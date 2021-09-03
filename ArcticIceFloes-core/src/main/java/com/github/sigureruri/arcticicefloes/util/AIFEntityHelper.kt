package com.github.sigureruri.arcticicefloes.util

import com.github.sigureruri.arcticicefloes.ArcticIceFloesApi
import com.github.sigureruri.arcticicefloes.entity.AIFEntity
import com.github.sigureruri.arcticicefloes.entity.AIFEntityId
import org.bukkit.NamespacedKey
import org.bukkit.entity.Entity
import org.bukkit.persistence.PersistentDataType

object AIFEntityHelper {

    fun getAIFEntityFromBukkitEntity(entity: Entity): AIFEntity? {
        val strId = entity.persistentDataContainer.get(
            NamespacedKey(
                ArcticIceFloesApi.plugin,
                "id"
            ),
            PersistentDataType.STRING
        ) ?: return null
        val id = try {
            AIFEntityId.of(strId)
        } catch (e: IllegalArgumentException) {
            return null
        }

        return ArcticIceFloesApi.entityRegistry.get(id)
    }

    fun isAIFEntity(entity: Entity) = getAIFEntityFromBukkitEntity(entity) != null

}