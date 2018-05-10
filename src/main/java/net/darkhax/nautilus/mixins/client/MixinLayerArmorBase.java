package net.darkhax.nautilus.mixins.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.darkhax.nautilus.client.item.IEnchantmentGlow;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

@Mixin(LayerArmorBase.class)
public class MixinLayerArmorBase {
    
    private static ItemStack lastArmor = ItemStack.EMPTY;
    
    @Inject(method = "renderArmorLayer(Lnet/minecraft/entity/EntityLivingBase;FFFFFFFLnet/minecraft/inventory/EntityEquipmentSlot;)V", at = @At(value = "INVOKE_ASSIGN", target = "getItemStackFromSlot(Lnet/minecraft/inventory/EntityEquipmentSlot;)Lnet/minecraft/item/ItemStack;"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void onArmorRendered (EntityLivingBase entityLivingBaseIn, float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7, EntityEquipmentSlot slotIn, CallbackInfo ci, ItemStack itemstack) {
        
        lastArmor = itemstack;
    }
    
    @Inject(method = "renderEnchantedGlint(Lnet/minecraft/client/renderer/entity/RenderLivingBase;Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/client/model/ModelBase;FFFFFFF)V", at = @At(value = "INVOKE", target = "net.minecraft.client.renderer.GlStateManager.color(FFFF)V", ordinal = 1, shift = Shift.AFTER))
    private static void changeArmorGlowColor (CallbackInfo callback) {
        
        if (!lastArmor.isEmpty() && lastArmor.getItem() instanceof IEnchantmentGlow) {
            
            final int i = ((IEnchantmentGlow) lastArmor.getItem()).getEquippedGlow(lastArmor);
            final float red = (i >> 16 & 255) / 255.0F;
            final float green = (i >> 8 & 255) / 255.0F;
            final float blue = (i & 255) / 255.0F;
            GlStateManager.color(red, green, blue, 1f);
        }
    }
}