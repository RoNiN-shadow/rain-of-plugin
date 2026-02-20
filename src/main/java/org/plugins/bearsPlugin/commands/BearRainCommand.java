package org.plugins.bearsPlugin.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.PolarBear;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BearRainCommand implements CommandExecutor {
    private final JavaPlugin plugin;
    public BearRainCommand(JavaPlugin plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("only for p");
            return true;
        }
        Player player = (Player) sender;
        World world = player.getWorld();
        List<PolarBear> bears  = new ArrayList<>();
        Random random = new Random();

        int radius = 50;
        int durationEffect = 20*15;
        int amplifier = 0;
        String bearName = "ye yo";
        String messagePlayer = "Bear operation";

        for(int i=-radius; i<0;i++){
            for(int j=-radius;j<0;j++){
                if (random.nextBoolean()){
                    Location location = player.getLocation().clone().add(i,radius, j);
                    PolarBear bear = (PolarBear) world.spawnEntity(location, EntityType.POLAR_BEAR);
                    bear.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, durationEffect, amplifier));
                    bear.setCustomName(bearName);
                    bear.setCustomNameVisible(true);
                    bears.add(bear);
                    bear.setTarget(player);
                }
            }
        }
        player.sendMessage(messagePlayer);

        return true;
    }
}
