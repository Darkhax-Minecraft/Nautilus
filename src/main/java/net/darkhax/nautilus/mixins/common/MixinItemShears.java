package net.darkhax.nautilus.mixins.common;

import org.spongepowered.asm.mixin.Mixin;

import net.darkhax.nautilus.ConfigurationHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;

@Mixin(ItemShears.class)
public class MixinItemShears extends Item {
    
    @Override
    public int getItemEnchantability () {
        
        return ConfigurationHandler.enchantableShears ? ToolMaterial.IRON.getEnchantability() : super.getItemEnchantability();
    }
}
