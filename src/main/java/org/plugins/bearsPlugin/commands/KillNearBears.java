package org.plugins.bearsPlugin.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class KillNearBears implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("You must be a player");
        }
        Player player = (Player) sender;
        Location location = player.getLocation();
        World world = player.getWorld();
        for(Entity entity : world.getNearbyEntities(location, 600, 600, 600)){
            if(entity.getType() == EntityType.POLAR_BEAR){
                entity.remove();
            }
        }
        return true;
    }
}
