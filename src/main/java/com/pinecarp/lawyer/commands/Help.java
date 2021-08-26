package com.pinecarp.lawyer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Help implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Sorry, console, you're not allowed to execute commands");
            return true;
        }
        Player player = (Player) sender;
        if(args.length != 0) {

            if (args[0].equalsIgnoreCase("lawyer")) {
                player.sendMessage("Lawyer Help");
            }
        }
        else {
            player.sendMessage("Argument missing!");
        }
        return false;
    }
}
