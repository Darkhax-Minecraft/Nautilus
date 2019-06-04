# Nautilus
Nautilus is a core mod that modifies the base game to add various hooks and events for other mods to take advantage of. These modifications are done to the base game using the [Mixin framework](https://github.com/SpongePowered/Mixin)

## API Features

- Items can control their enchantment color using the [IEnchantmentGlow](https://github.com/Darkhax-Minecraft/Nautilus/blob/master/src/main/java/net/darkhax/nautilus/client/item/IEnchantmentGlow.java) interface. You can find an example of implementation [here](https://github.com/Darkhax-Minecraft/Nautilus/blob/master/src/test/java/net/darkhax/nautilus/test/item/ItemGlowArmor.java).

## Events

- ItemDeathEvent - This event is fired when an EntityItem would be destroyed from damage. This event can be canceled, which will prevent the item from being destroyed. [Example](https://github.com/Darkhax-Minecraft/Nautilus/blob/31720d7976a4a9038daaab33d1a8e0b3c90939fe/src/test/java/net/darkhax/nautilus/test/NautilusTest.java#L28-L46).

## Development

If you are working with this mod in a dev environment you may need to specify the loading plugin in your VM arguments.
```
-Dfml.coreMods.load=net.darkhax.nautilus.NautilusLoadingPlugin
```

## New Features

If you would like a new API feature or an event to be added, please open a Pull Request or issue. 