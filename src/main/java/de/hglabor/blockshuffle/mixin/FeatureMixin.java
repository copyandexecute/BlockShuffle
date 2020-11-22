package de.hglabor.blockshuffle.mixin;

import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Feature.class)
public class FeatureMixin {

    /**
     * @author Payback
     * used for treees and flowers etc
     */
    @Overwrite()
    public static boolean isSoil(Block block) {
        Block dirtFake = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.DIRT, Blocks.DIRT);
        Block grassFake = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.GRASS_BLOCK, Blocks.GRASS_BLOCK);
        Block podzolFake = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.PODZOL, Blocks.PODZOL);
        Block coarseDirtFake = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.COARSE_DIRT, Blocks.COARSE_DIRT);
        Block myceliumFake = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.MYCELIUM, Blocks.MYCELIUM);
        return block == dirtFake || block == grassFake || block == podzolFake || block == coarseDirtFake || block == myceliumFake;
    }

}
