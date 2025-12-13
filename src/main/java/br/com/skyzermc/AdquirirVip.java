package br.com.skyzermc;

import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;


public class AdquirirVip implements CommandExecutor {
    
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
        if (!(sender instanceof Player)) {
            return true;
	}
        if (args.length < 1) {
            sender.sendMessage("§b/adquirirvip VIP/MVP");
            sender.sendMessage("§eVIP ( 1 SEMANA ) CUSTA 8000 GOLDS");
            sender.sendMessage("§eMVP ( 1 SEMANA ) CUSTA 16000 GOLDS");
            return true;
        }
        PlayerPointsAPI ppAPI = PlayerPoints.getInstance().getAPI();
        String targetName = args[0];

Player p = (Player)sender;
 if (targetName.equalsIgnoreCase("vip")) {
	 
    
    	 if (ppAPI.look(p.getUniqueId()) > 8000.0) {
    		 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + sender.getName() + " parent addtemp vip 7d");
    		 sender.sendMessage(ChatColor.GREEN + " Você adquiriu VIP por 1 semana por 8000 de gold");
    		 ppAPI.take(p.getUniqueId(), 8000);
    	 } else {
    		 sender.sendMessage(ChatColor.RED + " Você não tem GOLDS o suficiente");
    	 }}
    	 
    	  else if (targetName.equalsIgnoreCase("mvp")) {
    	  } if (ppAPI.look(p.getUniqueId()) > 16000.0) {
    		 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + sender.getName() + " parent addtemp pro 7d");
    		 ppAPI.take(p.getUniqueId(), 16000);
    		 sender.sendMessage(ChatColor.GREEN + " Você adquiriu MVP por 1 semana por 16000 de Gold");
    	 } else {
    		 sender.sendMessage(ChatColor.RED + " Você não tem GOLDS o suficiente");
    				 
    	 }

    	 
    	 return true;
     

     
	 
	}



}