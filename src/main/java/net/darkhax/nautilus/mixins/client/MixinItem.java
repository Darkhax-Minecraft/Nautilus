package net.darkhax.nautilus.mixins.client;

import org.spongepowered.asm.mixin.Mixin;

import net.darkhax.nautilus.client.item.IEnchantmentGlow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mixin(Item.class)
public class MixinItem implements IEnchantmentGlow {
    
    @Override
    public int getItemGlow (ItemStack stack, int originalColor) {
        
        return originalColor;
    }
}
