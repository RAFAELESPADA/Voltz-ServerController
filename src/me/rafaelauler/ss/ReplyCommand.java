package me.rafaelauler.ss;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Cancellable;
import net.md_5.bungee.api.plugin.Event;

public class PlayerTellEvent extends Event implements Cancellable {
    private String message;
    private boolean isCancelled;
    private ProxiedPlayer player;

    public PlayerTellEvent(String message, ProxiedPlayer player){
        this.message = message;
        this.isCancelled = false;
        this.player = player;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }
    
    public ProxiedPlayer getPlayer() {
        return player;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

   

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
