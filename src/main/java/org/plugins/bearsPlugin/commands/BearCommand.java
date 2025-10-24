package org.plugins.bearsPlugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class BearCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("this command is only for players");
            return true;
        }
        Player player = (Player) sender;
        Location location = player.getLocation().clone().add(player.getLocation().getDirection().multiply(2));
        player.getWorld().spawnEntity(location, EntityType.POLAR_BEAR);
        return true;
    }
}
