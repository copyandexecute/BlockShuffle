package de.hglabor.blockshuffle;

import de.hglabor.blockshuffle.mixin.AbstractBlockAccessor;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;

import java.util.*;

public class BlockShuffleMod implements ModInitializer {
    public final static Map<Block, Block> BLOCK_PAIRS = new HashMap<>();
    public final static List<Block> FORBIDDEN_BLOCKS = Arrays.asList(Blocks.AIR, Blocks.CAVE_AIR, Blocks.VOID_AIR);
    public final static List<String> FORBIDDEN_BLOCK_NAMES = Arrays.asList("_WALL", "_STAIRS", "_PLATE",
            "_SLAB", "_CARPET", "_BANNER", "_TORCH", "_SAPLING", "_FAN", "_SKULL", "_HEAD", "_PANE", "_FENCE", "CAMPFIRE",
            "_CORAL_BLOCK", "_SIGN", "_BUTTON", "_GATE", "_DOOR", "_TRAPDOOR", "_BED", "LANTERN", "_CORAL");
    public final static List<Material> ALLOWED_MATERIAL = Arrays.asList(Material.METAL, Material.WOOD,
            Material.SOLID_ORGANIC, Material.SOIL,Material.CACTUS,Material.SNOW_BLOCK,
            Material.SNOW_LAYER,Material.TNT,
            Material.DENSE_ICE, Material.WOOL, Material.LEAVES, Material.ORGANIC_PRODUCT,
            Material.STONE, Material.GOURD, Material.AGGREGATE, Material.COBWEB,
            Material.SPONGE, Material.NETHER_WOOD, Material.GLASS, Material.ICE,
            Material.REDSTONE_LAMP,Material.PISTON);

    static {
        List<Block> blockList = new ArrayList<>();
        for (Block block : Registry.BLOCK) {
            if (!FORBIDDEN_BLOCKS.contains(block)) {
                if (ALLOWED_MATERIAL.contains(((AbstractBlockAccessor) (block)).getMaterial())) {
                    boolean flag = false;
                    for (String forbiddenBlockName : FORBIDDEN_BLOCK_NAMES) {
                        if (block.getTranslationKey().toUpperCase().endsWith(forbiddenBlockName)) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println(block.getTranslationKey());
                        blockList.add(block);
                    }
                }
            }
        }
        List<Block> blockListCopy = new ArrayList<>(blockList);
        Collections.shuffle(blockList);
        for (int i = 0; i < blockListCopy.size(); i++) {
            BLOCK_PAIRS.put(blockListCopy.get(i), blockList.get(i));
        }

    }

    @Override
    public void onInitialize() {
        // SurfaceBuilderAccessor.setGrassConfig(new TernarySurfaceConfig(Blocks.STONE.getDefaultState(),Blocks.STONE.getDefaultState(),Blocks.STONE.getDefaultState()));

    }
}
