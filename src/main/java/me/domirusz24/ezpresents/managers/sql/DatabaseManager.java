package me.domirusz24.ezpresents.managers.sql;

import me.domirusz24.plugincore.managers.database.DataBaseTable;
import me.domirusz24.plugincore.managers.database.PlayerDataBaseTable;
import me.domirusz24.plugincore.managers.database.values.DataBaseValue;
import me.domirusz24.ezpresents.MainPlugin;

public class DatabaseManager {

    public static PlayerDataBaseTable player;

    public static DataBaseTable[] getTables() {
        player = new PlayerDataBaseTable(MainPlugin.SqlM) {
            @Override
            public DataBaseValue<?>[] _getValues() {
                return new DataBaseValue[0];
            }

            @Override
            public String getName() {
                return "player_data";
            }
        };
        return new DataBaseTable[]{
                player
        };
    }
}