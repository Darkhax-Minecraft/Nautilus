package net.darkhax.nautilus.client.item;

import net.minecraft.item.ItemStack;

public interface IEnchantmentGlow {
    
    public int getItemGlow (ItemStack stack, int originalColor);
    
    public default int getEquippedGlow (ItemStack stack) {
        
        return this.getItemGlow(stack, -8372020);
    }
}
