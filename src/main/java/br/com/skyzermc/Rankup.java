package br.com.skyzermc;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.luckperms.api.LuckPerms;

public class Rankup implements CommandExecutor {
    private final BukkitMain plugin;
    private final LuckPerms luckPerms;

    public Rankup(BukkitMain plugin, LuckPerms luckPerms) {
        this.plugin = plugin;
        this.luckPerms = luckPerms;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    	Player p = (Player)sender;
    	BungeeAPI.send(p, "rankup");


 
return false;
}
}
