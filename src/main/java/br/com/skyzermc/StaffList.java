package br.com.skyzermc;


import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class StaffList extends Command {
	public StaffList(Plugin plugin) {
		super("stafflist", null, new String[] { "staffl" });
	  }
	LuckPerms api2 = LuckPermsProvider.get();
	  



  
  
  public void execute(CommandSender sender, String[] args) {
	  if (!sender.hasPermission("stormplugins.lobby.staffchat")) {
		  sender.sendMessage(ChatColor.RED + "Você não tem autorização");
		  return;
	  }
    sender.sendMessage(ChatColor.GREEN + "** STAFFS ONLINE NA REDE **");
    ProxyServer.getInstance().getPlayers().stream().filter(online -> online.hasPermission("stormplugins.lobby.staffchat"))

    .forEach(online -> {
    sender.sendMessage(ChatColor.RED + "( " + api2.getUserManager().getUser(online.getUniqueId()).getCachedData().getMetaData().getPrefix().replace("&", "§") + online.getName() + " §c)" + ChatColor.YELLOW +  " Online em: " + ChatColor.GREEN + online.getServer().getInfo().getName());
    });
}
  
  }