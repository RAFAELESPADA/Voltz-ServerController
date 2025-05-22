package me.rafaelauler.ss;


import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class StaffList extends Command {
  public static ArrayList<String> sc = new ArrayList<>();
  
  public StaffList(Plugin plugin) {
    super("stafflist", null, new String[] { "listarstaffs" });
  }
  
  public void execute(CommandSender sender, String[] args) {
	  if (!sender.hasPermission("staffchat.use")) {
		  sender.sendMessage(ChatColor.RED + "Você não tem autorização");
		  return;
	  }
    sender.sendMessage(ChatColor.GREEN + "** STAFFS ONLINE **");
    ProxyServer.getInstance().getPlayers().stream().filter(online -> online.hasPermission("staffchat.use"))

    .forEach(online -> {
    sender.sendMessage(ChatColor.RED + "( " + online.getName() + " )" + ChatColor.YELLOW +  " Online em: " + ChatColor.GREEN + online.getServer().getInfo().getName());
    });
}
  
  }