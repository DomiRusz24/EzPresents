package me.domirusz24.ezpresents;

import com.comphenix.protocol.ProtocolManager;
import com.onarandombox.MultiverseCore.MultiverseCore;
import me.domirusz24.ezpresents.commands.EzpresentCommand;
import me.domirusz24.ezpresents.config.LootBoxConfig;
import me.domirusz24.ezpresents.managers.sql.DatabaseManager;
import me.domirusz24.plugincore.CoreListener;
import me.domirusz24.plugincore.PluginCore;
import me.domirusz24.plugincore.command.GetItemCommand;
import me.domirusz24.plugincore.command.ReloadSubCommand;
import me.domirusz24.plugincore.core.players.PlayerData;
import me.domirusz24.plugincore.managers.*;
import me.domirusz24.plugincore.managers.database.*;
import me.domirusz24.plugincore.util.UtilMethods;
import org.bukkit.Bukkit;

import java.util.UUID;

public final class MainPlugin extends PluginCore {

    public static MainPlugin plugin;

    // ***********************
    public static MultiverseCore multiverse = null;
    public static ProtocolManager protocol = null;

    public static DataBaseManager SqlM;
    public static ConfigManager configM;
    public static CommandManager commandM;
    public static GUIManager guiM;
    public static RegionManager regionM;
    public static WorldEditManager worldEditM;
    public static ChatGUIManager chatGuiM;
    public static ScoreboardManager boardM;
    public static me.domirusz24.plugincore.managers.ProtocolManager nmsM;
    public static SignManager signM;
    public static PAPIManager papiM;
    public static PlayerDataManager playerDataM;

    public static UtilMethods util;

    public static CoreListener listener;
    public static LootBoxConfig lootBoxConfig;

    protected void __loadDependencies() {
        multiverse = super.multiverse;
        protocol = super.protocol;
    }

    protected void __loadManagers() {
        util = new me.domirusz24.ezpresents.util.UtilMethods(super.util);
        SqlM = super.SqlM;
        configM = super.configM;
        commandM = super.commandM;
        guiM = super.guiM;
        regionM = super.regionM;
        worldEditM = super.worldEditM;
        chatGuiM = super.chatGuiM;
        boardM = super.boardM;
        nmsM = super.nmsM;
        signM = super.signM;
        papiM = super.papiM;
        playerDataM = super.playerDataM;
    }


    private void __registerEvents() {
        listener = super.listener;
    }

    @Override
    protected void _initialize() {
        plugin = this;
    }

    @Override
    protected void _loadDependencies() {
        __loadDependencies();
    }

    @Override
    protected String databasePrefix() {
        return "ezpresents";
    }

    @Override
    public String packageName() {
        return "me.domirusz24.ezpresents";
    }

    @Override
    public DataBaseTable[] getTables() {
        return DatabaseManager.getTables();
    }

    @Override
    protected PAPIManager papiManager() {
        return new me.domirusz24.ezpresents.managers.PAPIManager(this);
    }

    @Override
    protected void loadConfigs() {
        configM = super.configM;
        lootBoxConfig = new LootBoxConfig("LootBoxs.yml", this);
    }

    @Override
    public void sqlLoad() {
        SqlM = super.SqlM;
    }

    @Override
    protected void _loadManagers() {
        __loadManagers();
    }

    @Override
    protected void _loadCommands() {
        commandM = super.commandM;

        commandM.registerCommand(
                new EzpresentCommand()
                        .addSubCommand(new ReloadSubCommand(this))
                        .addSubCommand(new GetItemCommand(this))
        );
    }

    @Override
    protected void _registerEvents() {
        __registerEvents();
        Bukkit.getServer().getPluginManager().registerEvents(new MainListener(), this);
    }

    @Override
    protected void _disable() {

    }

    @Override
    protected void _shutOffPlugin() {

    }

    @Override
    public PlayerData registerPlayer(String s, UUID uuid) {
        return null;
    }
    // ***********************
}
