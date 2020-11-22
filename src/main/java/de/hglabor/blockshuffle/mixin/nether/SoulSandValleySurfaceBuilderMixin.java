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

    private static final BlockState SOUL_SAND;
    private static final BlockState SOUL_SOIL;
    private static final BlockState GRAVEL;
    private static final ImmutableList<BlockState> field_23924;

    public SoulSandValleySurfaceBuilderMixin(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }

    public ImmutableList<BlockState> method_27129() {
        return field_23924;
    }

    public ImmutableList<BlockState> method_27133() {
        return field_23924;
    }

    public BlockState method_27135() {
        return GRAVEL;
    }

    static {
        SOUL_SAND = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.SOUL_SAND, Blocks.SOUL_SAND).getDefaultState();
        SOUL_SOIL = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.SOUL_SOIL, Blocks.SOUL_SOIL).getDefaultState();
        GRAVEL = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.GRAVEL, Blocks.GRAVEL).getDefaultState();
        field_23924 = ImmutableList.of(SOUL_SAND, SOUL_SOIL);
    }
}
