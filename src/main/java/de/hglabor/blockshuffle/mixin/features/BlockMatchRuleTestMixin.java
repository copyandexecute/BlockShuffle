package de.hglabor.blockshuffle.mixin.features;

import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.Tag;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(BlockMatchRuleTest.class)
public abstract class BlockMatchRuleTestMixin extends RuleTest {


    @Shadow @Final private Block block;

  /*  @Override
    public boolean test(BlockState state, Random random) {
        return state == BlockShuffleMod.BLOCK_PAIRS.getOrDefault(block,block).getDefaultState();
    } */

}
