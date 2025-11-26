package me.rafaelauler.ss;


import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class BungeeAPI {

	public static void send(Player player, String server) {
		try {
			ByteArrayDataOutput out = ByteStreams.newDataOutput();
			
			out.writeUTF("Connect");
			out.writeUTF(server);
		
			player.sendPluginMessage(BukkitMain.plugin, "BungeeCord", out.toByteArray());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

