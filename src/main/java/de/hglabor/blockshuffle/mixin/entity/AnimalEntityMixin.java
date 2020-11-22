package de.hglabor.blockshuffle.mixin.entity;

import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;

@Mixin(AnimalEntity.class)
public class AnimalEntityMixin {

    /**
     * @author yo
     */
    @Overwrite
    public static boolean isValidNaturalSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isOf(BlockShuffleMod.BLOCK_PAIRS.getOrDefault(Blocks.GRASS_BLOCK,Blocks.GRASS_BLOCK)) && world.getBaseLightLevel(pos, 0) > 8;
    }

}
