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
		    super("demoteallstaff", null, new String[] { "demotartodos" , "resetarequipe", "removercargos" });
		  }
		  
	  LuckPerms api = LuckPermsProvider.get();
	  public static boolean isPlayerInGroup(Player player, String group) {
	        return player.hasPermission("group." + group);
	    }
	  public void execute(CommandSender sender, String[] args) {
	    if (!sender.hasPermission("*")) {
	      sender.sendMessage(ChatColor.RED + "Você precisa ser Diretor ou superior para executar esse comando.");
	      return;
	    } 
	    if (args.length != 1) {
	      sender.sendMessage(ChatColor.AQUA + "Uso correto: /demotartodos <Grupo, Staff>.");
	      return;
	    }
	    try {
	    	switch (args[0]) {
	    	case "staff":
	    	PermissionNode node = PermissionNode.builder("stormplugins.lobby.staffchat").build();
	    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(node))) {
	    api.getUserManager().deletePlayerData(u.getUniqueId());
	    
	    }});
	    sender.sendMessage(ChatColor.RED + "Todos da equipe foram demotados! Exceto você!");

	    break;
			  case "diretor":
			    	PermissionNode node2gf = PermissionNode.builder("group.lyze").build();
				    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(node2gf))) {
				    api.getUserManager().deletePlayerData(u.getUniqueId());	
				    sender.sendMessage(ChatColor.RED + "Todos os Diretores foram demotados! Exceto você!");
				    }});
	break;
		  case "gerente":
		    	PermissionNode node2 = PermissionNode.builder("group.gerente").build();
			    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(node2))) {
			    api.getUserManager().deletePlayerData(u.getUniqueId());	
			    sender.sendMessage(ChatColor.RED + "Todos os gerentes foram demotados! Exceto você!");
			    }});
break;
		  case "administrador":
		    	PermissionNode node3= PermissionNode.builder("group.administrador").build();
			    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(node3))) {
			    api.getUserManager().deletePlayerData(u.getUniqueId());	
			    sender.sendMessage(ChatColor.RED + "Todos os Admins foram demotados! Exceto você!");
			    }});
			    break;
		  case "moderador":
		    	PermissionNode node4 = PermissionNode.builder("group.moderador").build();
			    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(node4))) {
			    api.getUserManager().deletePlayerData(u.getUniqueId());	
			    sender.sendMessage(ChatColor.RED + "Todos os Moderador foram demotados! Exceto você!");
			    }});
			    break;
		  case "ajudante":
		    	PermissionNode node5 = PermissionNode.builder("group.ajudante").build();
			    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(node5))) {
			    api.getUserManager().deletePlayerData(u.getUniqueId());	
			    sender.sendMessage(ChatColor.RED + "Todos os Ajudantes foram demotados! Exceto você!");
			    }});
			    break;
		  case "hunter":
		    	PermissionNode node96 = PermissionNode.builder("group.hunter").build();
			    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(node96))) {
			    api.getUserManager().deletePlayerData(u.getUniqueId());	
			    sender.sendMessage(ChatColor.RED + "Todos os Hunters foram demotados! Exceto você!");
			    }});
			    break;
		  case "knight":
		    	PermissionNode node9v6 = PermissionNode.builder("group.hunter").build();
			    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(node9v6))) {
			    api.getUserManager().deletePlayerData(u.getUniqueId());	
			    sender.sendMessage(ChatColor.RED + "Todos os Knights foram demotados! Exceto você!");
			    }});
			    break;
		  case "lord":
		    	PermissionNode node969 = PermissionNode.builder("group.hunter").build();
			    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(node969))) {
			    api.getUserManager().deletePlayerData(u.getUniqueId());	
			    sender.sendMessage(ChatColor.RED + "Todos os Lord foram demotados! Exceto você!");
			    }});
			    break;
		  case "beta":
		    	PermissionNode node97 = PermissionNode.builder("group.beta").build();
			    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(node97))) {
			    api.getUserManager().deletePlayerData(u.getUniqueId());	
			    sender.sendMessage(ChatColor.RED + "Todos os Beta foram demotados! Exceto você!");
			    }});
			    break;
		  case "nitro":
		    	PermissionNode nodenutro = PermissionNode.builder("group.nitro").build();
			    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(nodenutro))) {
			    api.getUserManager().deletePlayerData(u.getUniqueId());	
			    sender.sendMessage(ChatColor.RED + "Todos os Nitros foram demotados! Exceto você!");
			    }});
			    break;
		  case "influencer":
		    	PermissionNode node6 = PermissionNode.builder("group.youtuber").build();
			    api.getUserManager().getLoadedUsers().forEach(u -> { if (u.getUsername() != sender.getName() && (u.getNodes().contains(node6))) {
			    api.getUserManager().deletePlayerData(u.getUniqueId());	
			    sender.sendMessage(ChatColor.RED + "Todos os Influenciadores foram demotados! Exceto você!");
			    }});
			    break;
			    default:

			    	sender.sendMessage(ChatColor.DARK_RED + "Uso correto: /demotartodos <Staff, Grupo>.");
			    	break;
			    

	    
	    	}} catch (ArrayIndexOutOfBoundsException e) {
		    	sender.sendMessage(ChatColor.RED + "Uso correto: /demotartodos <Staff, Grupo>.");
		      return;
		    } 
	  }
	}
	    	
	    
	 
	
	
	
