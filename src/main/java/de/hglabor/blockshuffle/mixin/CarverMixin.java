package de.hglabor.blockshuffle.mixin;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.Carver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mixin(Carver.class)
public class CarverMixin<C> {

    @Shadow protected Set<Block> alwaysCarvableBlocks;

    //diese blöcke werden gecarved = höhlen
    @Inject(method = "<init>", at = @At("RETURN"))
    private void injected(Codec<C> configCodec, int heightLimit, CallbackInfo ci) {
        System.out.println("INJECTED");
        ImmutableSet<Block> carvebaleBlocksOrigin = ImmutableSet.of(Blocks.STONE,
                Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE,
                Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL,
                Blocks.GRASS_BLOCK, Blocks.TERRACOTTA, Blocks.WHITE_TERRACOTTA,
                Blocks.ORANGE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA,
                Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.PINK_TERRACOTTA,
                Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.CYAN_TERRACOTTA,
                Blocks.PURPLE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA,
                Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.BLACK_TERRACOTTA, Blocks.SANDSTONE,
                Blocks.RED_SANDSTONE, Blocks.MYCELIUM, Blocks.SNOW, Blocks.PACKED_ICE);

        Set<Block> carvableBlocks = new HashSet<>();
        System.out.println("CARVAKE BKICJS");
        for (Block block : carvebaleBlocksOrigin) {
            Block newCarvableBlock = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(block, block);
            carvableBlocks.add(newCarvableBlock);
            System.out.println(newCarvableBlock);
        }
        System.out.println("CARVAKE BKICJS");
        this.alwaysCarvableBlocks = carvableBlocks;
    }

}
