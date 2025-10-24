package org.plugins.bearsPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.plugins.bearsPlugin.commands.BearCommand;
import org.plugins.bearsPlugin.commands.BearRainCommand;
import org.plugins.bearsPlugin.commands.DayCommand;
import org.plugins.bearsPlugin.commands.BearRainCommand.BearFallDamageHandler;
import org.plugins.bearsPlugin.commands.KillNearBears;

public final class BearsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("bear").setExecutor(new BearCommand());
        this.getCommand("day").setExecutor(new DayCommand());
        this.getCommand("bearrain").setExecutor(new BearRainCommand(this));
        this.getCommand("killbears").setExecutor(new KillNearBears());
        getServer().getPluginManager().registerEvents(new BearFallDamageHandler(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
