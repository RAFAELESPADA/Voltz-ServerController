package br.com.skyzermc;


import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.md_5.bungee.api.ChatColor;


public class GrupoBukkit implements CommandExecutor {

	  
  LuckPerms api = LuckPermsProvider.get();
  
  
  



@Override
public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String arg2,
		String[] args) {
    if (!(sender instanceof Player)) {
        return true;
      }
      if (args.length < 2) {
        sender.sendMessage(ChatColor.DARK_AQUA + "Uso correto: /grupo <Jogador> <Grupo>.");
        return true;
      } 
      net.luckperms.api.model.group.Group group = api.getGroupManager().getGroup(args[1]);
      if (group == null) {
        sender.sendMessage(ChatColor.RED + "Grupo não encontrado.");
        sender.sendMessage(ChatColor.RED + "Use default para colocar como Membro.");
        return true;
      } 
      if (!sender.hasPermission("cmd.group." + args[1])) {
        sender.sendMessage(ChatColor.RED + "Você não pode setar alguém com esse grupo");
        return true;
      } 
      String target = args[0];
      Player targetPlayer;
      if ((targetPlayer = Bukkit.getPlayer(target)) != null) {
  if (targetPlayer.hasPermission("groupset.bypass")) {
  	sender.sendMessage(ChatColor.RED + "Você não pode gerenciar o grupo desse Jogador!");
  	sender.sendMessage(ChatColor.RED + "Ele possui um cargo acima do seu!");
      return true;
  }
  if (targetPlayer == sender) {
  	sender.sendMessage(ChatColor.RED + "Você não pode alterar seu proprio grupo!");
      return true;
  	
  }
      }
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + target + " parent clear");
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + target + " parent set " + args[1]);
      
      String textString = "§c* " + sender.getName() + " §csetou o grupo " + group.getName()
             + "§c para " + args[0] + "\n§cDuração: (Permanente)";
      Bukkit.broadcast(textString, "wpunish.veralerta");
      if ((targetPlayer = Bukkit.getPlayer(target)) != null) {
        targetPlayer.sendMessage(ChatColor.RED + "Seu grupo foi atualizado para " + args[1] + " por " + sender.getName()); 
      sender.sendMessage(ChatColor.RED + "Você atualizou o grupo de " + target + " para " + args[1] + " !");
      return true;
    }
  	
	return false;
}


  
}
