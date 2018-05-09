package net.darkhax.nautilus.mixins.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

@Mixin(ItemHoe.class)
public abstract class MixinItemHoe extends Item {
    
    @Shadow
    protected Item.ToolMaterial toolMaterial;
    
    @Override
    public int getItemEnchantability () {
        
        return this.toolMaterial.getEnchantability();
    }
}