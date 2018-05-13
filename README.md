# Nautilus
Nautilus is a core mod which modifies the base game to add hooks and features for other mods to take advantage of. These modifications are done to the base game using the [Mixin framework](https://github.com/SpongePowered/Mixin)

## Tweaks
In Nautilus, a tweak refers to any change to the base game that does not directly expand the API. These are features that aim to improve the experience of the game and other mods by making vanilla content more modded friendly. You will always be able to disable tweaks in the configuration for this mod. Other mods should never rely on tweaks being enabled. 

- Hoes can be enchanted using an enchantment table. They have the enchatability of their material type. This is to improve accessibility of hoe enchantments.
- Shears can be enchanted at enchantment tables. They have the enchantability of Iron. This is to improve accessibility of shear enchantments.
- Skeleton and Zombie horses can be moved around with leads. This allows for these horses to be used in mods like [Horse Power](https://minecraft.curseforge.com/projects/horse-power).
 
## API Features
In Nautilus, an API feature is a change to the base game that expands upon what is already possible, but does not change the vanilla mechanics on it's own. These features can not be disabled by the player, and mods may depend on these features to function. 

Items can control their enchantment glow color using the [IEnchantmentGlow](https://github.com/Darkhax-Minecraft/Nautilus/blob/master/src/main/java/net/darkhax/nautilus/client/item/IEnchantmentGlow.java) interface. You can find an example of implementation [here](https://github.com/Darkhax-Minecraft/Nautilus/blob/master/src/test/java/net/darkhax/nautilus/test/item/ItemGlowArmor.java).
 
## Development

If you are working with this mod's source in a dev environment, the core plugin needs to be specified in the VM arguments.

```
-Dfml.coreMods.load=net.darkhax.nautilus.NautilusLoadingPlugin
```