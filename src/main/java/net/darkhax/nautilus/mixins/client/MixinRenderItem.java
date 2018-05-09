
package net.darkhax.nautilus.mixins.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.darkhax.nautilus.Nautilus;
import net.minecraft.client.renderer.RenderItem;

@Mixin(RenderItem.class)
public class MixinRenderItem {
    
    @ModifyConstant(method = "renderEffect(Lnet/minecraft/client/renderer/block/model/IBakedModel;)V", constant = @Constant(intValue = -8372020))
    private int modifyGlowColor (int originalColor) {
        
        return Nautilus.call(originalColor);
    }
}
