package br.com.skyzermc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.luckperms.api.LuckPerms;

public class Enchant implements CommandExecutor {
    private final BukkitMain plugin;
    private final LuckPerms luckPerms;

    public Enchant(BukkitMain plugin, LuckPerms luckPerms) {
        this.plugin = plugin;
        this.luckPerms = luckPerms;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    	Player p = (Player)sender;
        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Especifique um encantamento!");
            return true;
        }
        if (!Bukkit.getServer().getName().equals("Prison")) {

            sender.sendMessage(ChatColor.RED + "SERVER INVALIDO!");
        	return true;
        }
 
return false;
}
}