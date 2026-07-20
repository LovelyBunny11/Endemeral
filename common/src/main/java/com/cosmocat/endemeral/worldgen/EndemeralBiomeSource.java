package com.cosmocat.endemeral.worldgen;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.biome.*;

public class EndemeralBiomeSource extends MultiNoiseBiomeSource {

    public TheEndBiomeSource vanillaBiomeSource;

    private EndemeralBiomeSource(Either<Climate.ParameterList<Holder<Biome>>, Holder<MultiNoiseBiomeSourceParameterList>> parameters, TheEndBiomeSource vanillaBiomeSource) {
        super(parameters);
        this.vanillaBiomeSource = vanillaBiomeSource;
    }

    public static EndemeralBiomeSource create(Holder<MultiNoiseBiomeSourceParameterList> parameters, TheEndBiomeSource vanillaBiomeSource) {
        return new EndemeralBiomeSource(Either.right(parameters), vanillaBiomeSource);
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        int i = QuartPos.toBlock(x);
        int j = QuartPos.toBlock(y);
        int k = QuartPos.toBlock(z);
        int l = SectionPos.blockToSectionCoord(i);
        int i1 = SectionPos.blockToSectionCoord(k);
        if ((long)l * (long)l + (long)i1 * (long)i1 <= 24576) {
            return this.vanillaBiomeSource.getNoiseBiome(x, y, z, sampler);
        } else {
            return super.getNoiseBiome(x, y, z, sampler);
        }
    }
}
