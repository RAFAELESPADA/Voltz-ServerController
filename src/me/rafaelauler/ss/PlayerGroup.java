package me.rafaelauler.ss;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum PlayerGroup {

    FUNDADOR("Fundador", 1, "Fundador", "tag.fundador", ChatColor.BLUE, 1),
    VOLTZMC("VoltzMC", 2, "VoltzMC", "tag.voltzmc", ChatColor.GOLD, 2),
    ADMIN("Admin", 3, "Admin", "tag.admin", ChatColor.DARK_RED, 3),
    SUPERVISOR("Supervisor", 4, "Supervisor", "tag.supervisor", ChatColor.RED, 4),
    MOD("Mod", 5, "Mod", "tag.mod", ChatColor.DARK_GREEN, 5),
    BUILDER("Construtor", 6, "Construtor", "tag.construtor", ChatColor.BLUE, 6),
    AJUDANTE("Ajudante", 7, "Ajudante", "tag.ajudante", ChatColor.YELLOW, 7),
    INVEST("Invest", 8, "Invest", "tag.invest", ChatColor.GREEN, 8),
    CREATORPLUS("Creator+", 9, "Creator+", "tag.creator+", ChatColor.BLUE, 9),
    CREATOR("Creator", 10, "Creator", "tag.creator", ChatColor.RED, 10),
    VIPPLUS("Vip+", 11, "Vip+", "tag.vip+", ChatColor.AQUA , 11),
    VIP("Vip", 12, "Vip", "tag.vip", ChatColor.GREEN , 12),
    APOIADOR("Apoiador", 13, "Apoiador", "tag.apoiador", ChatColor.DARK_PURPLE , 13),
    BOOSTER("Booster", 14, "Booster", "tag.booster", ChatColor.LIGHT_PURPLE , 14),
    MEMBRO("Membro", 23, "Membro", "tag.membro", ChatColor.GRAY, 16);

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
        return PlayerGroup.MEMBRO;
    }

    public static String getPlayerNameWithGroup(Player player) {
        PlayerGroup group = getGroup(player);
        String prefix = group.getBoldColoredName().toUpperCase();
        return prefix + group.getColor() + " " + player.getName();
    }

}
