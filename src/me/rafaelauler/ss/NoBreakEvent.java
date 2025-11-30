package me.rafaelauler.ss;



/*    */ 


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import net.md_5.bungee.api.ChatColor;

public final class NoBreakEvent
  implements Listener, CommandExecutor
{
  public static ArrayList<Player> embuild = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("build")) {
      if (p.hasPermission("tag.admin"))
      {
        if (args.length == 0)
        {
          if (!embuild.contains(p))
          {
            embuild.add(p);
            p.sendMessage(String.valueOf("§c§lSKYZERMC ") + "§aAgora você pode construir nesse lobby");
          }
          else
          {
            embuild.remove(p);
            p.sendMessage(String.valueOf("§c§lSKYZERMC ") + "§cVocê agora não pode mais construir nesse lobby");
          }
        }
        else
        {
          Player t = Bukkit.getPlayer(args[0]);
          if (t == null)
          {
            p.sendMessage("§c§lBUILD" + "§cEsse jogador está offline");
            return true;
          }
          if (!embuild.contains(t))
          {
            embuild.add(t);
            p.sendMessage(String.valueOf("§c§lSKYZERMC ") + "§aAgora: §7" + t.getName() + " §apode editar esse lobby");
          }
          else
          {
            embuild.remove(t);
            p.sendMessage(String.valueOf("§c§lSKYZERMC ") + "§aAgora: §7" + t.getName() + " §anão pode mais editar esse lobby");
          }
        }
      }
      else {
        p.sendMessage(String.valueOf("§c§lSKYZERMC ") + "§fVocê precisa ser Administrador ou superior para executar esse comando.");
      }
    }
    return false;
  }
  
  @EventHandler
  public void aoconstruir(BlockPlaceEvent e)
  {
    Player p = e.getPlayer();
    if (p.getWorld().equals(Bukkit.getWorld("spawn")) || p.getWorld().equals(Bukkit.getWorld("spawnbw")) || p.getWorld().equals(Bukkit.getWorld("world"))) {
    if (!embuild.contains(p)) {
      e.setCancelled(true);
      p.sendMessage(ChatColor.RED + "Você não pode quebrar esse bloco nessa área protegida sem autorização.");
      p.sendMessage(ChatColor.RED + "Utilize /build para habilitar o modo de edição");
    }
    }
  }
  
  @EventHandler
  public void aoconstruir(BlockBreakEvent e)
  {
    Player p = e.getPlayer();
    if (p.getWorld().equals(Bukkit.getWorld("spawn")) || p.getWorld().equals(Bukkit.getWorld("spawnbw")) || p.getWorld().equals(Bukkit.getWorld("world"))) {
    if (!embuild.contains(p)) {
        p.sendMessage(ChatColor.RED + "Você não pode quebrar esse bloco nessa área protegida sem autorização.");
        p.sendMessage(ChatColor.RED + "Utilize /build para habilitar o modo de edição");
      e.setCancelled(true);
    }
  }
}
}


