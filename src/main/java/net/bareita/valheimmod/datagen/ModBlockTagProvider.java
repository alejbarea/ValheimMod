package net.bareita.valheimmod.datagen;

import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.block.ModBlocks;
import net.bareita.valheimmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ValheimMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.BRONZE_BLOCK.get())
                .add(ModBlocks.FORGE_BLOCK.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.BRONZE_BUTTON.get())
                .add(ModBlocks.BRONZE_FENCE.get())
                .add(ModBlocks.BRONZE_FENCE_GATE.get())
                .add(ModBlocks.BRONZE_WALL.get())
                .add(ModBlocks.BRONZE_TRAPDOOR.get())
                .add(ModBlocks.BRONZE_DOOR.get())
                .add(ModBlocks.BRONZE_PRESSURE_PLATE.get())
                .add(ModBlocks.BRONZE_STAIRS.get())
                .add(ModBlocks.BRONZE_SLAB.get());
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.BRONZE_BLOCK.get())
                .add(ModBlocks.FORGE_BLOCK.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.BRONZE_BUTTON.get())
                .add(ModBlocks.BRONZE_FENCE.get())
                .add(ModBlocks.BRONZE_FENCE_GATE.get())
                .add(ModBlocks.BRONZE_WALL.get())
                .add(ModBlocks.BRONZE_TRAPDOOR.get())
                .add(ModBlocks.BRONZE_DOOR.get())
                .add(ModBlocks.BRONZE_PRESSURE_PLATE.get())
                .add(ModBlocks.BRONZE_STAIRS.get())
                .add(ModBlocks.BRONZE_SLAB.get());
        tag(BlockTags.FENCES).add(ModBlocks.BRONZE_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BRONZE_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BRONZE_WALL.get());
    }
}
