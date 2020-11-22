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

    private static final BlockState BASALT;
    private static final BlockState BLACKSTONE;
    private static final BlockState GRAVEL;
    private static final ImmutableList<BlockState> field_23918;
    private static final ImmutableList<BlockState> field_23919;

    public BasaltDetalsSurfaceBuilderMixin(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }

    //BASALT UND BLACKSTONE
    @Override
    public ImmutableList<BlockState> method_27129() {
        return field_23918;
    }

    //BASALT
    @Override
    public ImmutableList<BlockState> method_27133() {
        return field_23919;
    }

    //GRAVEL
    @Override
    public BlockState method_27135() {
        return GRAVEL;
    }

    static {
        BASALT = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.BASALT,Blocks.BASALT).getDefaultState();
        BLACKSTONE = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.BLACKSTONE,Blocks.BLACKSTONE).getDefaultState();
        GRAVEL = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.GRAVEL,Blocks.GRAVEL).getDefaultState();
        field_23918 = ImmutableList.of(BASALT, BLACKSTONE);
        field_23919 = ImmutableList.of(BASALT);
    }

}
