package de.hglabor.blockshuffle;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BlockShuffleMod implements ModInitializer {
    public final static Map<Block, Block> BLOCK_PAIRS = new HashMap<>();
    public final static List<Block> FORBIDDEN_BLOCKS = Arrays.asList(Blocks.AIR, Blocks.CAVE_AIR, Blocks.VOID_AIR);
    public final static List<String> FORBIDDEN_BLOCK_NAMES = Arrays.asList("_WALL", "_STAIRS", "_PLATE",
            "_SLAB", "_CARPET", "_BANNER", "_TORCH", "_SAPLING", "_FAN", "_SKULL", "_HEAD", "_PANE", "_FENCE", "CAMPFIRE",
            "_CORAL_BLOCK", "_SIGN", "_BUTTON", "_GATE", "CONDUIT", "_DOOR", "_TRAPDOOR", "SEA_PICKLE", "BAMBOO", "CHEST", "_BED", "LANTERN", "_CORAL", "SPAWNER", "END_PORTAL_FRAME");
    public final static List<Material> ALLOWED_MATERIAL = Arrays.asList(Material.METAL, Material.WOOD,
            Material.SOLID_ORGANIC, Material.SOIL, Material.CACTUS, Material.SNOW_BLOCK,
            Material.SNOW_LAYER, Material.TNT,
            Material.DENSE_ICE, Material.WOOL, Material.LEAVES, Material.ORGANIC_PRODUCT,
            Material.STONE, Material.GOURD, Material.AGGREGATE, Material.COBWEB,
            Material.SPONGE, Material.NETHER_WOOD, Material.GLASS, Material.ICE,
            Material.PISTON);


    public static void randomize() {
        BLOCK_PAIRS.clear();
        List<Block> blockList = new ArrayList<>();
        for (Block block : Registry.BLOCK) {
            if (!FORBIDDEN_BLOCKS.contains(block)) {
                if (ALLOWED_MATERIAL.contains(block.getDefaultState().getMaterial())) {
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
                    //   }
                }
            }
            List<Block> blockListCopy = new ArrayList<>(blockList);
            Collections.shuffle(blockList);
            for (int i = 0; i < blockListCopy.size(); i++) {
                BLOCK_PAIRS.put(blockListCopy.get(i), blockList.get(i));
            }
        }
    }

    @NotNull
    public static Set<Block> getBlocks() {

        if (BLOCK_PAIRS.isEmpty()) randomize();

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
        for (Block block : carvebaleBlocksOrigin) {
            Block newCarvableBlock = BlockShuffleMod.BLOCK_PAIRS.getOrDefault(block, block);
            carvableBlocks.add(newCarvableBlock);
        }
        return carvableBlocks;
    }

    @Override
    public void onInitialize() {
        randomize();

        // SurfaceBuilderAccessor.setGrassConfig(new TernarySurfaceConfig(Blocks.STONE.getDefaultState(),Blocks.STONE.getDefaultState(),Blocks.STONE.getDefaultState()));

    }
}
