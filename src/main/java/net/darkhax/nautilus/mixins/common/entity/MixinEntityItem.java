package net.darkhax.nautilus.mixins.common.entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.darkhax.nautilus.events.ItemDeathEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

@Mixin(EntityItem.class)
public abstract class MixinEntityItem extends Entity {

	public MixinEntityItem() {
		
		super(null);
	}

    @Inject(method = "attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z", at = @At("HEAD"), cancellable = true)
    public void attackEntityFrom (DamageSource source, float amount, CallbackInfoReturnable<Boolean> info) {
        
    	if (!this.isDead && MinecraftForge.EVENT_BUS.post(new ItemDeathEvent((EntityItem) (Object) this, source, amount))) {
    		
    		info.setReturnValue(false);
    	}
    }
}
