package net.darkhax.nautilus.mixins.common;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;

@Mixin(ItemShears.class)
public class MixinItemShears extends Item {
    
    @Override
    public int getItemEnchantability () {
        
        return 14;
    }
}
