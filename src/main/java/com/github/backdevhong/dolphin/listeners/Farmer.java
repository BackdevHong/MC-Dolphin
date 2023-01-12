package com.github.backdevhong.dolphin.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class Farmer implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.CROPS) {
            if (!(e.getBlock().getData() == 0x7)) {
                e.setCancelled(true);
            } else {
                e.setCancelled(true);
                e.getBlock().setData((byte) 0x7);
                Player p = e.getPlayer();
                ItemStack itemStack = new ItemStack(Material.WHEAT);
                ItemMeta meta = itemStack.getItemMeta();
                Random r = new Random();
                int myRandom = r.nextInt(1000);

                if (myRandom < 10) { // 1%
                    meta.setDisplayName("A급 밀");
                    e.getPlayer().sendMessage("A급이 나왔습니다!!");
                } else if (myRandom > 10 && myRandom < 50) { // 5%
                    meta.setDisplayName("B급 밀");
                } else if (myRandom > 50 && myRandom < 150) { // 10%
                    meta.setDisplayName("C급 밀");
                } else if (myRandom > 150 && myRandom < 350) { // 20%
                    meta.setDisplayName("D급 밀");
                } else {
                    meta.setDisplayName("E급 말");
                }
                itemStack.setItemMeta(meta);
                p.getInventory().addItem(itemStack);
            }
        } else if (e.getBlock().getType() == Material.SOIL) {
            e.setCancelled(true);
        }
//        e.getPlayer().sendMessage(String.valueOf(e.getBlock().getType()));
    }
}