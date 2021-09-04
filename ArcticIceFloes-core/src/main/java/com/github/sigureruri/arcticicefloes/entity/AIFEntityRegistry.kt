package com.github.sigureruri.arcticicefloes.entity

class AIFEntityRegistry {

    private val map: MutableMap<AIFEntityId, AIFEntity> = mutableMapOf()

    fun register(entity: AIFEntity) {
        if (contains(entity.id)) throw IllegalArgumentException("The entity has already registered: ${entity.id}")
        map[entity.id] = entity
    }

    fun get(id: AIFEntityId) =
        map[id]

    fun getAll() =
        map.values.toList()

    fun contains(itemId: AIFEntityId) =
        map.contains(itemId)

    fun isEmpty(): Boolean =
        map.isEmpty()

}