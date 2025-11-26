package me.rafaelauler.ss;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RockinChaos.itemjoin.api.ItemJoinAPI;
import net.luckperms.api.LuckPerms;

public class JogarBW implements CommandExecutor {
    private final BukkitMain plugin;
    private final LuckPerms luckPerms;

    public JogarBW(BukkitMain plugin, LuckPerms luckPerms) {
        this.plugin = plugin;
        this.luckPerms = luckPerms;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    	Player p = (Player)sender;
    	Location l = new Location(Bukkit.getWorld("spawnbw"), 20.924143489153664,70.0,-1.4775118882317213);
        l.setPitch((float)1.199923038482666);
        l.setYaw((float)268.344970703125);
        p.teleport(l);
        p.getInventory().clear();
        ItemJoinAPI itemAPI = new ItemJoinAPI();
        itemAPI.getItems(p);


 
return false;
}
}