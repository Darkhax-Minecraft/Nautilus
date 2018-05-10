package net.darkhax.nautilus.mixins.common;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemClock;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

@Mixin(DamageSource.class)
public class MixinDamageSource {
    
    private static DamageSource causePlayerDamage (EntityPlayer player) {
        
        if (player.getHeldItemMainhand().getItem() instanceof ItemClock) {
            
            return DamageSource.IN_FIRE;
        }
        
        return new EntityDamageSource("player", player);
    }
}
