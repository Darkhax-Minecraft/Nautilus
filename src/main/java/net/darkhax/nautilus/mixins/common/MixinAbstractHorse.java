package net.darkhax.nautilus.mixins.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.darkhax.nautilus.ConfigurationHandler;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;

@Mixin(AbstractHorse.class)
public abstract class MixinAbstractHorse extends EntityAnimal {
    
    public MixinAbstractHorse() {
        
        super(null);
    }
    
    @Inject(method = "canBeLeashedTo(Lnet/minecraft/entity/player/EntityPlayer;)Z", at = @At("HEAD"), cancellable = true)
    public void onCanBeLeashedTo (EntityPlayer player, CallbackInfoReturnable<Boolean> info) {
        
        if (ConfigurationHandler.leadableUndeadHorses && this.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
            
            info.setReturnValue(super.canBeLeashedTo(player));
        }
    }
}