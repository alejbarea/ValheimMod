package net.bareita.valheimmod.datagen;

import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.block.ModBlocks;
import net.bareita.valheimmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {


    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        oreBlasting(pRecipeOutput, List.of(ModItems.RAW_TIN.get()),RecipeCategory.MISC,ModItems.TIN.get(), 0.25f, 100, "tin");
        oreSmelting(pRecipeOutput, List.of(ModItems.RAW_TIN.get()),RecipeCategory.MISC,ModItems.TIN.get(), 0.25f, 200, "tin");
        oreSmelting(pRecipeOutput, List.of(ModItems.RAW_DEER_MEAT.get()),RecipeCategory.MISC,ModItems.COOKED_DEER_MEAT.get(), 0.25f, 200, "tin");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_SWORD.get()).pattern("A").pattern("A").pattern("B").define('A', ModItems.BRONZE.get()).define('B',Items.STICK).unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_SHOVEL.get()).pattern("A").pattern("B").pattern("B").define('A', ModItems.BRONZE.get()).define('B',Items.STICK).unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_PICKAXE.get()).pattern("AAA").pattern(" B ").pattern(" B ").define('A', ModItems.BRONZE.get()).define('B',Items.STICK).unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_AXE.get()).pattern("AA ").pattern("AB ").pattern(" B ").define('A', ModItems.BRONZE.get()).define('B',Items.STICK).unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_HOE.get()).pattern("AA ").pattern(" B ").pattern(" B ").define('A', ModItems.BRONZE.get()).define('B',Items.STICK).unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_HELMET.get()).pattern("AAA").pattern("A A").define('A', ModItems.BRONZE.get()).unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_BOOTS.get()).pattern("A A").pattern("A A").define('A', ModItems.BRONZE.get()).unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_CHEST.get()).pattern("A A").pattern("AAA").pattern("AAA").define('A', ModItems.BRONZE.get()).unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_LEGS.get()).pattern("AAA").pattern("A A").pattern("A A").define('A', ModItems.BRONZE.get()).unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_SPEAR.get()).pattern("  A").pattern(" B ").pattern("  B").define('A', ModItems.BRONZE.get()).define('B',Items.STICK).unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPEAR.get()).pattern("  A").pattern(" B ").pattern("  B").define('A', Items.COBBLESTONE).define('B',Items.STICK).unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIN_BLOCK.get()).pattern("SSS").pattern("SSS").pattern("SSS").define('S',ModItems.TIN.get()).unlockedBy(getHasName(ModItems.TIN.get()), has(ModItems.TIN.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BRONZE_BLOCK.get()).pattern("SSS").pattern("SSS").pattern("SSS").define('S',ModItems.BRONZE.get()).unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN.get(), 9).requires(ModBlocks.TIN_BLOCK.get()).unlockedBy(getHasName(ModBlocks.TIN_BLOCK.get()),has(ModBlocks.TIN_BLOCK.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRONZE.get(), 9).requires(ModBlocks.BRONZE_BLOCK.get()).unlockedBy(getHasName(ModBlocks.BRONZE_BLOCK.get()),has(ModBlocks.BRONZE_BLOCK.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRONZE.get(), 1).requires(ModItems.TIN.get()).requires(Items.COPPER_INGOT).requires(Items.COPPER_INGOT).unlockedBy(getHasName(ModItems.TIN.get()),has(ModItems.TIN.get())).save(pRecipeOutput, new ResourceLocation("valheimmod","bronze_from_tin_and_copper"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FORGE_BLOCK.get()).pattern("SSS").pattern("SBS").pattern("SAS").define('S',Items.COBBLESTONE).define('A',Items.COPPER_INGOT).define('B',Items.COAL).unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).save(pRecipeOutput);


        stairBuilder(ModBlocks.BRONZE_STAIRS.get(), Ingredient.of(ModItems.BRONZE.get())).group("bronze").unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRONZE_SLAB.get(), ModItems.BRONZE.get());
        buttonBuilder(ModBlocks.BRONZE_BUTTON.get(), Ingredient.of(ModItems.BRONZE.get())).group("bronze").unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        doorBuilder(ModBlocks.BRONZE_DOOR.get(), Ingredient.of(ModItems.BRONZE.get())).group("bronze").unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        fenceBuilder(ModBlocks.BRONZE_FENCE.get(), Ingredient.of(ModItems.BRONZE.get())).group("bronze").unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.BRONZE_FENCE_GATE.get(), Ingredient.of(ModItems.BRONZE.get())).group("bronze").unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.BRONZE_TRAPDOOR.get(), Ingredient.of(ModItems.BRONZE.get())).group("bronze").unlockedBy(getHasName(ModItems.BRONZE.get()), has(ModItems.BRONZE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRONZE_WALL.get(), ModItems.BRONZE.get());
        pressurePlate(pRecipeOutput, ModBlocks.BRONZE_PRESSURE_PLATE.get(), ModItems.BRONZE.get());
    }

    protected static void oreSmelting(
            RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(
            RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput pRecipeOutput,
            RecipeSerializer<T> pSerializer,
            AbstractCookingRecipe.Factory<T> pRecipeFactory,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pSuffix
    ) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, ValheimMod.MODID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }
}
