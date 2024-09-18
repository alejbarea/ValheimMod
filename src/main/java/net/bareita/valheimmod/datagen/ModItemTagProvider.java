package net.bareita.valheimmod.datagen;

import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.item.ModItems;
import net.bareita.valheimmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, ValheimMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.METAL_PICKAXES).add(Items.IRON_PICKAXE).add(Items.GOLDEN_PICKAXE).add(ModItems.BRONZE_PICKAXE.get());
        tag(ModTags.Items.DEER_TROPHY).add(ModItems.DEER_TROPHY.get());
    }
}
