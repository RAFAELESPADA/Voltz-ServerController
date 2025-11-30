package me.rafaelauler.ss;



import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;

import com.andrei1058.bedwars.api.BedWars;

import br.com.ystoreplugins.lib.jda.net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import br.com.ystoreplugins.lib.jda.net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import net.wavemc.core.bukkit.WaveBukkit;
import net.wavemc.core.bukkit.account.WavePlayer;


	public class BedwarsEvents extends ListenerAdapter {
	    private final BukkitMain plugin;
	    private final LuckPerms luckPerms;
	    public static Economy econ = null;
	    public static Permission perms = null;
	    public BedwarsEvents(BukkitMain plugin, LuckPerms luckPerms) {
	        this.plugin = plugin;
	        this.luckPerms = luckPerms;
	    }
	    BedWars bedwarsAPI = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();
	    public void onSlashCommandInteraction(SlashCommandInteractionEvent arg0)
	    {
	        // Only accept commands from guilds
	        if (arg0.getGuild() == null)
	            return;
	        switch (arg0.getName())
	        {
	        
	        case "perfil":
	          	 try {
	               aa(arg0, arg0.getOption("nick").getAsString()); // content is required so no null-check here
	               break;
	          	 }
	          	 catch (Exception e) {
	          	 	e.printStackTrace();
	          	 }
	        }
	        }
		protected boolean aa(@NotNull SlashCommandInteractionEvent arg0 , String nick) {
			 try {
			 if (WaveBukkit.getPlayerManager().getPlayer(nick) == null) {
				   arg0.reply("Esse jogador não está cadastrado no nosso banco de dados.").queue();
				   return true;
			   }
		   WavePlayer p = WaveBukkit.getPlayerManager().getPlayer(nick);
		  
	       RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
			if (provider != null) {
	OfflinePlayer real = Bukkit.getOfflinePlayer(nick);
			    LuckPerms api = provider.getProvider();
				
		  

<<<<<<< HEAD
		   arg0.reply("**INFORMAÇÕES DE ESTATÍSTICAS DO JOGADOR **" + p.getName() + "\nKills ( KITPVP ): " + p.getPvp().getKills() + "\nMortes: " + p.getPvp().getDeaths() + "\nKillStreak atual ( KITPVP ): " + p.getPvp().getKillstreak() + "\nKills na FPS ( KITPVP ): " + p.getPvp().getKillsfps() + "\nWins ( Sumô ): " + p.getPvp().getWinssumo() + "\nWins no duelos (1v1): " + p.getPvp().getWinsx1() + "\nXP: " + p.getPvp().getXp() + "\nCoins: " + p.getPvp().getCoins() + "\nMortes no 1v1: " + p.getPvp().getDeathsx1() + "\nWinStreak no 1v1: " + p.getPvp().getWinstreakx1() + "\nCargo: " + giveMeADamnUser(real.getUniqueId()).getPrimaryGroup().toUpperCase().toString() == "LYZE" ? "DIRETOR" : giveMeADamnUser(real.getUniqueId()).getPrimaryGroup().toUpperCase().toString() + "\nKills ( Bedwars ): " + bedwarsAPI.getStatsUtil().getPlayerKills(p.getUuid()) + "\nMortes ( Bedwars ): " + bedwarsAPI.getStatsUtil().getPlayerDeaths(p.getUuid()) + "\nWins ( Bedwars ): " + bedwarsAPI.getStatsUtil().getPlayerWins(p.getUuid()) + "\nCamas Destrúidas ( Bedwars ): " + bedwarsAPI.getStatsUtil().getPlayerBedsDestroyed(p.getUuid()) + "\nPerdas ( Bedwars ): " + bedwarsAPI.getStatsUtil().getPlayerLoses(p.getUuid()) + "\nPartidas Jogadas (BedWars): " + bedwarsAPI.getStatsUtil().getPlayerGamesPlayed(p.getUuid()) + "\nCoins: " + Eventos.econ.getBalance(real)).queue();
=======
		   arg0.reply("**INFORMAÇÕES DE ESTATÍSTICAS DO JOGADOR **" + p.getName() + "\nKills ( KITPVP ): " + p.getPvp().getKills() + "\nMortes: " + p.getPvp().getDeaths() + "\nKillStreak atual ( KITPVP ): " + p.getPvp().getKillstreak() + "\nKills na FPS ( KITPVP ): " + p.getPvp().getKillsfps() + "\nWins ( Sumô ): " + p.getPvp().getWinssumo() + "\nWins no duelos (1v1): " + p.getPvp().getWinsx1() + "\nXP: " + p.getPvp().getXp() + "\nCoins: " + p.getPvp().getCoins() + "\nMortes no 1v1: " + p.getPvp().getDeathsx1() + "\nWinStreak no 1v1: " + p.getPvp().getWinstreakx1() + "\nCargo: " + giveMeADamnUser(real.getUniqueId()).getPrimaryGroup().toUpperCase().toString() + "\nKills ( Bedwars ): " + bedwarsAPI.getStatsUtil().getPlayerKills(p.getUuid()) + "\nMortes ( Bedwars ): " + bedwarsAPI.getStatsUtil().getPlayerDeaths(p.getUuid()) + "\nWins ( Bedwars ): " + bedwarsAPI.getStatsUtil().getPlayerWins(p.getUuid()) + "\nCamas Destrúidas ( Bedwars ): " + bedwarsAPI.getStatsUtil().getPlayerBedsDestroyed(p.getUuid()) + "\nPerdas ( Bedwars ): " + bedwarsAPI.getStatsUtil().getPlayerLoses(p.getUuid()) + "\nPartidas Jogadas (BedWars): " + bedwarsAPI.getStatsUtil().getPlayerGamesPlayed(p.getUuid())).queue();
>>>>>>> c3d04a097994f28f504d1cba2c6d3d067d971ad7
		   return true; 
		   }
			 }
		   catch (NullPointerException e) {
			   arg0.reply("Esse jogador não está cadastrado no nosso banco de dados.").queue();
			   }
		
	
			return false;
		}
		public User giveMeADamnUser(UUID uniqueId) {
			 RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
				if (provider == null) return null; 
				    LuckPerms api = provider.getProvider();
		    UserManager userManager = api.getUserManager();
		    CompletableFuture<User> userFuture = userManager.loadUser(uniqueId);

		    return userFuture.join(); 
				}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
	       
	}
	
	}
<<<<<<< HEAD
	
=======
	
>>>>>>> c3d04a097994f28f504d1cba2c6d3d067d971ad7
