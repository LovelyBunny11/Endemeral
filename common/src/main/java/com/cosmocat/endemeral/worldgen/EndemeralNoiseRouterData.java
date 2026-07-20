package com.cosmocat.endemeral.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import static net.minecraft.world.level.levelgen.NoiseRouterData.*;

public class EndemeralNoiseRouterData {
    public static NoiseRouter end(HolderGetter<DensityFunction> densityFunctions, HolderGetter<NormalNoise.NoiseParameters> noiseParameters) {
        DensityFunction densityfunction = DensityFunctions.cache2d(DensityFunctions.endIslands(0L));
        DensityFunction densityfunction1 = postProcess(slideEnd(getFunction(densityFunctions, SLOPED_CHEESE_END)));
        DensityFunction densityfunction4 = getFunction(densityFunctions, SHIFT_X);
        DensityFunction densityfunction5 = getFunction(densityFunctions, SHIFT_Z);
        DensityFunction densityfunction6 = DensityFunctions.shiftedNoise2d(densityfunction4, densityfunction5, 0.25F, noiseParameters.getOrThrow(Noises.TEMPERATURE));
        DensityFunction densityfunction7 = DensityFunctions.shiftedNoise2d(densityfunction4, densityfunction5, 0.25F, noiseParameters.getOrThrow(Noises.VEGETATION));
        return new NoiseRouter(DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), densityfunction6, densityfunction7, getFunction(densityFunctions, CONTINENTS), densityfunction, getFunction(densityFunctions, DEPTH), DensityFunctions.zero(), slideEnd(DensityFunctions.add(densityfunction, DensityFunctions.constant(-0.703125F))), densityfunction1, DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero());
    }

    private static DensityFunction postProcess(DensityFunction densityFunction) {
        DensityFunction densityfunction = DensityFunctions.blendDensity(densityFunction);
        return DensityFunctions.mul(DensityFunctions.interpolated(densityfunction), DensityFunctions.constant(0.64)).squeeze();
    }

    private static DensityFunction slideEndLike(DensityFunction densityFunction, int minY, int maxY) {
        return slide(densityFunction, minY, maxY, 72, -184, -23.4375F, 4, 32, -0.234375F);
    }

    private static DensityFunction slideEnd(DensityFunction densityFunction) {
        return slideEndLike(densityFunction, 0, 128);
    }

    private static DensityFunction slide(DensityFunction input, int minY, int maxY, int p_224447_, int p_224448_, double p_224449_, int p_224450_, int p_224451_, double p_224452_) {
        DensityFunction densityfunction1 = DensityFunctions.yClampedGradient(minY + maxY - p_224447_, minY + maxY - p_224448_, 1.0F, 0.0F);
        DensityFunction $$9 = DensityFunctions.lerp(densityfunction1, p_224449_, input);
        DensityFunction densityfunction2 = DensityFunctions.yClampedGradient(minY + p_224450_, minY + p_224451_, 0.0F, 1.0F);
        return DensityFunctions.lerp(densityfunction2, p_224452_, $$9);
    }

    private static DensityFunction getFunction(HolderGetter<DensityFunction> densityFunctions, ResourceKey<DensityFunction> key) {
        return new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(key));
    }
}
