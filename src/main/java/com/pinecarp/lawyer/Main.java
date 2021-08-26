package com.pinecarp.lawyer;

import com.pinecarp.lawyer.commands.AddLawyer;
import com.pinecarp.lawyer.commands.Help;
import com.pinecarp.lawyer.commands.Hunger;
import com.pinecarp.lawyer.listeners.OnClick;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        getCommand("lawyer").setExecutor(new AddLawyer());
        getCommand("hunger").setExecutor(new Hunger());
        getCommand("help").setExecutor(new Help());

        getServer().getPluginManager().registerEvents(new OnClick(), this);
    }


}
