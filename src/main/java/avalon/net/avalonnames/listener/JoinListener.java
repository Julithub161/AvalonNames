package avalon.net.avalonnames.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JoinListener implements Listener {
    String prefix;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String color;
        if(p.hasPermission("group.owner")) {
            color = "§4";
            prefix = "§4Owner§7 » ";
        } else if(p.hasPermission("group.admin")) {
            color = "§4";
            prefix = "§4Admin§7 » ";
        } else if(p.hasPermission("group.srdeveloper")) {
            color = "§b";
            prefix = "§bSr.Dev§7 » ";
        } else if(p.hasPermission("group.srmoderator")) {
            color = "§c";
            prefix = "§cSr.Mod§7 » ";
        } else if(p.hasPermission("group.srbuilder")) {
            color = "§a";
            prefix = "§aSr.Build§7 » ";
        } else if(p.hasPermission("group.developer")) {
            color = "§b";
            prefix = "§bDev§7 » ";
        } else if(p.hasPermission("group.moderator")) {
            color = "§c";
            prefix = "§cMod§7 » ";
        } else if(p.hasPermission("group.supporter")) {
            color = "§9";
            prefix = "§9Support§7 » ";
        } else if(p.hasPermission("group.builder")) {
            color = "§a";
            prefix = "§aBuilder§7 » ";
        } else {
            color = "§7";
            prefix = "§7";
        }
        setTablist();
        p.setDisplayName(color + p.getName() + "§7");
        p.setCustomName(prefix + p.getName() + "§7");
    }

    private void setTablist() {
        List<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        onlinePlayers.sort(Comparator.comparing(p -> {
            if(p.hasPermission("group.owner")) {
                return "group.owner";
            } else if(p.hasPermission("group.admin")) {
                return "group.admin";
            } else if(p.hasPermission("group.srdeveloper")) {
                return "group.srdeveloper";
            } else if(p.hasPermission("group.srmoderator")) {
                return "group.srmoderator";
            } else if(p.hasPermission("group.srbuilder")) {
                return "group.srbuilder";
            } else if(p.hasPermission("group.developer")) {
                return "group.developer";
            } else if(p.hasPermission("group.moderator")) {
                return "group.moderator";
            } else if(p.hasPermission("group.supporter")) {
                return "group.supporter";
            } else if(p.hasPermission("group.builder")) {
                return "group.builder";
            }
            return "";
        }));

        for (int i = 0; i < onlinePlayers.size(); i++) {
            Player p = onlinePlayers.get(i);
            p.setPlayerListName(prefix + p.getName());
        }
    }
}
