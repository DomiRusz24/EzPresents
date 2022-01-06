package me.domirusz24.ezpresents.main;

import me.domirusz24.ezpresents.main.RewardItem;
import me.domirusz24.ezpresents.util.UtilMethods;
import me.domirusz24.plugincore.config.configvalue.ConfigItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LootBox {
    private ConfigItem box;
    private final HashMap<RewardItem, Double> rewards = new HashMap<>();

    public LootBox(ConfigItem box, List<RewardItem> rewards) {
        this.box = box;
        rewards.forEach((r) -> this.rewards.put(r, (double) r.getChance()));
    }

    public ConfigItem getBox() {
        return box;
    }

    public HashMap<RewardItem, Double> getRewards() {
        return rewards;
    }

    public Random random = new Random();

    public RewardItem randomItem() {
        return UtilMethods.getWeightedRandom(rewards, random);
    }
}
