package com.github.sigureruri.arcticicefloes.entity

class ArcticIceFloesEntityRegistry {

    private val map: MutableMap<ArcticIceFloesEntityId, AIFEntity> = mutableMapOf()

    fun register(item: AIFEntity) {
        if (contains(item.id)) throw IllegalArgumentException("The entity has already registered: ${item.id}")
        map[item.id] = item
    }

    fun get(id: ArcticIceFloesEntityId) =
        map[id]

    fun getAll() =
        map.values.toList()

    fun contains(itemId: ArcticIceFloesEntityId) =
        map.contains(itemId)

    fun isEmpty(): Boolean =
        map.isEmpty()

}