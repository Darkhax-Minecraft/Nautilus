package net.darkhax.nautilus.client.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This interface can be implemented by an Item to allow changing the enchantment glow. You can
 * use the net.minecraftforge.fml.common.Optional annotations to only have a soft dependency
 * for this feature.
 */
public interface IEnchantmentGlow {

    /**
     * Gets the color of the enchantment glow as a packed ARGB integer.
     *
     * @param stack The ItemStack to get the glow color for.
     * @param originalColor The original color that was used for this.
     * @return The color to use for this item.
     */
    @SideOnly(Side.CLIENT)
    public int getItemGlow (ItemStack stack, int originalColor);

    /**
     * Gets the color of the enchantment glow on an equipped piece of armor. By default this
     * will use the same color as the item from {@link #getItemGlow(ItemStack, int)}.
     *
     * @param stack The ItemStack to get the glow color for.
     * @return The color to use for this item.
     */
    @SideOnly(Side.CLIENT)
    public default int getEquippedGlow (ItemStack stack) {

        return this.getItemGlow(stack, -8372020);
    }
}
