package me.domirusz24.ezpresents.main;

import me.domirusz24.plugincore.config.configvalue.ConfigItem;

public class RewardItem {

    private ConfigItem item;
    private int chance;

    public RewardItem(ConfigItem item, int chance) {
        this.item = item;
        this.chance = chance;
    }

    public ConfigItem getItem() {
        return item;
    }

    public int getChance() {
        return chance;
    }
}
