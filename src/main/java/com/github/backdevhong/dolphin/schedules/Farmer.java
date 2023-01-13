package com.github.backdevhong.dolphin.schedules;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.managers.RegionManager;
import org.bukkit.Bukkit;

public class Farmer implements Runnable{
    private RegionManager rgm = null;
    @Override
    public void run() {
        rgm = WorldGuardPlugin.inst().getRegionManager(Bukkit.getWorld(""));
    }
}
