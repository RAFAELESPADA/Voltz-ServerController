package me.rafaelauler.ss;



	import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import br.com.ystoreplugins.product.yarmazem.ArmazemAPIHolder;
import br.com.ystoreplugins.product.yspawnersv2.SpawnerV2APIHolder;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.event.EventBus;
import net.luckperms.api.event.node.NodeAddEvent;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;


	public class Eventos implements Listener {
	    private final BukkitMain plugin;
	    private final LuckPerms luckPerms;
	    public static Economy econ = null;
	    public static Permission perms = null;
	    public Eventos(BukkitMain plugin, LuckPerms luckPerms) {
	        this.plugin = plugin;
	        this.luckPerms = luckPerms;
	    }

	    public void register() {
	        EventBus eventBus = this.luckPerms.getEventBus();
	        eventBus.subscribe(this.plugin, NodeAddEvent.class, this::onNodeAdd);
	    }
	    
	    public void Atirar2(Player p) {
	    	final Location loc = p.getEyeLocation();

	        final Vector sponge = p.getLocation().getDirection().multiply(3.8).setY(0.45);
	    	Block block = p.getLocation().getBlock().getRelative(0, -1, 0);
	    	if (Bukkit.getPluginManager().getPlugin("LeafMito") == null) {
	    	if (block.getType() == Material.SLIME_BLOCK && p.getWorld() == Bukkit.getWorld("spawn")) {
	    		p.setVelocity(sponge);
	    	    p.playEffect(loc, Effect.MOBSPAWNER_FLAMES, (Object)null);
	    	}
	    	}
	    	}
	    @EventHandler
			public void onJoivn(WeatherChangeEvent e) {
		    /*     */   
	    	if (Bukkit.getPluginManager().getPlugin("LeafMito") == null) {
		    e.setCancelled(e.toWeatherState());
		}
	    }
	    @EventHandler
		public void onJoivn(PlayerMoveEvent e) {
	    /*     */   
	    
	Atirar2(e.getPlayer());
	}
	    @EventHandler
		public void onJoin(PlayerLoginEvent e) {
			Player player = e.getPlayer();
			if (!player.hasPermission("manutencao.bypass") && !Manutencao.istoggled) {
			e.disallow(Result.KICK_OTHER, ChatColor.RED + "Esse servidor está em manutenção.");
		}
		}
	    public static boolean setupEconomy() {
	        if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
	            return false;
	        }
	        RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
	        if (rsp == null) {
	            return false;
	        }
	        econ = rsp.getProvider();
	        return econ != null;
	    }
	    public static boolean setupPermissions() {
	  	  if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
	            return false;
	        }
	        RegisteredServiceProvider<Permission> rsp = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
	        perms = rsp.getProvider();
	        return perms != null;
	    }
	    @EventHandler
		public void onJoin(EntityDeathEvent e) {
	    	if (e.getEntity().getKiller() instanceof Player) {
			Player player = e.getEntity().getKiller();
			if (player.getWorld().equals(Bukkit.getWorld("plots"))) {
			if (BukkitMain.getEspadasAPI().isFarmSword(player.getItemInHand())) {
				econ.depositPlayer(player, 7 * BukkitMain.getEspadasAPI().getLootingLevel(player.getItemInHand()));	
				player.sendMessage(ChatColor.RED + "Você ganhou dinheiro extra por matar esse mob com espada de farm");
			}
			}
	    	}
		}
		
	    @EventHandler    
	    public void onNodggg(BlockBreakEvent e) {

	    	if (Bukkit.getPluginManager().getPlugin("LeafMito") != null) {
	    	if (!(e.getBlock().getType().toString().contains("_ORE") || e.getBlock().getType().toString().contains("STONE"))) {	
	    	
	    	return;
	    	}
	    	if (!(e.getPlayer().getWorld().equals(Bukkit.getWorld("mina")) || e.getPlayer().getWorld().equals(Bukkit.getWorld("mina1")) || e.getPlayer().getWorld().equals(Bukkit.getWorld("mina2")) || e.getPlayer().getWorld().equals(Bukkit.getWorld("minasuperioe")) || e.getPlayer().getWorld().equals(Bukkit.getWorld("mina3")) || e.getPlayer().getWorld().equals(Bukkit.getWorld("mina4")) || e.getPlayer().getWorld().equals(Bukkit.getWorld("minavip")) || e.getPlayer().getWorld().equals(Bukkit.getWorld("minapvp")))) {	
	    		return;
	    		}
	    /*  46 */         Random rand = new Random();
	    /*  47 */         int percent = rand.nextInt(100);

	    /*  47 */         float percent2 = rand.nextFloat(100);
	    /*  48 */         if (percent <= 22) {
	    		BukkitMain.getRankupAPI().addFragmentos(e.getPlayer(), 2);	  
	    		e.getPlayer().sendMessage(ChatColor.YELLOW + "Você recebeu alguns fragmentos minerando.");
	    }
	    /*  48 */         if (percent <= 1) {
	    	BukkitMain.getRankupAPI().addFragmentos(e.getPlayer(), 15);	  
	    	e.getPlayer().sendMessage(ChatColor.YELLOW + "Você recebeu muitos fragmentos minerando.");
	    }

	    /*  48 */         if (percent2 <= 0.01) {
	    		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "bomb give bomb-small " + e.getPlayer().getName() + " 1");
	    		e.getPlayer().sendMessage(ChatColor.YELLOW + "Você recebeu uma bomba");
	    }
	    /*  48 */         if (percent2 <= 0.001) {
	    	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pontos add " + e.getPlayer().getName() + " 10");
	    	e.getPlayer().sendMessage(ChatColor.BLUE + "Você recebeu 10 de cash na mina");
	    }
	    /*  48 */         if (percent2 <= 0.0001) {
	    	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "bomb give bomb-medium " + e.getPlayer().getName() + " 1");
	    	e.getPlayer().sendMessage(ChatColor.YELLOW + "Você recebeu uma bomba média");
	    }
	    /*  48 */         if (percent2 <= 0.00000001) {
	    	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "bomb give bomb-large " + e.getPlayer().getName() + " 1");
	    	e.getPlayer().sendMessage(ChatColor.YELLOW + "Você recebeu uma bomba larga");
	    	}
	    	}
	    }
	    public static ArmazemAPIHolder getArmazemAPI() {
	    	  try {
	    	      RegisteredServiceProvider<ArmazemAPIHolder> rsp = Bukkit.getServer().getServicesManager()
	    	          .getRegistration(ArmazemAPIHolder.class);
	    	      return rsp == null ? null : rsp.getProvider();
	    	  } catch (Throwable var1) {
	    	      return null;
	    	  }
	    	}
	    public static SpawnerV2APIHolder getSPAPI() {
	    	  try {
	    	      RegisteredServiceProvider<SpawnerV2APIHolder> rsp = Bukkit.getServer().getServicesManager()
	    	          .getRegistration(SpawnerV2APIHolder.class);
	    	      return rsp == null ? null : rsp.getProvider();
	    	  } catch (Throwable var1) {
	    	      return null;
	    	  }
	    	}
	    @EventHandler
		public void otnShot(EntityDamageByEntityEvent e) {
			
				
				if (e.getEntity() instanceof Player && e.getDamager() instanceof Arrow) {
					
					Player damagedPlayer = (Player) e.getEntity();
					Arrow arrow = (Arrow) e.getDamager();
					if (arrow.getShooter() != null && arrow.getShooter() instanceof Player) {

						Player shooter = (Player) arrow.getShooter();
						
						// ARROW HEALTH MESSAGE
						
						if (damagedPlayer.getName() != shooter.getName()) {
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									
									double health = Math.round(damagedPlayer.getHealth() * 10.0) / 10.0;
									
										if (health != 20.0) {	
											
											shooter.sendMessage(damagedPlayer.getName() + ChatColor.YELLOW + " está com " + health + " corações de vida!");									
										}						
																	}							
								}
								
							.runTaskLater(BukkitMain.plugin, 2L);
							
						}
					}
				}
			}
	    

	    


	    

    public void onNodeAdd(NodeAddEvent e) {
        // Check if the event was acting on a User
        if (!e.isUser()) {
            return;
        }

        // Check if the node was a permission node
        Node node = e.getNode();
        if (node.getType() != NodeType.PERMISSION) {
            return;
        }

        net.luckperms.api.model.user.User user = (net.luckperms.api.model.user.User) e.getTarget();
        
          if (node.getKey() == "*")  {
        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban " + user.getUsername() + " Conseguiu OP (*) sem autorização (Automatico)");
          }}
    }
