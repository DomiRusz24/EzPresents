package me.domirusz24.ezpresents.commands;

import me.domirusz24.ezpresents.MainPlugin;
import me.domirusz24.plugincore.PluginCore;
import me.domirusz24.plugincore.command.abstractclasses.BaseCommand;
import me.domirusz24.plugincore.config.annotations.Language;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionDefault;

public class EzpresentCommand extends BaseCommand {
    @Override
    public void selfExecute(CommandSender commandSender) {
        help(commandSender, false);
    }

    @Override
    protected String name() {
        return "ezpresent";
    }

    @Language("Commands.Ezpresent.Description")
    public static String LANG_DESCRIPTION = "Allows you to configure the plugin";

    @Override
    protected String description() {
        return LANG_DESCRIPTION;
    }

    @Override
    public PermissionDefault getPermissionDefault() {
        return PermissionDefault.OP;
    }

    @Override
    public PluginCore getCorePlugin() {
        return MainPlugin.plugin;
    }
}
