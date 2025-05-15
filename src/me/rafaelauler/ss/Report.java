package me.rafaelauler.ss;



import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class Report
  implements CommandExecutor
{
  private static ArrayList<String> delay = new ArrayList();
  public static HashMap<String, String> toggle = new HashMap();
  
  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("report"))
    {
      final Player p = (Player)sender;
      if (args.length <= 1)
      {
        p.sendMessage("§cUse: /report <player> <motivo>");
        return true;
      }
      if (delay.contains(p.getName()))
      {
        p.sendMessage("§cAguarde para poder reportar novamente.");
        return true;
      }
      delay.add(p.getName());

/* 280 */       new BukkitRunnable()
/*     */       {
/*     */         public void run()
/*     */         {
	delay.remove(p.getName());
/*     */   
	  p.sendMessage("§cSeu Cooldown de Reportar acabou.");        
/*     */         }
/* 280 */       }.runTaskLater(BukkitMain.plugin, 240L);
/*     */     
      String reportado = args[0];
      if (p.getName().equalsIgnoreCase(reportado)) {
    	  p.sendMessage("§cVocê não pode se reportar.");
          return true;
        
      }
      Player reported2 = Bukkit.getPlayer(reportado);
      if (reported2 == null) {
    	  p.sendMessage("§cO Jogador está offline.");
          return true;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i < args.length; i++)
      {
        sb.append(args[i]);
        sb.append(" ");
      }
      String motivo = sb.toString();
      p.sendMessage("\n §aJogador foi reportado com sucesso!");
      p.sendMessage("§a§l* §7O uso indevido ou exagerado do /report pode resultar em punição! \n ");
      for (Player all : Bukkit.getOnlinePlayers()) {
        if (all.hasPermission("kombo.cmd.report")) {
        	if (toggle.containsKey(all.getName()))
        		return true;
        {
          all.sendMessage(" \n §a========§e§lREPORT§a========== \n  §eReporter: §7" + p.getName() + " \n  §eJogador reportado: §7" + reportado + " \n  §eMotivo:§7 " + motivo + " \n §a========§e§lREPORT§a========== \n ");
          all.playSound(all.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
        }
        }
      }
    
    
  }
	return false;
  }
}

