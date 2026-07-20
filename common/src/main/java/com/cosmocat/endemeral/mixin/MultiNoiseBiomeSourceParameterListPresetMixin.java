package com.cosmocat.endemeral.mixin;

import com.cosmocat.endemeral.worldgen.EndemeralMultiNoiseBiomeSourceParameterLists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(MultiNoiseBiomeSourceParameterList.Preset.class)
public abstract class MultiNoiseBiomeSourceParameterListPresetMixin {
    @Shadow
    public static Map<ResourceLocation, MultiNoiseBiomeSourceParameterList.Preset> BY_NAME;

    static {
        BY_NAME.put(EndemeralMultiNoiseBiomeSourceParameterLists.Presets.END.id(), EndemeralMultiNoiseBiomeSourceParameterLists.Presets.END);
    }
}
