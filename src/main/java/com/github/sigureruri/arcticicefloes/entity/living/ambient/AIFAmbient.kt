package com.github.sigureruri.arcticicefloes.entity.living.ambient

import com.github.sigureruri.arcticicefloes.entity.ArcticIceFloesEntityId
import com.github.sigureruri.arcticicefloes.entity.living.AIFMob
import org.bukkit.entity.Ambient
import org.bukkit.entity.EntityType

abstract class AIFAmbient(
    id: ArcticIceFloesEntityId,
    entityType: EntityType
) : AIFMob(id, entityType) {

    init {
        if (entityType.entityClass == null || !Ambient::class.java.isAssignableFrom(entityType.entityClass!!)) {
            throw IllegalArgumentException("entityType must be a type of Ambient")
        }
    }

}