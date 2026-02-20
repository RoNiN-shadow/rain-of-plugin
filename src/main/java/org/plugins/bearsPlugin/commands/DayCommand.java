package org.plugins.bearsPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("only for players");
            return true;
        }

        int time = 1000;
        Player player = (Player) sender;
        player.getWorld().setTime(time);
        return true;
    }
}
