package me.rafaelauler.ss;




import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.ystoreplugins.ypoints.api.yPointsAPI;

import me.clip.placeholderapi.PlaceholderAPI;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;

public class Perfil implements Listener {



    
	static LuckPerms api2 = LuckPermsProvider.get();
	  
    @EventHandler
    private void onInventoryClick(InventoryClickEvent event) {
    	if (!event.getInventory().getName().equals("§8Perfil do Jogador")) {
    		return;
    	}
    	event.setCancelled(true);   }
    

    public static void openGUI(Player player, Player target) {
        Inventory inv = Bukkit.createInventory(null, 27, "§8Perfil do Jogador");
        ItemStack glass = getCustomItemStack(Material.STAINED_GLASS_PANE, "§dVidro", "");

        final OfflinePlayer player2 = player;
        inv.setItem(4, editItemStack(getPlayerSkull(player.getName()), "§eSuas informações", Arrays.asList("§fNick: §a" + player.getName(), "§fUUID: §a" + player.getUniqueId(), "§fCash: §a" + new DecimalFormat("###,###.##").format(yPointsAPI.getBalance(player.getName())), "§fPrimeiro acesso:" + " §a" + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(player.getFirstPlayed()), "§fCargo: " +  api2.getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getPrefix().replace("&", "§"))));
        inv.setItem(11, getCustomItemStack(Material.BED, "§eBEDWARS", Arrays.asList("§fKills Regulares: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%bw1058_stats_kills%"), "§fKills Totais: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%bw1058_stats_total_kills%"), "§fMortes: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%bw1058_stats_deaths%") , "§fPerdeu: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%bw1058_stats_losses%") , "§fGanhou: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%bw1058_stats_wins%") , "§fCamas Destruídas: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%bw1058_stats_bedsdestroyed%") , "§fPartidas jogadas: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%bw1058_stats_gamesplayed%") , "§fXP no Bedwars: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%bw1058_player_xp%") , "§fKills Finais: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%bw1058_stats_finalkills%"))));
        inv.setItem(13, getCustomItemStack(Material.DIAMOND_SWORD, "§eKITPVP", Arrays.asList("§fKills: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%kp-pvp_player_kills%"), "§fKS: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%kp-pvp_player_streak%"), "§fMortes: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%kp-pvp_player_deaths%") , "§fCoins: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%kp-pvp_player_coins%") , "§fXP: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%kp-pvp_player_xp%") , "§fNível: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%kp-pvp_player_level%") , "§fXP pro prox nível: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%kp-pvp_player_xp_to_levelup%") , "§fKit: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%kp-pvp_player_kit%") , "§fJogadores: §a" + PlaceholderAPI.setPlaceholders(player2, "§a%kp-pvp_players_count_total%"))));
        inv.setItem(15, getCustomItemStack(Material.IRON_PICKAXE, "§eRANKUP", "§cEm Breve estatísticas do Rankup OP estarão disponíveis nesse menu."));
        target.openInventory(inv);
    }

    public static ItemStack editItemStack(ItemStack itemStack, String name, List<String> lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getPlayerSkull(String name) {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setOwner(name);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

public static ItemStack getCustomItemStack(Material material, String name, String lore) {
    ItemStack itemStack = new ItemStack(material);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(name);
    if (lore != null) {
        List<String> l = Collections.singletonList(lore);
        itemMeta.setLore(l);
    }
    itemStack.setItemMeta(itemMeta);
    return itemStack;
}

public static ItemStack getCustomItemStack(Material material, String name, List<String> lore) {
    ItemStack itemStack = new ItemStack(material);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(name);
    itemMeta.setLore(lore);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
}
}

