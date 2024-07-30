package me.spzla.itemnames;

import me.spzla.itemnames.ModConfig;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemNames implements ClientModInitializer {
    public static final String MOD_ID = "itemnames";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        getConfig().load();
    }
    
    public static ModConfig getConfig() {
        return ModConfig.INSTANCE;
    }
}
