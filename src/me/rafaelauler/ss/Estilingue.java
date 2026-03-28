package me.rafaelauler.ss;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;



public class Estilingue implements Listener {


ArrayList<Player> kangaroo = new ArrayList();
ArrayList<Player> cos = new ArrayList();
private HashMap<Player, Integer> jumped = new HashMap();

@EventHandler
public void interact(PlayerInteractEvent event) {
	Player p = event.getPlayer();
    if (p.getItemInHand().getType() == Material.MAGMA_CREAM && (p.getItemInHand().hasItemMeta())) {
    	if (p.getItemInHand().getItemMeta().getDisplayName().equals("§eEstilingue"))
		event.setCancelled(true);
    	if (Bukkit.getPluginManager().getPlugin("BedWars1058") == null) {
    		return;
    	}
    	else if ((!this.cos.contains(p)) && (!this.jumped.containsKey(p))) {
			if (!p.isSneaking()) {
				if (!(p.isOnGround())) {
					this.jumped.put(p, Integer.valueOf(1));

/*  76 */       p.setVelocity(p.getEyeLocation().getDirection().multiply(2).add(new Vector(0, 1.5, 0)));
p.getInventory().remove(p.getItemInHand());
				} else {     p.setVelocity(p.getEyeLocation().getDirection().multiply(2).add(new Vector(0, 1.5, 0)));
				p.getInventory().remove(p.getItemInHand());
				}
			} else if (!(p.isOnGround())) {     p.setVelocity(p.getEyeLocation().getDirection().multiply(2).add(new Vector(0, 1.5, 0)));
			p.getInventory().remove(p.getItemInHand());
				this.jumped.put(p, Integer.valueOf(1));
			} else {     p.setVelocity(p.getEyeLocation().getDirection().multiply(2).add(new Vector(0, 1.5, 0)));
			for (ItemStack item : p.getInventory().getContents()) {
		          if (item != null && item.getType() == Material.MAGMA_CREAM) {
		              // Found the item, now remove one from its stack
		              if (item.getAmount() > 1) {
		                  item.setAmount(item.getAmount() - 1);
		              } else {
		                  // If only one item in the stack, set the slot to null
		            	  p.getInventory().removeItem(item); // Or set the specific slot to null if you know the index
		              }
		              p.updateInventory(); // Update the player's client-side inventory
		              break; // Stop after removing one
		          }
		      
		}
			}}}
}

@EventHandler
public void landed(PlayerMoveEvent e) {
	if ((e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR)
			&& (this.jumped.containsKey(e.getPlayer()))) {
		this.jumped.remove(e.getPlayer());
	}
}
@EventHandler
public void onDamag123e(BlockBurnEvent event) {
	
	if (Bukkit.getPluginManager().getPlugin("BedWars1058") == null) {
    		return;
    	}
	
}
@EventHandler
public void onDamag123e(EntityDamageEvent event) {
	Entity e = event.getEntity();
	if ((e instanceof Player)) {
		Player player = (Player) e;
		if (Bukkit.getPluginManager().getPlugin("BedWars1058") == null) {
    		return;
    	}
			  if (player.getItemInHand().getType() == Material.MAGMA_CREAM && (player.getItemInHand().hasItemMeta())){
			event.setDamage(4.0D);
		}
	}
		}


public boolean isOnGround(Player p) {
	Location l = p.getLocation();
	l = l.add(0.0D, -1.0D, 0.0D);
	return l.getBlock().getState().getTypeId() != 0;
}

@EventHandler
public void Cooldown(EntityDamageByEntityEvent e) {
	if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
		final Player player = (Player) e.getEntity();
		if (player.getItemInHand().getType() == Material.MAGMA_CREAM && player.getItemInHand().hasItemMeta()) {
	    	if (player.getItemInHand().getItemMeta().getDisplayName().equals("§eEstilingue")) {
	    		if (Bukkit.getPluginManager().getPlugin("BedWars1058") == null) {
	        		return;
	        	}
			this.cos.add(player);

			Bukkit.getServer().getScheduler().runTaskLater((Plugin) Main.instance, new Runnable() {
				public void run() {
					cos.remove(player);
				}
			}, 150L);
		}
	}
}
}
}