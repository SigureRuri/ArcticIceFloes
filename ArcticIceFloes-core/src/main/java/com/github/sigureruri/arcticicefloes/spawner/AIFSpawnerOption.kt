package com.github.sigureruri.arcticicefloes.spawner

import com.github.sigureruri.arcticicefloes.entity.AIFEntityId

data class AIFSpawnerOption(
    val entities: List<AIFEntityId> = emptyList(),
    val maxEntities: Int = 10,
    val requiredPlayerRange: Int = 10,
    val spawnDelay: SpawnDelay = SpawnDelay.Single(400),
    val spawnRange: Int = 4,
    val maxSpawnCount: Int = 1,
    val activationRange: Int = 50
) {

    sealed class SpawnDelay {
        abstract val value: Int

        class Single(override val value: Int) : SpawnDelay()
        class Ranged(private val value1: Int, private val value2: Int) : SpawnDelay() {
            override val value: Int
                get() = (value1..value2).random()
        }
    }

}