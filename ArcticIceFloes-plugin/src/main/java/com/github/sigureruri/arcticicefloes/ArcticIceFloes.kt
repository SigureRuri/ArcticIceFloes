package com.github.sigureruri.arcticicefloes

import com.github.sigureruri.arcticicefloes.nms.Paper_v1_17_R1.Paper_NMS_v1_17_R1
import com.github.sigureruri.arcticicefloes.nms.Spigot_v1_17_R1.Spigot_NMS_v1_17_R1
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class ArcticIceFloes : JavaPlugin() {

    override fun onEnable() {
        try {
            val nms = when (val craftBukkitVersion = getCraftBukkitVersion()) {
                "v1_17_R1" -> {
                    if (isPaperServer()) {
                        Paper_NMS_v1_17_R1()
                    } else {
                        Spigot_NMS_v1_17_R1()
                    }
                }
                else -> {
                    logger.warning("$craftBukkitVersion is unsupported version!")
                    throw UnsupportedOperationException()
                }
            }

            ArcticIceFloesApi.enable(this, nms)
        } catch (e: Exception) {
            e.printStackTrace()
            Bukkit.getPluginManager().disablePlugin(this)
        }
    }

    private fun getCraftBukkitVersion() =
        Bukkit.getServer().javaClass.`package`.name.split('.')[3]

    private fun isPaperServer() =
        try {
            Class.forName("com.destroystokyo.paper.util.VersionFetcher")
            true
        } catch (e: Exception) {
            false
        }

}