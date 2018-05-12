package net.darkhax.nautilus;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "nautilus", name = "Nautilus", version = "@VERSION@")
public class Nautilus {
    
    @EventHandler
    public void onPreInit (FMLPreInitializationEvent event) {
        
        new ConfigurationHandler(event.getSuggestedConfigurationFile());
    }
}