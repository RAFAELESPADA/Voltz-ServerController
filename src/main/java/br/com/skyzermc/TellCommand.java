package br.com.skyzermc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TellCommand extends Command {
  public static final Map<ProxiedPlayer, ProxiedPlayer> lastMessageMap = new HashMap<ProxiedPlayer, ProxiedPlayer>();

  private final Map<ProxiedPlayer, Boolean> telloff;
  
  public TellCommand() {
    super("tell", "", new String[] { "msg", "w" });
    
    this.telloff = new HashMap<>();
  }
  
  public void execute(CommandSender sender, String[] args) {
    if (!(sender instanceof ProxiedPlayer)) {
      sender.sendMessage(TextComponent.fromLegacyText("§cApenas jogadores podem fazer isso."));
      return;
    } 
    ProxiedPlayer player = (ProxiedPlayer)sender;

    if (args.length == 0) {
        sender.sendMessage(TextComponent.fromLegacyText("§cComando incorreto. Use /tell <player> <mensagem>."));
        return;
      }
    if (args[0].equals("off") && !telloff.containsKey(player)) {
        telloff.put(player, true);
        player.sendMessage(TextComponent.fromLegacyText("§cTell desativado"));
    	return;
      }
    else     if (args[0].equals("off") && telloff.containsKey(player)) {

        player.sendMessage(TextComponent.fromLegacyText("§cSeu tell já está desativado"));
        return;
    }
    else if (args[0].equals("on") && telloff.containsKey(player)) {
        telloff.remove(player);
        player.sendMessage(TextComponent.fromLegacyText("§aTell ativado"));
    	return;
      }
    else     if (args[0].equals("on") && !telloff.containsKey(player)) {

        player.sendMessage(TextComponent.fromLegacyText("§cSeu tell já está ativado"));
        return;
    }
    if (args.length < 2) {
        sender.sendMessage(TextComponent.fromLegacyText("§cComando incorreto. Use /tell <player> <mensagem>."));
        return;
      }
    String targetPlayerName = args[0];
    String message = String.join(" ", Arrays.<CharSequence>copyOfRange((CharSequence[])args, 1, args.length));
    if (targetPlayerName.equalsIgnoreCase(player.getName())) {
      sender.sendMessage(TextComponent.fromLegacyText("§cVocê não pode mandar mensagem para você mesmo."));
      return;
    } 
    ProxiedPlayer targetPlayer = ProxyServer.getInstance().getPlayer(targetPlayerName);
    if (targetPlayer == null) {
      sender.sendMessage(TextComponent.fromLegacyText("§cEsse jogador está offline."));
      return;
    } 
    if (telloff.containsKey(targetPlayer)) {
    	sender.sendMessage(TextComponent.fromLegacyText("§c" + targetPlayer.getName() + " desativou o recebimento de mensagens privadas"));
        return;
    }
    targetPlayer.sendMessage(TextComponent.fromLegacyText("§c§lTELL RECEBIDO §7" + player.getName() + ": §f" + message));
    sender.sendMessage(TextComponent.fromLegacyText("§c§lTELL ENVIADO §7" + targetPlayer.getName() + ": §f" + message));
   lastMessageMap.put(player, targetPlayer);
    lastMessageMap.put(targetPlayer, player);
  }
  
  public static ProxiedPlayer getLastMessageRecipient(ProxiedPlayer player) {
    return lastMessageMap.get(player);
  }
}
