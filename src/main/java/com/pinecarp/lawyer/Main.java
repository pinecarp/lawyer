package com.pinecarp.lawyer;

import com.pinecarp.lawyer.commands.AddLawyer;
import com.pinecarp.lawyer.commands.Help;

import com.pinecarp.lawyer.listeners.OnClick;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable(){

        PluginManager pm = getServer().getPluginManager();

        getCommand("lawyer").setExecutor(new AddLawyer());
        getCommand("help").setExecutor(new Help());

        pm.registerEvents(new OnClick(), this);
    }


}
