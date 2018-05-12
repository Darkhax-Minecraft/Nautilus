package net.darkhax.nautilus;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {
    
    private static final String CATEGORY_TWEAKS = "tweaks";
    
    public static boolean enchantableHoes = true;
    public static boolean enchantableShears = true;
    public static boolean leadableUndeadHorses = true;
    
    private final Configuration config;
    
    public ConfigurationHandler(File file) {
        
        this.config = new Configuration(file);
        
        this.config.setCategoryComment(CATEGORY_TWEAKS, "Tweaks made to the vanilla game. These are made to imrpove compatability with other mods.");
        
        this.syncConfigData();
    }
    
    private void syncConfigData () {
        
        enchantableHoes = this.config.getBoolean("enchantable_hoes", CATEGORY_TWEAKS, true, "Allows hoes to be enchanted at an enchantment table.");
        enchantableShears = this.config.getBoolean("enchantable_shears", CATEGORY_TWEAKS, true, "Allows shears to be enchanted at an enchantment table.");
        leadableUndeadHorses = this.config.getBoolean("leadable_undead_horses", CATEGORY_TWEAKS, true, "Allows zombie and skeleton horses to be moved with leads.");
        
        if (this.config.hasChanged()) {
            this.config.save();
        }
    }
}