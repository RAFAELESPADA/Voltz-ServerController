package me.rafaelauler.ss;



import java.util.ArrayList;
import java.util.EnumSet;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import br.com.ystoreplugins.lib.jda.net.dv8tion.jda.api.JDA;
import br.com.ystoreplugins.lib.jda.net.dv8tion.jda.api.JDABuilder;
import br.com.ystoreplugins.lib.jda.net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import br.com.ystoreplugins.lib.jda.net.dv8tion.jda.api.interactions.commands.OptionType;
import br.com.ystoreplugins.lib.jda.net.dv8tion.jda.api.interactions.commands.build.Commands;
import br.com.ystoreplugins.lib.jda.net.dv8tion.jda.api.requests.GatewayIntent;
import br.com.ystoreplugins.lib.jda.net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import br.com.ystoreplugins.product.yespadasfarm.EspadasFarmAPIHolder;
import br.com.ystoreplugins.product.yrankup.RankupAPIHolder;
import br.com.ystoreplugins.product.ytempoonline.TempoAPIHolder;
import net.luckperms.api.LuckPerms;








public class BukkitMain extends JavaPlugin implements PluginMessageListener, Listener {

    public static BukkitMain plugin;
    private static String channel2 = "BungeeTeleport";
    private LuckPerms luckPerms;

    boolean up = true;
    public final String TOKEN = "NULO";


    private int rotate = 0, dropID = 0;

    public String ifNullEmpty(String check) {
      if (check == null)
        return ""; 
      return check;
    }
    @Override
    public void onEnable() {
    	  plugin = this;
registerEvents();
if (Bukkit.getPluginManager().getPlugin("BedWars1058") != null) {
JDA jda = JDABuilder.createLight(TOKEN, EnumSet.of(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)).addEventListeners(new BedwarsEvents(this, this.luckPerms))
.build();
CommandListUpdateAction commands = jda.updateCommands();

commands.addCommands(
		  Commands.slash("perfil", "Veja status de kitpvp , bedwars e rankup de um jogador")
              .addOption(OptionType.STRING, "nick", "Nick do jogador", true) // you can add required options like this too
               
    .setDefaultPermissions(DefaultMemberPermissions.ENABLED)) // only admins should be able to use this command.
;
commands.queue();
Bukkit.getConsoleSender().sendMessage("COMANDO DO BOT REGISTRADO /perfil no discord server");


		// Then finally send your commands to discord using the API
		  commands.queue();
}
else {
	Bukkit.getConsoleSender().sendMessage("IGNORANDO REGISTRO DO BOT NESSE SERVIDOR");

}
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
		Bukkit.getConsoleSender().sendMessage("COULD NOT SETUP ECONOMY");
    }
    

	if (Bukkit.getPluginManager().isPluginEnabled("BedWars1058") && Bukkit.getPluginManager().getPlugin("BedWars1058") != null) {
	     // Spawn an invisible armor stand at the location
	ArmorStand armorStand;
	ArmorStand armorStand2;
	ArmorStand armorStand3;
	ArmorStand armorStand4;
    armorStand = (ArmorStand) Bukkit.getWorld("spawnbw").spawnEntity(new Location(Bukkit.getWorld("spawnbw"), 22.547, 71.45989, 9.654), EntityType.ARMOR_STAND);
    armorStand2 = (ArmorStand) Bukkit.getWorld("spawnbw").spawnEntity(new Location(Bukkit.getWorld("spawnbw"), 22.547, 71.45989, -17.499), EntityType.ARMOR_STAND);
    armorStand3 = (ArmorStand) Bukkit.getWorld("spawn").spawnEntity(new Location(Bukkit.getWorld("spawn"), 125.459, 70.5415, -115.5150), EntityType.ARMOR_STAND);
    armorStand4 = (ArmorStand) Bukkit.getWorld("spawn").spawnEntity(new Location(Bukkit.getWorld("spawn"), 125.459, 70.5415, -128.125), EntityType.ARMOR_STAND);

	     armorStand.setVisible(false);
	     armorStand.setGravity(false);
	     armorStand.getEquipment().setHelmet(new ItemStack(Material.EMERALD_BLOCK));

	     armorStand2.setVisible(false);
	     armorStand2.setGravity(false);
	     armorStand2.getEquipment().setHelmet(new ItemStack(Material.EMERALD_BLOCK));
	     armorStand3.setVisible(false);
	     armorStand3.setGravity(false);
	     armorStand3.getEquipment().setHelmet(new ItemStack(Material.EMERALD_BLOCK));

	     armorStand4.setVisible(false);
	     armorStand4.setGravity(false);
	     armorStand4.getEquipment().setHelmet(new ItemStack(Material.EMERALD_BLOCK));// Place the item in its "hand"
	  // Run this task repeatedly every game tick (20 ticks per second)

	  	Bukkit.getConsoleSender().sendMessage("(spawning bw animated armor stands)");
	  	new BukkitRunnable() {

            double y = 0;
            boolean increase = true;

            @Override
            public void run() {
                if (y >= Math.PI * 6) {
                    increase = false;
                } else if (y <= 0) {
                    increase = true;
                }
                if (increase) {
                    y += 0.2;
                } else {
                    y -= 0.2;
                }
                armorStand.setHeadPose(new EulerAngle(0, y, 0));
                armorStand2.setHeadPose(new EulerAngle(0, y, 0));

                armorStand3.setHeadPose(new EulerAngle(0, y, 0));
                armorStand4.setHeadPose(new EulerAngle(0, y, 0));
            }
        }.runTaskTimer(BukkitMain.plugin, 1, 1);
	
	}  else {
		ArmorStand armorStand;
		ArmorStand armorStand2;

	    armorStand = (ArmorStand) Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), 594.127, 44.14441, 598.247), EntityType.ARMOR_STAND);
	    armorStand2 = (ArmorStand) Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), 606.153, 44.144441, 597.731), EntityType.ARMOR_STAND);

		     armorStand.setVisible(false);
		     armorStand.setGravity(false);
		     armorStand.getEquipment().setHelmet(new ItemStack(Material.LAPIS_BLOCK));

		     armorStand2.setVisible(false);
		     armorStand2.setGravity(false);
		     armorStand2.getEquipment().setHelmet(new ItemStack(Material.REDSTONE_BLOCK));// Place the item in its "hand"
		  // Run this task repeatedly every game tick (20 ticks per second)

		  	Bukkit.getConsoleSender().sendMessage("(spawning rankup animated armor stands)");
		  	new BukkitRunnable() {

	            double y = 0;
	            boolean increase = true;

	            @Override
	            public void run() {
	                if (y >= Math.PI * 6) {
	                    increase = false;
	                } else if (y <= 0) {
	                    increase = true;
	                }
	                if (increase) {
	                    y += 0.2;
	                } else {
	                    y -= 0.2;
	                }
	                armorStand.setHeadPose(new EulerAngle(0, y, 0));
	                armorStand2.setHeadPose(new EulerAngle(0, y, 0));
	            }	
		  			  	
}.runTaskTimer(BukkitMain.plugin, 1, 1);
    Bukkit.getConsoleSender().sendMessage("(spawned rankup animated generators on rankup with sucess)");
}

	

this.luckPerms = getServer().getServicesManager().load(LuckPerms.class);
  Bukkit.getMessenger().registerOutgoingPluginChannel(this, channel2);
  Bukkit.getMessenger().registerIncomingPluginChannel(this, channel2, this);

  Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
  Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
  Bukkit.getServer().getPluginManager().registerEvents(this, this);
  Bukkit.getConsoleSender().sendMessage("[TELEPORT] CANAL DO BUNGEE " + channel2 + " REGISTRADO");
  new Eventos(this, this.luckPerms).register();
  getCommand("modo").setExecutor(new Modo());
  getCommand("sudo").setExecutor(new Sudo());
  getCommand("dano").setExecutor(new Dano());
  
  getCommand("perfil").setExecutor(new PerfilCMD());
  getCommand("tempogrupo").setExecutor(new TempoGrupoBukkit());
  getCommand("grupo").setExecutor(new GrupoBukkit());
  getCommand("creport").setExecutor(new Report());
  getCommand("tag").setExecutor(new TagCommand());
  getCommand("prefixo").setExecutor(new TagCommand());
  getCommand("givegun").setExecutor(new GiveGun());
  getCommand("build").setExecutor(new NoBreakEvent());
  getCommand("manutencao").setExecutor(new Manutencao(this, this.luckPerms));
  getCommand("ctag").setExecutor(new cTag(this, this.luckPerms));
  getCommand("jogarbw").setExecutor(new JogarBW(this, this.luckPerms));

  getCommand("lobby").setExecutor(new Lobby(this, this.luckPerms));
  getCommand("consolesudo").setExecutor(new Sudo());
  getCommand("pickencantar").setExecutor(new Enchant(this, this.luckPerms));

  getCommand("gorankup").setExecutor(new Rankup(this, this.luckPerms));
  getCommand("set-prefix").setExecutor(new SetPrefix(this, this.luckPerms));
}
    }
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("[TELEPORT] PLUGIN DESLIGADO COM SUCESSO");
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
        if (Bukkit.getWorld("spawnbw") != null) {
       for (Entity e: Bukkit.getWorld("spawnbw").getEntities()) {
    	   if (e instanceof ArmorStand) {
    		   if (e != null) {
    		   e.remove();
    		   }
    		   for (Entity e3 : Bukkit.getWorld("spawn").getEntities()) {
    	    	   if (e3 instanceof ArmorStand) {
    	    		   if (e3 != null) {
    	    		   e3.remove();
    	    		   }
    	   } else { 
    	   for (Entity e2 : Bukkit.getWorld("world").getEntities()) {
    		    	   if (e2 instanceof ArmorStand) {
    		    		   if (e2 != null) {
    		    		   e.remove();
    		    		   }		   
    		    	   }
    	   }
    	   }
       }
    	   }}}
       
       
       
    }

    public void registerEvents(){
    	PluginManager pm = Bukkit.getPluginManager();
    	Bukkit.getConsoleSender().sendMessage("[REPORT] EVENTOS INICIANDO");
    	pm.registerEvents(new PlayerJoin(this), this);
    	pm.registerEvents(new Perfil(), this);
    	pm.registerEvents(new NoBreakEvent(), this);
    	pm.registerEvents(new Gun(), this);	
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

