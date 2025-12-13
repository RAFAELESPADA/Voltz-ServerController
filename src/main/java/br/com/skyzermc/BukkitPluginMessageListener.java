package br.com.skyzermc;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

public class BukkitPluginMessageListener implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String command = in.readUTF();
        if (command == null) {
            return;
        }
        if (channel.equals("skyzermc:pm")) {
        	
        }
    }


}

