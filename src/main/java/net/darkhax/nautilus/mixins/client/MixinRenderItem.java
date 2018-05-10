
package net.darkhax.nautilus.mixins.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.darkhax.nautilus.client.item.IEnchantmentGlow;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.item.ItemStack;

@Mixin(RenderItem.class)
public class MixinRenderItem {
    
    private ItemStack lastItemRendered = ItemStack.EMPTY;
    
    @Inject(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/IBakedModel;)V", at = @At("HEAD"))
    private void onItemRendered (ItemStack stack, IBakedModel model, CallbackInfo callback) {
        
        this.lastItemRendered = stack;
    }
    
    @ModifyConstant(method = "renderEffect(Lnet/minecraft/client/renderer/block/model/IBakedModel;)V", constant = @Constant(intValue = -8372020))
    private int modifyGlowColor (int originalColor) {
        
        if (!this.lastItemRendered.isEmpty() && this.lastItemRendered.getItem() instanceof IEnchantmentGlow) {
            
            return ((IEnchantmentGlow) this.lastItemRendered.getItem()).getItemGlow(this.lastItemRendered, originalColor);
        }
        
        return originalColor;
    }
}