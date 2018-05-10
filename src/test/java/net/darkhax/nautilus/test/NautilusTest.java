package net.darkhax.nautilus.test;

import net.darkhax.bookshelf.registry.RegistryHelper;
import net.darkhax.nautilus.test.item.ItemGlowArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "nautilustest", name = "NautilusTest", version = "@VERSION@")
public class NautilusTest {
    
    private static final RegistryHelper REGISTRY = new RegistryHelper("nautilustest").setTab(CreativeTabs.MISC).enableAutoRegistration();
    
    @EventHandler
    public void onPreInit (FMLPreInitializationEvent event) {
        
        REGISTRY.registerItem(new ItemGlowArmor(), "glow_armor");
    }
}