package com.github.sigureruri.arcticicefloes.spawner

import org.bukkit.Location

class AIFSpawnerManager {

    private val spawnersList = mutableListOf<AIFSpawner>()


    fun add(spawner: AIFSpawner) {
        spawnersList.add(spawner)
    }

    fun remove(spawner: AIFSpawner) {
        spawnersList.remove(spawner)
    }

    fun removeNearby(location: Location, r: Double) {
        spawnersList.removeIf {
            it.location.distanceSquared(location) <= r
        }
    }


    fun getNearby(location: Location, r: Double): List<AIFSpawner> {
        return spawnersList.filter {
            it.location.distance(location) <= r
        }
    }

    fun getAll() = spawnersList.toList()

    fun contains(spawner: AIFSpawner) = spawnersList.contains(spawner)

    fun contains(location: Location) = spawnersList.any { it.location == location }

    fun clear() = spawnersList.clear()

    fun removeSpawnedEntities() {
        spawnersList.forEach { it.removeSpawnedEntities() }
    }

}