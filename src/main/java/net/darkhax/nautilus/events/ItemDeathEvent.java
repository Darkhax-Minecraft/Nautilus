package net.darkhax.nautilus.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * This event is fired when an Item is killed using
 * {@link EntityItem#attackEntityFrom(DamageSource, float)}. If the event is canceled the
 * damage will not be applied and the item will continue to live.
 */
@Cancelable
public class ItemDeathEvent extends Event {

    /**
     * The item entity instance that has been destroyed.
     */
    private final EntityItem itemEntity;

    /**
     * The source of the damage.
     */
    private final DamageSource damageSource;

    /**
     * The amount of the damage.
     */
    private final float damageAmount;

    public ItemDeathEvent (EntityItem itemEntity, DamageSource damageSource, float damageAmount) {

        this.itemEntity = itemEntity;
        this.damageSource = damageSource;
        this.damageAmount = damageAmount;
    }

    /**
     * Gets the item entity that is being destroyed.
     *
     * @return The item entity that is being destroyed.
     */
    public EntityItem getItemEntity () {

        return this.itemEntity;
    }

    /**
     * Gets the damage source that attacked the item entity.
     *
     * @return The source of the damage.
     */
    public DamageSource getDamageSource () {

        return this.damageSource;
    }

    /**
     * Gets the amount of damage that was dealt to the entity.
     *
     * @return The amount of damage.
     */
    public float getDamageAmount () {

        return this.damageAmount;
    }
}
