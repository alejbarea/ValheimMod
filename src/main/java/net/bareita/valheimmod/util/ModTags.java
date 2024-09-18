package net.bareita.valheimmod.util;

import net.bareita.valheimmod.ValheimMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_BRONZE_TOOL = tag("needs_bronze_tool");
        public static final TagKey<Block> INCORRECT_BLOCKS_BRONZE = tag("incorrect_blocks_bronze");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ValheimMod.MODID,name));
        }
    }
    public static class Items {
        public static final TagKey<Item> METAL_PICKAXES = tag("metal_pickaxes");
        public static final TagKey<Item> DEER_TROPHY = tag("deer_trophy");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ValheimMod.MODID,name));
        }
    }
}
