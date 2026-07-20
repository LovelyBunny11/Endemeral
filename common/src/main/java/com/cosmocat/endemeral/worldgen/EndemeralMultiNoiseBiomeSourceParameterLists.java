package com.cosmocat.endemeral.worldgen;

import com.cosmocat.endemeral.Endemeral;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;

import java.util.List;
import java.util.function.Function;

public class EndemeralMultiNoiseBiomeSourceParameterLists {
    public static final ResourceKey<MultiNoiseBiomeSourceParameterList> END = register("end");

    public static void bootstrap(BootstrapContext<MultiNoiseBiomeSourceParameterList> context) {
        HolderGetter<Biome> holdergetter = context.lookup(Registries.BIOME);
        context.register(END, new MultiNoiseBiomeSourceParameterList(Presets.END, holdergetter));

    }

    private static ResourceKey<MultiNoiseBiomeSourceParameterList> register(String name) {
        return ResourceKey.create(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, ResourceLocation.fromNamespaceAndPath(Endemeral.MOD_ID, name));
    }

    public class Presets {
        public static final MultiNoiseBiomeSourceParameterList.Preset END = new MultiNoiseBiomeSourceParameterList.Preset(ResourceLocation.fromNamespaceAndPath(Endemeral.MOD_ID,"end"), new MultiNoiseBiomeSourceParameterList.Preset.SourceProvider() {
            public <T> Climate.ParameterList<T> apply(Function<ResourceKey<Biome>, T> p_275356_) {
                return new Climate.ParameterList(List.of(Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), p_275356_.apply(Biomes.NETHER_WASTES)), Pair.of(Climate.parameters(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), p_275356_.apply(Biomes.SOUL_SAND_VALLEY)), Pair.of(Climate.parameters(0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), p_275356_.apply(Biomes.CRIMSON_FOREST)), Pair.of(Climate.parameters(0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.375F), p_275356_.apply(Biomes.WARPED_FOREST)), Pair.of(Climate.parameters(-0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.175F), p_275356_.apply(Biomes.BASALT_DELTAS))));
            }
        });
    }
}
