package de.hglabor.blockshuffle.mixin.nether;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.AbstractNetherSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.BasaltDeltasSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BasaltDeltasSurfaceBuilder.class)
public abstract class BasaltDetalsSurfaceBuilderMixin extends AbstractNetherSurfaceBuilder {

    public BasaltDetalsSurfaceBuilderMixin(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }

    //BASALT UND BLACKSTONE
    @Override
    public ImmutableList<BlockState> method_27129() {
        return ImmutableList.of(BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.BASALT,Blocks.BASALT).getDefaultState(), BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.BLACKSTONE,Blocks.BLACKSTONE).getDefaultState());
    }

    //BASALT
    @Override
    public ImmutableList<BlockState> method_27133() {
        return ImmutableList.of(BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.BASALT,Blocks.BASALT).getDefaultState());
    }

    //GRAVEL
    @Override
    public BlockState method_27135() {
        return BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.GRAVEL,Blocks.GRAVEL).getDefaultState();
    }



}
