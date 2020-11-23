package de.hglabor.blockshuffle.mixin.features;

import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IcebergFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(IcebergFeature.class)
public class IcebergFeatureMixin {

    /**
     * @author
     */
    @Overwrite
    private boolean isSnowyOrIcy(Block block) {
        return block == BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.PACKED_ICE,Blocks.PACKED_ICE)
                || block == BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.SNOW_BLOCK,Blocks.SNOW_BLOCK)
                || block == BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.BLUE_ICE,Blocks.BLUE_ICE);
    }

}
