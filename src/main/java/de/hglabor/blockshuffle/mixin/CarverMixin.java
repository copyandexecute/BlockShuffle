package de.hglabor.blockshuffle.mixin;

import com.mojang.serialization.Codec;
import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.carver.Carver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(Carver.class)
public class CarverMixin<C> {

    @Shadow
    protected Set<Block> alwaysCarvableBlocks;


    /**
     * @author
     */
    @Overwrite
    public boolean canAlwaysCarveBlock(BlockState state) {
        return BlockShuffleMod.getBlocks().contains(state.getBlock());
    }

}
