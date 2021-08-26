package com.pinecarp.lawyer.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class AddLawyer implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("Sorry, console, you're not allowed to execute commands");
            return true;
        }
        Player p = (Player) sender;

        if(p.getInventory().firstEmpty() == -1){
            Location location = p.getLocation();
            World world = p.getWorld();

            world.dropItemNaturally(location, getItem());
            p.sendMessage("Look Around");
            return true;
        }
        p.getInventory().addItem(getItem());
        p.sendMessage(ChatColor.AQUA + "Check a Lawyer in your " + ChatColor.BOLD + "Inventory");



        return false;
    }





    public ItemStack getItem() {

        ItemStack pickaxe = new ItemStack(Material.WOODEN_PICKAXE);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Lawyer");

        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("Click on the block to lock it");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);

        pickaxe.setItemMeta(meta);

        return pickaxe;
    }




}
