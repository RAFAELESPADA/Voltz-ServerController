package me.rafaelauler.ss;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum PlayerGroup {


    OWNER("Owner", 1, "Owner", "tag.owner", ChatColor.DARK_RED, 1),
    DIRETOR("Diretor", 2, "Diretor", "tag.diretor", ChatColor.GOLD, 1),
    GERENTE("Gerente", 3, "Gerente", "tag.gerente", ChatColor.DARK_PURPLE, 2),
    PATROCINADOR("Patrocinador", 4, "Patrocinador", "tag.patrocinador", ChatColor.GREEN , 11),
    ADMIN("Administrador", 5, "Administrador", "tag.admin", ChatColor.DARK_RED, 3),       
    SENIORMOD("SeniorMod", 6, "SeniorMod", "tag.seniormod", ChatColor.DARK_AQUA, 5),
    CONSTRUTOR("Construtor", 7, "Construtor", "tag.construtor", ChatColor.LIGHT_PURPLE, 6),
    MOD("Moderador", 8, "Moderador", "tag.mod", ChatColor.DARK_GREEN, 7),
    AJUDANTE("Ajudante", 9, "Ajudante", "tag.ajudante", ChatColor.YELLOW, 8),
    TIKTOKERPLUS("Tiktoker+", 10, "Tiktoker+", "tag.tiktoker+", ChatColor.BLUE, 9),
    YOUTUBERPLUS("Youtuber+", 11, "Youtuber+", "tag.youtuber+", ChatColor.BLUE, 9),
    STREAMERPLUS("Streamer+", 12, "Streamer+", "tag.streamer+", ChatColor.BLUE, 9),
    INFLUENCERPLUS("Influencer+", 13, "Influencer+", "tag.influencer+", ChatColor.BLUE, 9),
    STREAMER("Streamer", 14, "Streamer", "tag.streamer", ChatColor.DARK_AQUA, 9),
    YOUTUBER("Youtuber", 15, "Youtuber", "tag.youtuber", ChatColor.AQUA, 9),
    TIKTOKER("TikToker", 16, "TikToker", "tag.tiktoker", ChatColor.DARK_PURPLE, 9),
    INFLUENCER("Influencer", 17, "Influencer", "tag.influencer", ChatColor.RED, 9),
    MINIYT("MiniYT", 18, "MiniYT", "tag.miniyt", ChatColor.RED, 9),
    LEGEND("Legend", 19, "Legend", "tag.legend", ChatColor.GOLD , 10),
    PARCEIRO("Parceiro", 20, "Parceiro", "tag.parceiro", ChatColor.DARK_PURPLE, 9),
    TITAN("Titan", 21, "Titan", "tag.titan", ChatColor.BLUE , 11),
    ELITE("Elite", 22, "Elite", "tag.elite", ChatColor.AQUA , 12),
    NITRO("Nitro", 23, "Nitro", "tag.nitro", ChatColor.LIGHT_PURPLE , 13),
    DEFAULT("Default", 24, "Default", "tag.default", ChatColor.GRAY, 14);

    private final String name;
    private final String permission;
    private final ChatColor color;
    private final int priority;
    private static final List<PlayerGroup> ROLES = new ArrayList<>();
    PlayerGroup(final String s, final int n, final String name, final String permission, final ChatColor color, final int priority) {
        this.name = name;
        this.permission = permission;
        this.color = color;
        this.priority = priority;
    }

    public String getName() {
        return this.name;
    }
    

    public String getPermission() {
        return this.permission;
    }

    public ChatColor getColor() {
        return this.color;
    }

    public String getColoredName() {
        return this.getColor() + this.getName();
    }

    public int getPriority() {
        return this.priority;
    }
    public static List<PlayerGroup> getRoles() {
        return ROLES;
    }

    public String getBoldColoredName() {
        return this.getColor() + "§l" + this.getName();
    }

    public static PlayerGroup getByName(final String name) {
        for (PlayerGroup group : PlayerGroup.values()) {
            if (group.name().equalsIgnoreCase(name)) {
                return group;
            }
        }
        return null;
    }

    public static PlayerGroup getGroup(final Player player) {
        for (PlayerGroup group : PlayerGroup.values()) {
            if (player.hasPermission(group.getPermission())) {
                return group;
            }
        }
        return PlayerGroup.DEFAULT;
    }

    public static String getPlayerNameWithGroup(Player player) {
        PlayerGroup group = getGroup(player);
        String prefix = group.getBoldColoredName().toUpperCase();
        return prefix + group.getColor() + " " + player.getName();
    }

}
