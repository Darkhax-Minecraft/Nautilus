package net.darkhax.nautilus.test;

import net.darkhax.bookshelf.registry.RegistryHelper;
import net.darkhax.nautilus.events.ItemDeathEvent;
import net.darkhax.nautilus.test.item.ItemGlowArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "nautilustest", name = "NautilusTest", version = "@VERSION@")
@EventBusSubscriber(modid = "nautilustest")
public class NautilusTest {
    
    private static final RegistryHelper REGISTRY = new RegistryHelper("nautilustest").setTab(CreativeTabs.MISC).enableAutoRegistration();
    
    @EventHandler
    public void onPreInit (FMLPreInitializationEvent event) {
        
        REGISTRY.registerItem(new ItemGlowArmor(), "glow_armor");
    }
    
    @SubscribeEvent
    public static void onItemKilled(ItemDeathEvent event) {
    	
    	final ItemStack item = event.getItemEntity().getItem();
    	
    	if (!item.isEmpty()) {
    		
    		if (event.getDamageSource().isFireDamage() && EnchantmentHelper.getEnchantmentLevel(Enchantments.FIRE_PROTECTION, item) > 0) {
    			
    			event.setCanceled(true);
    			event.getItemEntity().extinguish();
    		}
    		
    		else if (event.getDamageSource().isExplosion() && EnchantmentHelper.getEnchantmentLevel(Enchantments.BLAST_PROTECTION, item) > 0) {
    			
    			event.setCanceled(true);
    		}
    	}
    }
}