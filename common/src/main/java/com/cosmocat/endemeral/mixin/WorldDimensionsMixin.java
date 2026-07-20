package com.cosmocat.endemeral.mixin;

import com.cosmocat.endemeral.worldgen.EndemeralBiomeSource;
import com.cosmocat.endemeral.worldgen.EndemeralNoiseGeneratorSettings;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.WorldDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WorldDimensions.class)
public class WorldDimensionsMixin {
    @ModifyReturnValue(method = "isStableEnd", at = @At("RETURN"))
    private static boolean isStableEnd(boolean original,LevelStem levelStem) {
        return original || levelStem.type().is(BuiltinDimensionTypes.END)
                && levelStem.generator() instanceof NoiseBasedChunkGenerator noisebasedchunkgenerator
                && noisebasedchunkgenerator.stable(EndemeralNoiseGeneratorSettings.END)
                && noisebasedchunkgenerator.getBiomeSource() instanceof EndemeralBiomeSource;
    }
}
