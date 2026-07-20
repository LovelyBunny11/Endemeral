package com.cosmocat.endemeral.datagen;

import com.cosmocat.endemeral.worldgen.EndemeralMultiNoiseBiomeSourceParameterLists;
import com.cosmocat.endemeral.worldgen.EndemeralNoiseGeneratorSettings;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class EndemeralDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(EndemeralDynamicRegistryProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.NOISE_SETTINGS, EndemeralNoiseGeneratorSettings::bootstrap);
        registryBuilder.add(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, EndemeralMultiNoiseBiomeSourceParameterLists::bootstrap);
    }
}
