package com.github.sigureruri.arcticicefloes.entity

class AIFEntityRegistry {

    private val map: MutableMap<AIFEntityId, AIFEntity> = mutableMapOf()

    fun register(item: AIFEntity) {
        if (contains(item.id)) throw IllegalArgumentException("The entity has already registered: ${item.id}")
        map[item.id] = item
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