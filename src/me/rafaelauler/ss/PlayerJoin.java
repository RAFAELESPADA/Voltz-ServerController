package me.rafaelauler.ss;





import java.util.HashSet;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerJoin implements Listener {
	private final BukkitMain plugin;
    public static HashSet<Player> muggles = new HashSet<Player>();
	public PlayerJoin(BukkitMain plugin) {
		this.plugin = plugin;
	}	
	

	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();

				
		if (!player.hasPermission("*")) {
		player.setOp(false);
	}
		}}

		

