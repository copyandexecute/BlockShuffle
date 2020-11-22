package de.hglabor.blockshuffle.mixin;

import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ChunkRegion.class)
public abstract class ChunkRegionMixin implements StructureWorldAccess {

    @Shadow
    @Final
    private ServerWorld world;

    @Shadow
    protected abstract void markBlockForPostProcessing(BlockPos pos);

    // this method replaced all structures + trees + flowers.... DIRT + ORES + ANDESITE AUCH MAX
    @Override
    public boolean setBlockState(BlockPos pos, BlockState state, int flags, int maxUpdateDepth) {
        Block newBlock = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(state.getBlock(),null);
        if (newBlock != null) {
            state = newBlock.getDefaultState();
        }
        Chunk chunk = this.getChunk(pos);
        BlockState blockState = chunk.setBlockState(pos, state, false);
        if (blockState != null) {
            this.world.onBlockChanged(pos, blockState, state);
        }

        Block block = state.getBlock();
        if (block.hasBlockEntity()) {
            if (chunk.getStatus().getChunkType() == ChunkStatus.ChunkType.field_12807) {
                chunk.setBlockEntity(pos, ((BlockEntityProvider) block).createBlockEntity(this));
            } else {
                CompoundTag compoundTag = new CompoundTag();
                compoundTag.putInt("x", pos.getX());
                compoundTag.putInt("y", pos.getY());
                compoundTag.putInt("z", pos.getZ());
                compoundTag.putString("id", "DUMMY");
                chunk.addPendingBlockEntityTag(compoundTag);
            }
        } else if (blockState != null && blockState.getBlock().hasBlockEntity()) {
            chunk.removeBlockEntity(pos);
        }

        if (state.shouldPostProcess(this, pos)) {
            this.markBlockForPostProcessing(pos);
        }

        return true;
    }


}
