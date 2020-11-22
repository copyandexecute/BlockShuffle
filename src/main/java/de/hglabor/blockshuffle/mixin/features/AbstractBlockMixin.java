package de.hglabor.blockshuffle.mixin.features;

import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AbstractBlock.AbstractBlockState.class)
public abstract class AbstractBlockMixin {

    @Shadow public abstract Block getBlock();

    /**
     * @author
     */
    @Overwrite
    public boolean isIn(Tag<Block> tag) {
        Block block = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(this.getBlock(),this.getBlock());
        return block.isIn(tag);
    }


}
