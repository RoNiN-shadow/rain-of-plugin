package org.plugins.bearsPlugin.events;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerRespawnEvent;



public class BearFallEvent implements Listener{
    @EventHandler
    public void onBearFall(EntityDamageEvent event){
        if(event.getEntity() instanceof PolarBear && event.getCause() == EntityDamageEvent.DamageCause.FALL){
           event.setDamage(0);
        }
    }
    @EventHandler
    public void onPlayerSpawn(PlayerRespawnEvent event){

        Player player = (Player) event.getPlayer();
        int radius = 200;
        for(Entity entity : player.getLocation().getNearbyEntities(radius, raduis, radius)){
            if(entity instanceof PolarBear bear){
                bear.setTarget(player);
            }
        }
    }
}
