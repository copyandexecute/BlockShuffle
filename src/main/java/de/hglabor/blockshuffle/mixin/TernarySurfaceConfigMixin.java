package de.hglabor.blockshuffle.mixin;

import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TernarySurfaceConfig.class)
public class TernarySurfaceConfigMixin implements SurfaceConfig {

    @Shadow @Final private BlockState topMaterial;

    @Shadow @Final private BlockState underMaterial;

    @Shadow @Final private BlockState underwaterMaterial;

    @Override
    public BlockState getTopMaterial() {
        BlockState state = this.topMaterial;
        Block newBlock = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(state.getBlock(),null);
        if (newBlock != null) {
            return newBlock.getDefaultState();
        }
        return state;
    }

    @Override
    public BlockState getUnderMaterial() {
        BlockState state = this.underMaterial;
        Block newBlock = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(state.getBlock(),null);
        if (newBlock != null) {
            return newBlock.getDefaultState();
        }
        return state;
    }

    /**
     * @author underwater
     */
    @Overwrite()
    public BlockState getUnderwaterMaterial() {
        BlockState state = this.underwaterMaterial;
        Block newBlock = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(state.getBlock(),null);
        if (newBlock != null) {
            return newBlock.getDefaultState();
        }
        return state;
    }


}
