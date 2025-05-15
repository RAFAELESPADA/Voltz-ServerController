package me.rafaelauler.ss;



import java.util.ArrayList;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.ystoreplugins.ypoints.api.yPointsAPI;

import br.com.ystoreplugins.product.yespadasfarm.EspadasFarmAPIHolder;
import br.com.ystoreplugins.product.yrankup.RankupAPIHolder;
import br.com.ystoreplugins.product.ytempoonline.TempoAPIHolder;
import net.luckperms.api.LuckPerms;








public class BukkitMain extends JavaPlugin implements PluginMessageListener, Listener {

    public static BukkitMain plugin;
    private static String channel2 = "BungeeTeleport";
    private LuckPerms luckPerms;
    
    

    public String ifNullEmpty(String check) {
      if (check == null)
        return ""; 
      return check;
    }
    @Override
    public void onEnable() {
    	  plugin = this;
registerEvents();
if (MCVersion.get().isInferior(MCVersion.v1_13)) {
    channel2 = "bungee:teleport"; 
}
if (PlayerGroup.getRoles().isEmpty()) {
	for (PlayerGroup v : PlayerGroup.values()) {
    PlayerGroup.getRoles().add(v);
    }
	if (!Eventos.setupPermissions()) {
        getServer().getPluginManager().disablePlugin(this);
        return;
    }
	if (!Eventos.setupEconomy()) {
        getServer().getPluginManager().disablePlugin(this);
        return;
    }
    yPointsAPI.ypointsapi = new yPointsAPI();
this.luckPerms = getServer().getServicesManager().load(LuckPerms.class);
  Bukkit.getMessenger().registerOutgoingPluginChannel(this, channel2);
  Bukkit.getMessenger().registerIncomingPluginChannel(this, channel2, this);
  Bukkit.getServer().getPluginManager().registerEvents(this, this);
  Bukkit.getConsoleSender().sendMessage("[TELEPORT] CANAL DO BUNGEE " + channel2 + " REGISTRADO");
  new Eventos(this, this.luckPerms).register();
  getCommand("adquirirvip").setExecutor(new AdquirirVip());
  getCommand("modo").setExecutor(new Modo());
  getCommand("sudo").setExecutor(new Sudo());
  getCommand("dano").setExecutor(new Dano());
  getCommand("tag").setExecutor(new TagCommand());
  getCommand("tempogrupo").setExecutor(new TempoGrupoBukkit());
  getCommand("grupo").setExecutor(new GrupoBukkit());
  getCommand("report").setExecutor(new Report());
  getCommand("manutencao").setExecutor(new Manutencao(this, this.luckPerms));
  getCommand("ctag").setExecutor(new cTag(this, this.luckPerms));
  getCommand("consolesudo").setExecutor(new Sudo());
  getCommand("pickencantar").setExecutor(new Enchant(this, this.luckPerms));
  getCommand("set-prefix").setExecutor(new SetPrefix(this, this.luckPerms));
    }
    }
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("[TELEPORT] PLUGIN DESLIGADO COM SUCESSO");
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
    }

    public void registerEvents(){
    	PluginManager pm = Bukkit.getPluginManager();
    	Bukkit.getConsoleSender().sendMessage("[REPORT] EVENTOS INICIANDO");
    	pm.registerEvents(new PlayerJoin(this), this);
    	if (Bukkit.getPluginManager().isPluginEnabled("AuraSkills")) {
    	pm.registerEvents(new AuraListener(), this);
    	}
     	
    	pm.registerEvents(new Eventos(this, this.luckPerms), this);
    }

public static void darEfeito(Player p, PotionEffectType tipo, int duracao, int level)
/*     */   {
/* 349 */     p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
/*     */   }

public static TempoAPIHolder getTempoAPI() {
    try {
        RegisteredServiceProvider<TempoAPIHolder> rsp = Bukkit.getServer().getServicesManager()
            .getRegistration(TempoAPIHolder.class);
        return rsp == null ? null : rsp.getProvider();
    } catch (Throwable var1) {
        return null;
    }
}
public static RankupAPIHolder getRankupAPI() {
    try {
        RegisteredServiceProvider<RankupAPIHolder> rsp = Bukkit.getServer().getServicesManager()
            .getRegistration(RankupAPIHolder.class);
        return rsp == null ? null : rsp.getProvider();
    } catch (Throwable var1) {
        return null;
    }
}
public static EspadasFarmAPIHolder getEspadasAPI() {
    try {
        RegisteredServiceProvider<EspadasFarmAPIHolder> rsp = Bukkit.getServer().getServicesManager()
            .getRegistration(EspadasFarmAPIHolder.class);
        return rsp == null ? null : rsp.getProvider();
    } catch (Throwable var1) {
        return null;
    }
}


	
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("bungee:teleportp4")) {
          return; 
        }
        String action = null;
        ArrayList<String> received = new ArrayList<>();
        BukkitMain.plugin.getLogger().log(Level.INFO, "CANAL SENDO CHAMADO!");
        
        try {
        	  ByteArrayDataInput in = ByteStreams.newDataInput(message);
            while (true) {
                action = in.readUTF();
            received.add(in.readUTF()); 
            }} catch (Exception e) {
          e.printStackTrace();
        } 
        if (action == null) {
        	 BukkitMain.plugin.getLogger().log(Level.SEVERE, "ACTION IS NULL");
          return; 
        }
        BukkitMain.plugin.getLogger().log(Level.INFO, "ACTION IS " + action);
        if (action.equalsIgnoreCase("teleport")) {
          Player from = Bukkit.getServer().getPlayer(received.get(0));
          Player to = Bukkit.getServer().getPlayer(received.get(1));
          from.teleport(to);
        } 
    }
}

