package com.pinecarp.lawyer.listeners;

import com.pinecarp.lawyer.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Sign;
import org.bukkit.block.TileState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class OnClick implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        if (action == Action.LEFT_CLICK_BLOCK || action == Action.RIGHT_CLICK_BLOCK) {

            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Lawyer")) {

                player.sendMessage("Lawyer!");
                if(!(event.getClickedBlock().getState() instanceof TileState))
                    return;

                TileState state = (TileState) event.getClickedBlock().getState();
                PersistentDataContainer container = state.getPersistentDataContainer();
                NamespacedKey key = new NamespacedKey(Main.getPlugin(Main.class), "private");

                container.set(key, PersistentDataType.STRING, event.getPlayer().getUniqueId().toString());
                state.update();
                event.getPlayer().sendMessage("Locked!");

            }



        }
    }
}
