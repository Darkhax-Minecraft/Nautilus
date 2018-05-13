package net.darkhax.nautilus.test.item;

import java.awt.Color;

import net.darkhax.nautilus.client.item.IEnchantmentGlow;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Optional.Interface(modid = "nautilus", iface = "net.darkhax.nautilus.client.item.IEnchantmentGlow")
public class ItemGlowArmor extends ItemArmor implements IEnchantmentGlow {
    
    public ItemGlowArmor() {
        
        super(ArmorMaterial.IRON, 0, EntityEquipmentSlot.CHEST);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect (ItemStack stack) {
        
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    @Optional.Method(modid = "nautilus")
    public int getItemGlow (ItemStack stack, int originalColor) {
        
        return Color.green.darker().darker().getRGB();
    }
}