package me.domirusz24.ezpresents;

import me.domirusz24.ezpresents.main.LootBox;
import me.domirusz24.ezpresents.util.UtilMethods;
import me.domirusz24.plugincore.config.annotations.Language;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class MainListener implements Listener {

    @Language("GotItem")
    public static String LANG_GOT_ITEM = "§7You've obtained §l%count% §r§7\"§r%item%§r§7\"!";

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getHand() == EquipmentSlot.OFF_HAND) return;
        if (!event.getPlayer().isSneaking()) return;
        if (event.getPlayer().getInventory().getItemInMainHand() == null || event.getPlayer().getInventory().getItemInMainHand().getType() == Material.AIR) return;
        for (LootBox item : MainPlugin.lootBoxConfig.getLootBoxes().values()) {
            if (UtilMethods.compareItems(item.getBox().getValue(), event.getPlayer().getInventory().getItemInMainHand())) {
                event.getPlayer().getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
                ItemStack s = item.randomItem().getItem().getValue();
                event.getPlayer().sendMessage(LANG_GOT_ITEM
                        .replaceAll("%count%", String.valueOf(s.getAmount()))
                        .replaceAll("%item%", s.getItemMeta() == null || s.getItemMeta().getDisplayName() == null ? UtilMethods.makeItNice(s.getType().name()) : s.getItemMeta().getDisplayName())
                );
                event.getPlayer().getInventory().addItem(s);
            }
        }
    }
}
