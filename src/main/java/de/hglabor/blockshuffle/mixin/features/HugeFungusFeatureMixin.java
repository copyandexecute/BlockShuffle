package de.hglabor.blockshuffle.mixin.features;

import com.mojang.serialization.Codec;
import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeFungusFeature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Random;

@Mixin(HugeFungusFeature.class)
public abstract class HugeFungusFeatureMixin extends Feature<HugeFungusFeatureConfig> {

    @Shadow protected abstract void generateStem(WorldAccess world, Random random, HugeFungusFeatureConfig config, BlockPos blockPos, int stemHeight, boolean thickStem);

    @Shadow protected abstract void generateHat(WorldAccess world, Random random, HugeFungusFeatureConfig config, BlockPos blockPos, int hatHeight, boolean thickStem);

    public HugeFungusFeatureMixin(Codec<HugeFungusFeatureConfig> configCodec) {
        super(configCodec);
    }

    @ModifyVariable(method = "generate", at = @At("STORE"), ordinal = 0)
    private Block injected(Block block) {
        return BlockShuffleMod.BLOCK_PAIRS.getOrDefault(block,block);
    }

   /*  @Override
    public boolean generate(StructureWorldAccess structureWorldAccess, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, HugeFungusFeatureConfig hugeFungusFeatureConfig) {
        Block block = hugeFungusFeatureConfig.validBaseBlock.getBlock();
        block = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(block,block);
        BlockPos blockPos2 = null;
        Block block2 = structureWorldAccess.getBlockState(blockPos.down()).getBlock();
        if (block2 == block) {
            blockPos2 = blockPos;
        }

        if (blockPos2 == null) {
            return false;
        } else {
            int i = MathHelper.nextInt(random, 4, 13);
            if (random.nextInt(12) == 0) {
                i *= 2;
            }

            if (!hugeFungusFeatureConfig.planted) {
                int j = chunkGenerator.getMaxY();
                if (blockPos2.getY() + i + 1 >= j) {
                    return false;
                }
            }

            boolean bl = !hugeFungusFeatureConfig.planted && random.nextFloat() < 0.06F;
            structureWorldAccess.setBlockState(blockPos, Blocks.AIR.getDefaultState(), 4);
            this.generateStem(structureWorldAccess, random, hugeFungusFeatureConfig, blockPos2, i, bl);
            this.generateHat(structureWorldAccess, random, hugeFungusFeatureConfig, blockPos2, i, bl);
            return true;
        }
    } */
}
