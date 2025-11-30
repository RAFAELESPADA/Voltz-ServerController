package me.rafaelauler.ss;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum PlayerGroup {

    DIRETOR("Lyze", 1, "Diretor", "tag.diretor", ChatColor.GOLD, 1),
    GERENTE("Gerente", 2, "Gerente", "tag.gerente", ChatColor.DARK_PURPLE, 2),
    ADMIN("Administrador", 3, "Admin", "tag.admin", ChatColor.DARK_RED, 3),
    CONSTRUTOR("Construtor", 4, "Construtor", "tag.construtor", ChatColor.LIGHT_PURPLE, 4),
    MOD("Moderador", 5, "Mod", "tag.mod", ChatColor.DARK_GREEN, 5),
    AJUDANTE("Ajudante", 6, "Ajudante", "tag.ajudante", ChatColor.YELLOW, 6),
    INFLUENCER("Youtuber", 7, "Creator", "tag.influencer", ChatColor.RED, 7),
    BETA("Beta", 8, "Beta", "tag.beta", ChatColor.DARK_BLUE , 8),
    LORD("Lord", 9, "Lord", "tag.lord", ChatColor.AQUA , 9),
    KNIGHT("Knight", 10, "Knight", "tag.knight", ChatColor.DARK_AQUA , 10),
    HUNTER("Hunter", 11, "Hunter", "tag.hunter", ChatColor.DARK_PURPLE , 11),
    NITRO("Nitro", 12, "Nitro", "tag.nitro", ChatColor.LIGHT_PURPLE , 12),
    DEFAULT("Default", 13, "Membro", "tag.membro", ChatColor.GRAY, 13);

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
