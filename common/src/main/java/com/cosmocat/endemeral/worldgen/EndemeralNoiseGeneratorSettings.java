package com.cosmocat.endemeral.worldgen;

import com.cosmocat.endemeral.Endemeral;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseSettings;

import java.util.List;

public class EndemeralNoiseGeneratorSettings {
    public static final ResourceKey<NoiseGeneratorSettings> END = ResourceKey.create(Registries.NOISE_SETTINGS, ResourceLocation.fromNamespaceAndPath(Endemeral.MOD_ID, "end"));

    public static void bootstrap(BootstrapContext<NoiseGeneratorSettings> context) {
        context.register(END, end(context));
    }

    private static NoiseGeneratorSettings end(BootstrapContext<?> context) {
        return new NoiseGeneratorSettings(NoiseSettings.END_NOISE_SETTINGS, Blocks.END_STONE.defaultBlockState(), Blocks.AIR.defaultBlockState(), EndemeralNoiseRouterData.end(context.lookup(Registries.DENSITY_FUNCTION), context.lookup(Registries.NOISE)), SurfaceRuleData.end(), List.of(), 0, true, false, false, true);
    }

}
