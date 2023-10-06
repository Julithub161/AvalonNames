package avalon.net.avalonnames.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        e.setFormat("§7" + e.getPlayer().getDisplayName() + " §8» §f" + e.getMessage());
    }
}
