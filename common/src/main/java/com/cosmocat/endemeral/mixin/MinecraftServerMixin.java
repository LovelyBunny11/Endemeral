package com.cosmocat.endemeral.mixin;

import com.cosmocat.endemeral.worldgen.EndemeralBiomeSource;
import com.cosmocat.endemeral.worldgen.EndemeralMultiNoiseBiomeSourceParameterLists;
import com.cosmocat.endemeral.worldgen.EndemeralNoiseGeneratorSettings;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {

    @ModifyArgs(method = "createLevels", at = @At(value = "INVOKE", target = "net/minecraft/server/level/ServerLevel.<init>(Lnet/minecraft/server/MinecraftServer;Ljava/util/concurrent/Executor;Lnet/minecraft/world/level/storage/LevelStorageSource$LevelStorageAccess;Lnet/minecraft/world/level/storage/ServerLevelData;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/world/level/dimension/LevelStem;Lnet/minecraft/server/level/progress/ChunkProgressListener;ZJLjava/util/List;ZLnet/minecraft/world/RandomSequences;)V"))
    private void addModdedBiomes(Args args) {
        MinecraftServer server = args.get(0);
        LevelStem dimensionOptions = args.get(5);
        if (BuiltinDimensionTypes.END.equals(
                dimensionOptions.type().unwrapKey().orElse(null))) {
            ChunkGenerator defaultChunkGen = dimensionOptions.generator();
            BiomeSource defaultBiomes = defaultChunkGen.getBiomeSource();
            if (defaultBiomes instanceof TheEndBiomeSource theEndBiomeSource) {
                EndemeralBiomeSource biomeSource = EndemeralBiomeSource.create(server.registryAccess().lookupOrThrow(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST).getOrThrow(EndemeralMultiNoiseBiomeSourceParameterLists.END), theEndBiomeSource);
                args.set(5, new LevelStem(
                        dimensionOptions.type(),
                        new NoiseBasedChunkGenerator(biomeSource, server.registryAccess().lookupOrThrow(Registries.NOISE_SETTINGS).getOrThrow(EndemeralNoiseGeneratorSettings.END))
                ));
            }
        }
    }
}
