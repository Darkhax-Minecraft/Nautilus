package net.darkhax.nautilus.client.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IEnchantmentGlow {
    
    @SideOnly(Side.CLIENT)
    public int getItemGlow (ItemStack stack, int originalColor);
    
    @SideOnly(Side.CLIENT)
    public default int getEquippedGlow (ItemStack stack) {
        
        return this.getItemGlow(stack, -8372020);
    }
}
