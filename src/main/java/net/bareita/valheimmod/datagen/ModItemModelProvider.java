package net.bareita.valheimmod.datagen;

import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.block.ModBlocks;
import net.bareita.valheimmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ValheimMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BRONZE);
        simpleItem(ModItems.TIN);
        simpleItem(ModItems.RAW_TIN);
        simpleItem(ModItems.RAW_DEER_MEAT);
        simpleItem(ModItems.COOKED_DEER_MEAT);
        simpleItem(ModItems.WISHBONE);
        simpleItem(ModItems.BRONZE_AXE);
        simpleItem(ModItems.BRONZE_BOOTS);
        simpleItem(ModItems.BRONZE_CHEST);
        simpleItem(ModItems.BRONZE_HELMET);
        simpleItem(ModItems.BRONZE_HOE);
        simpleItem(ModItems.BRONZE_LEGS);
        simpleItem(ModItems.BRONZE_HELMET);
        simpleItem(ModItems.BRONZE_PICKAXE);
        simpleItem(ModItems.BRONZE_SHOVEL);
        simpleItem(ModItems.BRONZE_SWORD);
        simpleItem(ModItems.ONION);
        simpleItem(ModItems.ONION_SEED);
        simpleItem(ModItems.SURTLING_CORE);
        simpleItem(ModItems.DEER_TROPHY);
        simpleItem(ModItems.TROLL_SPAWN_EGG);
        simpleItem(ModItems.DEER_SPAWN_EGG);


        simpleBlockItem(ModBlocks.BRONZE_DOOR);
        fenceItem(ModBlocks.BRONZE_FENCE,ModBlocks.BRONZE_BLOCK);
        buttonItem(ModBlocks.BRONZE_BUTTON, ModBlocks.BRONZE_BLOCK);
        wallItem(ModBlocks.BRONZE_WALL, ModBlocks.BRONZE_BLOCK);

    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(ValheimMod.MODID,"item/"+item.getId().getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory")).texture("texture", new ResourceLocation(ValheimMod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory")).texture("texture", new ResourceLocation(ValheimMod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory")).texture("wall", new ResourceLocation(ValheimMod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()+"_bottom"));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ValheimMod.MODID, "item/" + item.getId().getPath()));
    }

   public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ValheimMod.MODID+":"+ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
   }
}
