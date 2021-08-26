package com.pinecarp.lawyer.listeners;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OnClick implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        if (action == Action.LEFT_CLICK_BLOCK || action == Action.RIGHT_CLICK_BLOCK) {

            if(player.getInventory().getItemInMainHand().getType().equals(Material.WOODEN_PICKAXE)) {

                if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Lawyer")){
                    player.sendMessage("debug");
                }
            }

        }
    }
}
