package me.domirusz24.ezpresents.managers;

import me.domirusz24.plugincore.PluginCore;
import me.domirusz24.plugincore.core.placeholders.PlaceholderObject;
import me.domirusz24.ezpresents.MainPlugin;
import org.bukkit.entity.Player;

public class PAPIManager extends me.domirusz24.plugincore.managers.PAPIManager {
    public PAPIManager(PluginCore plugin) {
        super(plugin);
    }

    @Override
    protected String onPlaceholderRequest(String s, String s1) {
        return null;
    }

    @Override
    public String onPlaceholderRequest(Player player, String s) {
        return null;
    }

    public static String setPlaceholder(PlaceholderObject object, String text) {
        return MainPlugin.papiM.setPlaceholders(object, text);
    }
}
