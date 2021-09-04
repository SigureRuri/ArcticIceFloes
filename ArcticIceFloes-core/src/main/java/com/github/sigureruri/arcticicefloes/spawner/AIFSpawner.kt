package com.github.sigureruri.arcticicefloes.spawner

import com.github.sigureruri.arcticicefloes.ArcticIceFloesApi
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Entity
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.random.Random

data class AIFSpawner(
    val location: Location,
    val options: AIFSpawnerOption
) {

    private var spawnDelay: Int = 0
        set(value) {
            field = max(value, 0)
        }

    private val aifEntities by lazy { options.entities.mapNotNull { ArcticIceFloesApi.entityRegistry.get(it) } }

    private val spawnedEntities = mutableListOf<Entity>()

    fun tick() {
        spawnDelay--

        if (canSpawnEntities()) {
            spawnEntities()
        }

        updateSpawnedEntities()
        spawnedEntities.forEach {
            if (location.distanceSquared(it.location) >= options.activationRange.toDouble().pow(2)) {
                it.teleport(location)
            }
        }
    }

    fun removeSpawnedEntities() {
        updateSpawnedEntities()
        spawnedEntities.forEach { it.remove() }
    }

    private fun canSpawnEntities(): Boolean {
        if (aifEntities.isEmpty()) return false

        if (Bukkit.getOnlinePlayers().isEmpty()) return false

        if (spawnDelay > 0) return false

        val isTherePlayerNearby = Bukkit.getOnlinePlayers().any { location.distanceSquared(it.location) <= options.requiredPlayerRange.toDouble().pow(2) }
        if (!isTherePlayerNearby) return false

        updateSpawnedEntities()
        if (spawnedEntities.size >= options.maxEntities) return false

        return true
    }

    private fun spawnEntities() {
        if (aifEntities.isEmpty()) return

        updateSpawnedEntities()

        repeat(min(options.maxSpawnCount, max(options.maxEntities - spawnedEntities.size, 0))) {
            val aifEntity = aifEntities.random()
            val entityX = location.x + (Random.nextDouble() - Random.nextDouble()) * options.spawnRange.toDouble() + 0.5
            val entityY = location.y + Random.nextInt(3) - 1
            val entityZ = location.z + (Random.nextDouble() - Random.nextDouble()) * options.spawnRange.toDouble() + 0.5
            val entityLocation = Location(location.world, entityX, entityY, entityZ, Random.nextFloat() * 360.0f, 0.0f)

            if (entityLocation.block.isPassable) {
                aifEntity.spawn(entityLocation)?.apply {
                    spawnedEntities.add(this)
                }
            }
        }

        spawnDelay = options.spawnDelay.value
    }

    private fun updateSpawnedEntities() {
        spawnedEntities.removeIf { !it.isValid || it.isDead }
    }

}