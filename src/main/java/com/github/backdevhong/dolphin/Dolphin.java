package com.github.backdevhong.dolphin;

import com.github.backdevhong.dolphin.listeners.Farmer;
import org.bukkit.plugin.java.JavaPlugin;

public final class Dolphin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin Loaded!");
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Plugin Disabled");
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new Farmer(), this);
    }
}
