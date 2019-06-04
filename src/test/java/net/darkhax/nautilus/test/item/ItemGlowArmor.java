package net.darkhax.nautilus.test.item;

import java.awt.Color;

import net.darkhax.nautilus.client.item.IEnchantmentGlow;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

// Forge's Optional interface will remove this interface if the nautilus lib is not installed.
// This interface is not required. It just allows a soft dep on Nautilus.
@Optional.Interface(modid = "nautilus", iface = "net.darkhax.nautilus.client.item.IEnchantmentGlow")
public class ItemGlowArmor extends ItemArmor implements IEnchantmentGlow {

    public ItemGlowArmor () {

        super(ArmorMaterial.IRON, 0, EntityEquipmentSlot.CHEST);
    }

    // This is a vanilla method. It makes the item always have an enchantment glow for test
    // purposes.
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect (ItemStack stack) {

        return true;
    }

    // Changes the color of the glow to a dark green.
    // Like the optional interface at the top of the class, this one allows soft dependencies.
    @Override
    @SideOnly(Side.CLIENT)
    @Optional.Method(modid = "nautilus")
    public int getItemGlow (ItemStack stack, int originalColor) {

        return Color.green.darker().darker().getRGB();
    }
}