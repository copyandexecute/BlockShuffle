package de.hglabor.blockshuffle.mixin;

import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashSet;
import java.util.Set;

import static net.minecraft.world.World.isHeightInvalid;

@Mixin(World.class)
public abstract class WorldMixin implements WorldAccess, AutoCloseable {

    private final static Set<Long> changedBlocks = new HashSet<>();

    @Shadow
    public abstract WorldChunk getChunk(int i, int j);

    @Shadow public abstract void addSyncedBlockEvent(BlockPos pos, Block block, int type, int data);

    @Shadow @Final public boolean isClient;

    @Shadow public abstract boolean isDebugWorld();

    @Shadow public abstract WorldChunk getWorldChunk(BlockPos pos);

    @Shadow public abstract Profiler getProfiler();

    @Shadow public abstract void scheduleBlockRerenderIfNeeded(BlockPos pos, BlockState old, BlockState updated);

    @Shadow public abstract void updateListeners(BlockPos pos, BlockState oldState, BlockState newState, int flags);

    @Shadow public abstract void updateComparators(BlockPos pos, Block block);

    @Shadow public abstract void onBlockChanged(BlockPos pos, BlockState oldBlock, BlockState newBlock);

    /*
    @Override
    public boolean setBlockState(BlockPos pos, BlockState state, int flags, int maxUpdateDepth) {
        if (isHeightInvalid(pos)) {
            return false;
        } else if (!this.isClient && this.isDebugWorld()) {
            return false;
        } else {
            WorldChunk worldChunk = this.getWorldChunk(pos);
            Block block = state.getBlock();
            BlockState blockState = worldChunk.setBlockState(pos, state, (flags & 64) != 0);
            if (blockState == null) {
                return false;
            } else {
                BlockState blockState2 = this.getBlockState(pos);
                if ((flags & 128) == 0 && blockState2 != blockState && (blockState2.getOpacity(this, pos) != blockState.getOpacity(this, pos) || blockState2.getLuminance() != blockState.getLuminance() || blockState2.hasSidedTransparency() || blockState.hasSidedTransparency())) {
                    this.getProfiler().push("queueCheckLight");
                    this.getChunkManager().getLightingProvider().checkBlock(pos);
                    this.getProfiler().pop();
                }

                if (blockState2 == state) {
                    if (blockState != blockState2) {
                        this.scheduleBlockRerenderIfNeeded(pos, blockState, blockState2);
                    }

                    if ((flags & 2) != 0 && (!this.isClient || (flags & 4) == 0) && (this.isClient || worldChunk.getLevelType() != null && worldChunk.getLevelType().isAfter(ChunkHolder.LevelType.TICKING))) {
                        this.updateListeners(pos, blockState, state, flags);
                    }

                    if ((flags & 1) != 0) {
                        this.updateNeighbors(pos, blockState.getBlock());
                        if (!this.isClient && state.hasComparatorOutput()) {
                            this.updateComparators(pos, block);
                        }
                    }

                    if ((flags & 16) == 0 && maxUpdateDepth > 0) {
                        int i = flags & -34;
                        blockState.prepare(this, pos, i, maxUpdateDepth - 1);
                        state.updateNeighbors(this, pos, i, maxUpdateDepth - 1);
                        state.prepare(this, pos, i, maxUpdateDepth - 1);
                    }

                    this.onBlockChanged(pos, blockState, blockState2);
                }

                return true;
            }
        }
    }
  */


  /*  @Override
    public BlockState getBlockState(BlockPos pos) {
        if (isHeightInvalid(pos)) {
            return Blocks.VOID_AIR.getDefaultState();
        } else {
            WorldChunk worldChunk = this.getChunk(pos.getX() >> 4, pos.getZ() >> 4);
            BlockState blockState = worldChunk.getBlockState(pos);
            if (changedBlocks.contains(pos.asLong())) return blockState;
            if (!BlockShuffleMod.FORBIDDEN_BLOCKS.contains(blockState.getBlock())) {
                changedBlocks.add(pos.asLong());
                Block newBlock = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(blockState.getBlock(), null);
                if (newBlock != null) {
                    Block.replace(blockState, newBlock.getDefaultState(), worldChunk.getWorld(), pos, 18);
                }
            }
            return blockState;
        }
    } */
}