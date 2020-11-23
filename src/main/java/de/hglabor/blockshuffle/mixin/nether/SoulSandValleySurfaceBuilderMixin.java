package de.hglabor.blockshuffle.mixin.nether;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.AbstractNetherSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SoulSandValleySurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SoulSandValleySurfaceBuilder.class)
public abstract class SoulSandValleySurfaceBuilderMixin extends AbstractNetherSurfaceBuilder {

    public SoulSandValleySurfaceBuilderMixin(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }

    public ImmutableList<BlockState> method_27129() {
        return ImmutableList.of(BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.SOUL_SAND, Blocks.SOUL_SAND).getDefaultState(), BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.SOUL_SOIL, Blocks.SOUL_SOIL).getDefaultState());
    }

    public ImmutableList<BlockState> method_27133() {
        return ImmutableList.of(BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.SOUL_SAND, Blocks.SOUL_SAND).getDefaultState(), BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.SOUL_SOIL, Blocks.SOUL_SOIL).getDefaultState());
    }

    public BlockState method_27135() {
        return BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.GRAVEL, Blocks.GRAVEL).getDefaultState();
    }

}
