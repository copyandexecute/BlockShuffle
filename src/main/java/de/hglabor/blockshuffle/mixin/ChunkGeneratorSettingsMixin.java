package de.hglabor.blockshuffle.mixin;

import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ChunkGeneratorSettings.class)
public class ChunkGeneratorSettingsMixin {

    @Shadow @Final private BlockState defaultBlock;

    /**
     * @author KOMPLETTE WELT WIRD MIT BESTEHT AUS DIESEM BLOCK ALS ERSETZES
     */
    @Overwrite()
    public BlockState getDefaultBlock() {
        BlockState state = this.defaultBlock;
        Block newBlock = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(state.getBlock(),null);
        if (newBlock != null) {
            state = newBlock.getDefaultState();
        }
        return state;
    }
}
