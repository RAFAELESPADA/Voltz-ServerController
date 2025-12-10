package me.rafaelauler.ss;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum PlayerGroup {

    DIRETOR("Diretor", 1, "Diretor", "tag.diretor", ChatColor.GOLD, 1),
    GERENTE("Gerente", 2, "Gerente", "tag.gerente", ChatColor.DARK_PURPLE, 2),
    PATROCINADOR("Patrocinador", 3, "Patrocinador", "tag.patrocinador", ChatColor.GREEN , 11),
    ADMIN("Administrador", 4, "Administrador", "tag.admin", ChatColor.DARK_RED, 3),       
    SENIORMOD("SeniorMod", 5, "SeniorMod", "tag.seniormod", ChatColor.DARK_AQUA, 5),
    CONSTRUTOR("Construtor", 6, "Construtor", "tag.construtor", ChatColor.LIGHT_PURPLE, 6),
    MOD("Moderador", 7, "Moderador", "tag.mod", ChatColor.DARK_GREEN, 7),
    AJUDANTE("Ajudante", 8, "Ajudante", "tag.ajudante", ChatColor.YELLOW, 8),
    INFLUENCER("Influencer", 9, "Influencer", "tag.influencer", ChatColor.RED, 9),
    LEGEND("Legend", 10, "Legend", "tag.legend", ChatColor.GOLD , 10),
    TITAN("Titan", 11, "Titan", "tag.titan", ChatColor.BLUE , 11),
    ELITE("Elite", 12, "Elite", "tag.elite", ChatColor.AQUA , 12),
    NITRO("Nitro", 13, "Nitro", "tag.nitro", ChatColor.LIGHT_PURPLE , 13),
    DEFAULT("Default", 14, "Default", "tag.default", ChatColor.GRAY, 14);

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
