package com.megahdrive.ntools;

import com.megahdrive.ntools.Commands.Rules;
import com.megahdrive.ntools.Events.WelcomeMessage;
import org.bukkit.plugin.java.JavaPlugin;

public final class Ntools extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register commands
        this.getCommand("rules").setExecutor(new Rules());
        // Register event listeners
        getServer().getPluginManager().registerEvents(new WelcomeMessage(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
