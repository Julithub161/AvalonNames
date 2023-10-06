package avalon.net.avalonnames;

import avalon.net.avalonnames.listener.ChatListener;
import avalon.net.avalonnames.listener.JoinListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class AvalonNames extends JavaPlugin {

    @Override
    public void onEnable() {
        initListener();
    }

    @Override
    public void onDisable() {

    }

    private void initListener() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new ChatListener(), this);
    }
}
