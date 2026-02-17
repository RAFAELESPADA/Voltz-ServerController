package me.rafaelauler.ss;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RockinChaos.itemjoin.api.ItemJoinAPI;
import net.luckperms.api.LuckPerms;
import net.md_5.bungee.api.ChatColor;

public class Lobby implements CommandExecutor {
    private final BukkitMain plugin;
    private final LuckPerms luckPerms;

    public Lobby(BukkitMain plugin, LuckPerms luckPerms) {
        this.plugin = plugin;
        this.luckPerms = luckPerms;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    	Player p = (Player)sender;
    	if (Bukkit.getPluginManager().getPlugin("KP-PVP") != null) {
    	if (Join.game.contains(p.getName())) {
    		p.performCommand("kp leave");
    		Location l = new Location(Bukkit.getWorld("spawn"), 147.175, 68.000, -121.495);
    		l.setPitch((float)5.6);
    		l.setYaw((float)90.0);
            new BukkitRunnable() {
                
                public void run() {
                    p.getInventory().clear();
            }}.runTaskLater(BukkitMain.plugin, 10l);
                
            ItemJoinAPI itemAPI = new ItemJoinAPI();
new BukkitRunnable() {
                
                public void run() {
                   itemAPI.getItems(p);
            }}.runTaskLater(BukkitMain.plugin, 25l);
    		p.teleport(l);
    	}
    	}
    	if (p.getWorld().equals(Bukkit.getWorld("spawnbw")) || p.getWorld().equals(Bukkit.getWorld("duels")) || p.getWorld().equals(Bukkit.getWorld("wool")) || p.getWorld().equals(Bukkit.getWorld("wool2"))) {
    		Location l = new Location(Bukkit.getWorld("spawn"), 147.175, 68.000, -121.495);
    		l.setPitch((float)5.6);
    		l.setYaw((float)90.0);
    		p.chat("/woolwars leave");
            new BukkitRunnable() {
                
                public void run() {
                    p.getInventory().clear();
            }}.runTaskLater(BukkitMain.plugin, 10l);
                
            ItemJoinAPI itemAPI = new ItemJoinAPI();
new BukkitRunnable() {
                
                public void run() {
                   itemAPI.getItems(p);
            }}.runTaskLater(BukkitMain.plugin, 25l);
    		p.teleport(l);
    	}
    	
    	if (p.getWorld().equals(Bukkit.getWorld("block2")) || p.getWorld().equals(Bukkit.getWorld("block")) || p.getWorld().equals(Bukkit.getWorld("block3"))) {
    		p.chat("/blockparty leave");
    	}
    	if (p.getWorld().equals(Bukkit.getWorld("mw")) || p.getWorld().equals(Bukkit.getWorld("mw2")) || p.getWorld().equals(Bukkit.getWorld("mv3"))) {
    		p.chat("/mw leave");
    	}
    	if (p.getWorld().equals(Bukkit.getWorld("quake"))) {
    		p.chat("/quake leave");
    	}
    	if (p.getWorld().equals(Bukkit.getWorld("spleeg")) || p.getWorld().equals(Bukkit.getWorld("spleeg2"))) {
    		p.chat("/splegg leave");
    	}
    	if (p.getWorld().equals(Bukkit.getWorld("torneio"))) {
    		p.chat("/pvr leave");
    		p.chat("/pvr2 leave");
    		Location l = new Location(Bukkit.getWorld("spawn"), 147.175, 68.000, -121.495);
    		l.setPitch((float)5.6);
    		l.setYaw((float)90.0);
            new BukkitRunnable() {
                
                public void run() {
                    p.getInventory().clear();
            }}.runTaskLater(BukkitMain.plugin, 10l);
                
            ItemJoinAPI itemAPI = new ItemJoinAPI();
new BukkitRunnable() {
                
                public void run() {
                   itemAPI.getItems(p);
            }}.runTaskLater(BukkitMain.plugin, 25l);
    		p.teleport(l);
    	}
    	if (Bukkit.getPluginManager().getPlugin("LeafMito") != null) {
    		BungeeAPI.send(p, "lobby");
    	}

    	if (Bukkit.getPluginManager().getPlugin("AulerSkywars") != null) {
    		
    		p.chat("/sw leave");
    	}
    	
    	if (p.getWorld().equals(Bukkit.getWorld("spawn"))) {
    		p.sendMessage(ChatColor.RED + "Você já está no lobby principal!");
    	}
    	if (!p.getWorld().equals(Bukkit.getWorld("spawn")) && !p.getWorld().equals(Bukkit.getWorld("spawnbw"))&& !p.getWorld().equals(Bukkit.getWorld("arena"))&& !p.getWorld().equals(Bukkit.getWorld("fps"))&& !p.getWorld().equals(Bukkit.getWorld("lava")) && !p.getWorld().equals(Bukkit.getWorld("1v1"))) {
    		p.sendMessage(ChatColor.RED + "Esse comando não existe.");
    	
    	}

return false;
 
}
}
