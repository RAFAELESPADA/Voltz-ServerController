package me.rafaelauler.ss;


	import org.bukkit.entity.Player;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.node.types.PermissionNode;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;


	public class DemoteAllStaff extends Command {
		public DemoteAllStaff() {
		    super("demoteallstaff", null, new String[] { "demotartodos" , "resetarequipe" });
		  }
		  
	  LuckPerms api = LuckPermsProvider.get();
	  public static boolean isPlayerInGroup(Player player, String group) {
	        return player.hasPermission("group." + group);
	    }
	  public void execute(CommandSender sender, String[] args) {
	    if (!sender.hasPermission("tag.diretor")) {
	      sender.sendMessage(ChatColor.RED + "Você precisa ser Diretor ou superior para executar esse comando.");
	      return;
	    } 
	    if (args.length != 1) {
	      sender.sendMessage(ChatColor.DARK_AQUA + "Uso correto: /demotartodos confirmar.");
	      return;
	    } 
	    try {
	    if (args[0].equalsIgnoreCase("confirmar")) {
	    	PermissionNode node = PermissionNode.builder("utils.staffchat.use").build();
	    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(node))) {
	    api.getUserManager().deletePlayerData(u.getUniqueId());	
	    sender.sendMessage(ChatColor.RED + "Todos da equipe foram demotados! Exceto você!");
	    	 
	     }
	            });
	    } }catch (ArrayIndexOutOfBoundsException e) {
	    	sender.sendMessage(ChatColor.DARK_AQUA + "Uso correto: /demotartodos confirmar.");
		      return;
		    } 
		    
	  }}
	    	
	    
	 
	
	
	
