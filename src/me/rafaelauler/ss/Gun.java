package me.rafaelauler.ss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import net.helix.core.util.HelixCooldown;
import net.md_5.bungee.api.ChatColor;

public class Gun implements Listener
{
    public static HashMap<Player, Integer> guntiros;
    
    static {
        Gun.guntiros = new HashMap<Player, Integer>();
    }
    
    @EventHandler
    public void ar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        try {
        if (p.getItemInHand().getType() == Material.WOOD_HOE && (p.getItemInHand().getType() == Material.WOOD_HOE) && (p.getItemInHand().hasItemMeta())) {
        	if (p.getItemInHand().getItemMeta().getDisplayName().equals("§eAK-47"))
            e.setCancelled(true);
          	 if (isInRegion(p) || p.getWorld().equals(Bukkit.getWorld("spawn"))) {
              	p.sendMessage(ChatColor.RED + "Você está em uma area protegida");
              	e.setCancelled(true);
              	return;
              }
            if (Gun.guntiros.containsKey(p) && Gun.guntiros.get(p) == 2) {
     
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)BukkitMain.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Gun.guntiros.remove(p);
                        p.sendMessage("§cVoce ja pode atirar novamente");
                    }
                }, 400L);
            }
            if (Gun.guntiros.containsKey(p) && Gun.guntiros.get(p) == 3) {
                if (HelixCooldown.has(p.getName(), "gun")) {
                	 p.sendMessage("§bVoc\u00ea est\u00e1 em cooldown de: §5" + HelixCooldown.getTime(p.getName(), "gun") + "§b segundos");
                    return;
                }
                HelixCooldown.create(p.getName(), "gun", TimeUnit.SECONDS, 15);
            }
            else if (!Gun.guntiros.containsKey(p)) {
                Gun.guntiros.put(p, 1);
            }
            else {
                Gun.guntiros.put(p, Gun.guntiros.get(p) + 1);
            }
            Location loc = p.getLocation().add(0.0, 1.5, 0.0);
            for (int i = 0; i <= 240; ++i) {
                loc = loc.add(loc.getDirection().getX(), loc.getDirection().getY() - 0.05, loc.getDirection().getZ());
                p.getWorld().playEffect(loc, Effect.COLOURED_DUST, 15);
                for (final Entity ent : this.getEntitiesByLocation(loc, 1.0f)) {
                    if (ent instanceof LivingEntity && ent != p) {
                    	if (ent instanceof Player) {
                    if (isInRegion((Player)ent)) {
                    	p.sendMessage(ChatColor.RED + "Esse jogador está em uma area protegida");
                    	e.setCancelled(true);
                    	return;
                    }
                    	}
                        ((LivingEntity)ent).damage(7.0);
                    }
                }
                if (loc.getBlock().getType().isSolid()) {
                    break;
                }
            }
            p.getLocation().getWorld().playSound(p.getLocation(), Sound.IRONGOLEM_HIT, 2.0f, 2.0f);
        }
        }
        catch (NullPointerException e2) {
        p.sendMessage("ESSA ARMA ESTÁ QUEBRADA! DESCULPE");
        return;
        }
       
    }
    public static boolean isInRegion(Player p) {
   	 if (Bukkit.getServer().getPluginManager().getPlugin("WorldGuard") != null){
   		    WorldGuardPlugin wg = (WorldGuardPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
               RegionManager regionManager = wg.getRegionManager(p.getWorld());
               ApplicableRegionSet set = regionManager.getApplicableRegions(p.getLocation());

               for (ProtectedRegion region2 : set) {
                   if (region2 != null){
                       if (!set.allows(DefaultFlag.PVP)) {
                      
                           return true;
                       }
                   }
                   }}
        return false;
               }
    
    private List<Entity> getEntitiesByLocation(final Location loc, final float r) {
        final List<Entity> ent = new ArrayList<Entity>();
        for (final Entity e : loc.getWorld().getEntities()) {
            if (e.getLocation().distanceSquared(loc) <= r) {
                ent.add(e);
            }
        }
        return ent;
    }
}
