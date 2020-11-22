package de.hglabor.blockshuffle.mixin.features;

import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.RuleTestType;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.Tag;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(TagMatchRuleTest.class)
public abstract class TagMatchRuleTestMixin extends RuleTest {

    @Shadow @Final private Tag<Block> tag;

    //die methode check ob "stein" für erze da ist
    @Override
    public boolean test(BlockState state, Random random) {
        return state == BlockShuffleMod.BLOCK_PAIRS.get(tag.getRandom(random)).getDefaultState();
    }

}
