package net.bareita.valheimmod.item;


import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

import java.util.List;

public class ModToolTiers {
    public static final ForgeTier BRONZE = new ForgeTier(500,10,100,25, ModTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(ModItems.BRONZE.get()), ModTags.Blocks.INCORRECT_BLOCKS_BRONZE);

}
