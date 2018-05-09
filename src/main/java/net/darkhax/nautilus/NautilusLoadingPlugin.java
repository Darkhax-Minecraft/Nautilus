package net.darkhax.nautilus;

import java.util.Map;

import javax.annotation.Nullable;

import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
@IFMLLoadingPlugin.SortingIndex(-5000)
@IFMLLoadingPlugin.TransformerExclusions("net.darkhax.nautilus")
public class NautilusLoadingPlugin implements IFMLLoadingPlugin {
    
    public NautilusLoadingPlugin() {
        
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.nautilus.json");
    }
    
    @Override
    public String[] getASMTransformerClass () {
        
        return new String[0];
    }
    
    @Override
    public String getModContainerClass () {
        
        return null;
    }
    
    @Nullable
    @Override
    public String getSetupClass () {
        
        return null;
    }
    
    @Override
    public void injectData (Map<String, Object> data) {
        
    }
    
    @Override
    public String getAccessTransformerClass () {
        
        return null;
    }
}
