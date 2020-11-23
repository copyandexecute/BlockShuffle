package de.hglabor.blockshuffle.mixin.features;

import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.*;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AbstractBlock.AbstractBlockState.class)
public abstract class AbstractBlockMixin {

    @Shadow
    @Final
    private Material material;

    @Shadow
    public abstract Block getBlock();

    @Shadow
    protected abstract BlockState asBlockState();

    @Shadow
    public abstract Material getMaterial();

    /**
     * @author
     */
    @Overwrite
    public boolean isIn(Tag<Block> tag) {
        Block block = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(this.getBlock(), this.getBlock());
        return block.isIn(tag);
    }

    /**
     * @author
     */
    @Overwrite()
    public boolean canPlaceAt(WorldView world, BlockPos pos) {
        if (material == Material.PLANT || material == Material.REPLACEABLE_PLANT) {
            BlockState blockState = world.getBlockState(pos.offset(Direction.DOWN, 1));
            Block blockUnder = blockState.getBlock();

            if (blockUnder.getDefaultState().getMaterial() == Material.LEAVES){
                return false;
            }

            return blockUnder.getDefaultState().getMaterial() != Material.AIR && blockUnder != Blocks.WATER && blockUnder != Blocks.LAVA && (this.getBlock() != blockUnder);
        } else {
            return this.getBlock().canPlaceAt(this.asBlockState(), world, pos);
        }
    }


}
