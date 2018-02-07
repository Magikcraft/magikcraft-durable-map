package io.magikcraft

import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class DurableMap() : JavaPlugin() {

    private val durableMap: MutableMap<String, MutableMap<String, Any>> = mutableMapOf()

    /**
     * This is a singleton, but we have to use a Kotlin class because it is managed by Bukkit.
     * So we use a companion object to enforce the singleton pattern.
     */
    companion object {
        var instance: DurableMap? = null
            private set
    }

    override fun onEnable() {
        instance = this
        logger.info("Magikcraft Durable Map Provider (c) 2018 www.magikcraft.io")

    }

    /**
     * getDurableMap
     *   This is a public method for JS code to get a DurableMap reference
     */
    @Suppress("unused")
    fun getDurableMap(name: String): MutableMap<String, Any> {
        if (!durableMap.containsKey(name)) {
            durableMap[name] = mutableMapOf()
        }
        return durableMap[name]!!
    }
}