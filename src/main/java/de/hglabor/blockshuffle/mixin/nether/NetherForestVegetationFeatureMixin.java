package de.hglabor.blockshuffle.mixin.nether;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.BlockPileFeatureConfig;
import net.minecraft.world.gen.feature.NetherForestVegetationFeature;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(NetherForestVegetationFeature.class)
public class NetherForestVegetationFeatureMixin {

   /* public static boolean method_26264(WorldAccess worldAccess, Random random, BlockPos blockPos, BlockPileFeatureConfig blockPileFeatureConfig, int i, int j) {
        Block block = worldAccess.getBlockState(blockPos.down()).getBlock();
        if (!block.isIn(BlockTags.NYLIUM)) {
            return false;
        } else {
            int k = blockPos.getY();
            if (k >= 1 && k + 1 < 256) {
                int l = 0;

                for(int m = 0; m < i * i; ++m) {
                    BlockPos blockPos2 = blockPos.add(random.nextInt(i) - random.nextInt(i), random.nextInt(j) - random.nextInt(j), random.nextInt(i) - random.nextInt(i));
                    BlockState blockState = blockPileFeatureConfig.stateProvider.getBlockState(random, blockPos2);
                    if (worldAccess.isAir(blockPos2) && blockPos2.getY() > 0 && blockState.canPlaceAt(worldAccess, blockPos2)) {
                        worldAccess.setBlockState(blockPos2, blockState, 2);
                        ++l;
                    }
                }

                return l > 0;
            } else {
                return false;
            }
        }
    } */

}
