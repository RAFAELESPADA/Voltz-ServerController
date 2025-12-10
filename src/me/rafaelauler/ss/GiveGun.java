package me.rafaelauler.ss;



import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class GiveGun implements CommandExecutor {


		public static boolean isNumeric(String str) {
			try {
				Integer.parseInt(str);
			} catch (NumberFormatException nfe) {
				return false;
			}
			return true;
		}


/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 19 */     if (cmd.getName().equalsIgnoreCase("givegun"))
/*    */     {
/* 22 */       if (args.length != 2) {
/* 23 */         sender.sendMessage(ChatColor.RED+ "Use /givegun <Nick> <Amount>");
/* 34 */         return true;
/*    */       }       
/* 37 */       if ((args.length > 0) && (args.length == 2)) {
/* 38 */         Player t = org.bukkit.Bukkit.getServer().getPlayer(args[0]);
		if (!isNumeric(args[1])) {
			sender.sendMessage("Use only numbers and a player name!");
			return true;
		}
		if (!sender.hasPermission("kitpvp.givegun")) {
			sender.sendMessage("You dont have permission to do that!");
			return true;
		}
		Integer i = Integer.parseInt(args[1]);
		if (t == null) {
			sender.sendMessage("This player is offline!");
			return true;
		}
		    final ItemStack sopas = new ItemStack(Material.WOOD_HOE);
		    final ItemMeta sopasm = sopas.getItemMeta();
		    sopasm.setDisplayName("§eAK-47");
		    sopas.setItemMeta(sopasm);	   
		    t.getInventory().addItem(sopas);	    
sender.sendMessage(ChatColor.GREEN + "You give: " + i + " guns to the player: " + t.getName());
	        
	
/*    */       
/*    */     }     
/* 54 */     
/*    */   }
/*    */


return false;
}
}

