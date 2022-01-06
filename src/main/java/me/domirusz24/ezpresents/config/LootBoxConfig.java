package me.domirusz24.ezpresents.config;

import me.domirusz24.ezpresents.MainPlugin;
import me.domirusz24.ezpresents.main.LootBox;
import me.domirusz24.ezpresents.main.RewardItem;
import me.domirusz24.plugincore.PluginCore;
import me.domirusz24.plugincore.config.AbstractConfig;
import me.domirusz24.plugincore.config.configvalue.ConfigItem;
import me.domirusz24.plugincore.managers.ConfigManager;
import org.bukkit.configuration.ConfigurationSection;

import java.io.File;
import java.util.HashMap;
import java.util.stream.Collectors;

public class LootBoxConfig extends AbstractConfig {

    private HashMap<String, LootBox> LOOT_BOX_BY_ID;

    public LootBoxConfig(File file, PluginCore plugin, ConfigManager manager) {
        super(file, plugin, manager);
    }

    public LootBoxConfig(String path, PluginCore plugin, ConfigManager manager) {
        super(path, plugin, manager);
    }

    public LootBoxConfig(String path, PluginCore plugin) {
        super(path, plugin);
    }

    public LootBoxConfig(File file, PluginCore plugin) {
        super(file, plugin);
    }

    public HashMap<String, LootBox> getLootBoxes() {
        return LOOT_BOX_BY_ID;
    }

    @Override
    public void _reload() {
        if (LOOT_BOX_BY_ID == null) LOOT_BOX_BY_ID = new HashMap<>();
        for (String id : getKeys(false)) {
            if (!contains(id)) {
                LOOT_BOX_BY_ID.remove(id);
                continue;
            }
            if (LOOT_BOX_BY_ID.containsKey(id)) {
                for (RewardItem i : LOOT_BOX_BY_ID.get(id).getRewards().keySet()) {
                    if (!isSet(id + ".drops." + i.getItem().getPath())) {
                        LOOT_BOX_BY_ID.get(id).getRewards().remove(i);
                    }
                }
            } else {
                LOOT_BOX_BY_ID.put(
                        id,
                        new LootBox(
                                MainPlugin.configM.getItemConfig().getItemFromID(getString(id + ".box")),
                                getConfigurationSection(id + ".drops")
                                        .getKeys(false).stream()
                                        .map((drop) -> new RewardItem(MainPlugin.configM.getItemConfig().getItemFromID(drop), getInt(id + ".drops." + drop)))
                                        .collect(Collectors.toList())
                        )
                );
            }
        }
    }

    @Override
    protected boolean autoGenerate() {
        return true;
    }
}
