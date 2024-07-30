package me.spzla.itemnames;

import me.spzla.itemnames.ModConfig;
import net.fabricmc.api.ClientModInitializer;

public class ItemNames implements ClientModInitializer {
    public static final String MOD_ID = "itemnames";

    @Override
    public void onInitializeClient() {
        getConfig().load();
    }
    
    public static ModConfig getConfig() {
        return ModConfig.INSTANCE;
    }
}
