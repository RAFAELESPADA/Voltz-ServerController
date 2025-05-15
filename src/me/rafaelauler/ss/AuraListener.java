package me.rafaelauler.ss;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import dev.aurelium.auraskills.api.event.skill.XpGainEvent;

public class AuraListener implements Listener {



@EventHandler
public void event(XpGainEvent e) {
	if (Bukkit.getPluginManager().isPluginEnabled("AuraSkills")) {
    if (!(e.getPlayer().getWorld().equals(Bukkit.getWorld("spawn")))) {
		return;
    }
    if (e.getPlayer().getLocation().getX() < 200) {
	e.setCancelled(true);
}
	}
}
}
