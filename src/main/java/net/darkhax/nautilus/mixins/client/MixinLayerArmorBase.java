package net.darkhax.nautilus.mixins.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;

@Mixin(LayerArmorBase.class)
public class MixinLayerArmorBase {
    
    @Inject(method = "renderEnchantedGlint(Lnet/minecraft/client/renderer/entity/RenderLivingBase;Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/client/model/ModelBase;FFFFFFF)V", at = @At(value = "INVOKE", target = "net.minecraft.client.renderer.GlStateManager.color(FFFF)V", ordinal = 1, shift = Shift.AFTER))
    private static void changeArmorGlowColor (CallbackInfo callback) {
        
        GlStateManager.color(0f, 0.8f, 0.6f, 1f);
    }
}