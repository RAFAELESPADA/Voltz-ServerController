package me.rafaelauler.ss;





import java.util.HashSet;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import me.RockinChaos.itemjoin.api.ItemJoinAPI;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;


public class PlayerJoin implements Listener {
	private final BukkitMain plugin;
    public static HashSet<Player> muggles = new HashSet<Player>();
	public PlayerJoin(BukkitMain plugin) {
		this.plugin = plugin;
	}	
	

	  LuckPerms api2 = LuckPermsProvider.get();
		@EventHandler
		public void onJoin(PlayerQuitEvent e) {
				if (Bukkit.getPluginManager().getPlugin("ItemJoin") != null) {
					e.setQuitMessage(null);
				}
		}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();

			if (Bukkit.getPluginManager().getPlugin("ItemJoin") != null) {
	    		e.setJoinMessage(null);
	    		if (player.hasPermission("join.lobby")) {
	    			throwRandomFirework(player);
	    			World w = Bukkit.getWorld("spawn");
	    			for (Player p : w.getPlayers()) {
	    				p.sendMessage(api2.getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getPrefix().replace("&", "§") + player.getName() + " §eentrou nesse lobby!");
	    				
	    			}
	    		}
	    		
	    		player.setMaxHealth(20);    new BukkitRunnable() {
	                
	                public void run() {
	                    player.getInventory().clear();
	            }}.runTaskLater(BukkitMain.plugin, 10l);
	                
	            ItemJoinAPI itemAPI = new ItemJoinAPI();
	new BukkitRunnable() {
	                
	                public void run() {
	                	Location l = new Location(Bukkit.getWorld("spawn"), 147.175, 68.000, -121.495);
	            		l.setPitch((float)5.6);
	            		l.setYaw((float)90.0);
	        	    		player.teleport(l);
	        	    		Bukkit.getConsoleSender().sendMessage("Enviando " + player.getName() + " ao lobby do servidor!");
	        	    		player.sendMessage(ChatColor.AQUA + "Bem vindo ao SkyzerMC!");
	        	    		player.sendMessage(ChatColor.AQUA + "Nosso Discord: " + ChatColor.WHITE + "https://discord.gg/PN9xfpf6FG");
	                   itemAPI.getItems(player);
	            }}.runTaskLater(BukkitMain.plugin, 25l);
new BukkitRunnable() {
	                
	                public void run() {
	                	Bukkit.getConsoleSender().sendMessage("Re-Enviando " + player.getName() + " ao lobby do servidor!");
        	    		
	                	Location l = new Location(Bukkit.getWorld("spawn"), 147.175, 68.000, -121.495);
	            		l.setPitch((float)5.6);
	            		l.setYaw((float)90.0);
	        	    		player.teleport(l);
	            }}.runTaskLater(BukkitMain.plugin, 35l);
	    	}
			

			
		if (!player.hasPermission("*")) {
		player.setOp(false);
	}
		}

public static void throwRandomFirework(Player p) {
    Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
    FireworkMeta fwm = fw.getFireworkMeta();

    //Our random generator
    Random r = new Random();

    //Get the type
    int rt = r.nextInt(5) + 1;
    FireworkEffect.Type type = FireworkEffect.Type.BALL;
    if (rt == 2) type = FireworkEffect.Type.BALL_LARGE;
    if (rt == 3) type = FireworkEffect.Type.BURST;
    if (rt == 4) type = FireworkEffect.Type.CREEPER;
    if (rt == 5) type = FireworkEffect.Type.STAR;

    //Get our random colours
    int r1i = r.nextInt(17) + 1;
    int r2i = r.nextInt(17) + 1;
    Color c1 = Color.fromRGB(r1i);
    Color c2 = Color.fromRGB(r2i);
    FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();

    //Then apply the effect to the meta
    fwm.addEffect(effect);

    //Generate some random power and set it


    //Create our effect with this   int rp = r.nextInt(2) + 1;
    int rp = r.nextInt(2) + 1;
    fwm.setPower(rp);

    //Then apply this to our rocket
    fw.setFireworkMeta(fwm);
}
}

