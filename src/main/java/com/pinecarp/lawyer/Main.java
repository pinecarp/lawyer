package com.pinecarp.lawyer;

import com.pinecarp.lawyer.commands.AddLawyer;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        getCommand("lawyer").setExecutor(new AddLawyer());
    }


}
