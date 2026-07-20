package com.cosmocat.endemeral.datagen;

import com.cosmocat.endemeral.worldgen.EndemeralNoiseGeneratorSettings;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.*;

public class EndemeralDataGenerators implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.NOISE_SETTINGS, EndemeralNoiseGeneratorSettings::bootstrap);
    }
}
