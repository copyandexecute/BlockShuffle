package de.hglabor.blockshuffle.mixin.features;

import com.mojang.serialization.Codec;
import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IceSpikeFeature;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(IceSpikeFeature.class)
public class IceSpikeFeatureMixin  {

    /*public IceSpikeFeatureMixin(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(StructureWorldAccess structureWorldAccess, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, DefaultFeatureConfig config) {
        while(structureWorldAccess.isAir(blockPos) && blockPos.getY() > 2) {
            blockPos = blockPos.down();
        }
        
        Block snowBlock = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.SNOW_BLOCK,Blocks.SNOW_BLOCK);
        Block ice = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.ICE,Blocks.ICE);
        Block packedIce = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.PACKED_ICE,Blocks.PACKED_ICE);

        if (!structureWorldAccess.getBlockState(blockPos).isOf(snowBlock)) {
            return false;
        } else {
            blockPos = blockPos.up(random.nextInt(4));
            int i = random.nextInt(4) + 7;
            int j = i / 4 + random.nextInt(2);
            if (j > 1 && random.nextInt(60) == 0) {
                blockPos = blockPos.up(10 + random.nextInt(30));
            }

            int k;
            int l;
            for(k = 0; k < i; ++k) {
                float f = (1.0F - (float)k / (float)i) * (float)j;
                l = MathHelper.ceil(f);

                for(int m = -l; m <= l; ++m) {
                    float g = (float)MathHelper.abs(m) - 0.25F;

                    for(int n = -l; n <= l; ++n) {
                        float h = (float)MathHelper.abs(n) - 0.25F;
                        if ((m == 0 && n == 0 || g * g + h * h <= f * f) && (m != -l && m != l && n != -l && n != l || random.nextFloat() <= 0.75F)) {
                            BlockState blockState = structureWorldAccess.getBlockState(blockPos.add(m, k, n));
                            Block block = blockState.getBlock();
                            if (blockState.isAir() || isSoil(block) || block == snowBlock || block == ice) {
                                this.setBlockState(structureWorldAccess, blockPos.add(m, k, n), packedIce.getDefaultState());
                            }

                            if (k != 0 && l > 1) {
                                blockState = structureWorldAccess.getBlockState(blockPos.add(m, -k, n));
                                block = blockState.getBlock();
                                if (blockState.isAir() || isSoil(block) || block == snowBlock || block == ice) {
                                    this.setBlockState(structureWorldAccess, blockPos.add(m, -k, n), packedIce.getDefaultState());
                                }
                            }
                        }
                    }
                }
            }

            k = j - 1;
            if (k < 0) {
                k = 0;
            } else if (k > 1) {
                k = 1;
            }

            for(int p = -k; p <= k; ++p) {
                for(l = -k; l <= k; ++l) {
                    BlockPos blockPos2 = blockPos.add(p, -1, l);
                    int r = 50;
                    if (Math.abs(p) == 1 && Math.abs(l) == 1) {
                        r = random.nextInt(5);
                    }

                    while(blockPos2.getY() > 50) {
                        BlockState blockState2 = structureWorldAccess.getBlockState(blockPos2);
                        Block block2 = blockState2.getBlock();
                        if (!blockState2.isAir() && !isSoil(block2) && block2 != snowBlock && block2 != ice && block2 != packedIce) {
                            break;
                        }

                        this.setBlockState(structureWorldAccess, blockPos2, packedIce.getDefaultState());
                        blockPos2 = blockPos2.down();
                        --r;
                        if (r <= 0) {
                            blockPos2 = blockPos2.down(random.nextInt(5) + 1);
                            r = random.nextInt(5);
                        }
                    }
                }
            }

            return true;
        }
    } */
}
