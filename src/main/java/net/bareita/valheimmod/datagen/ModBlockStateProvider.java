package net.bareita.valheimmod.datagen;

import net.bareita.valheimmod.Config;
import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.block.ModBlocks;
import net.bareita.valheimmod.block.custom.OnionCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.C;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ValheimMod.MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BRONZE_BLOCK);
        blockWithItem(ModBlocks.FORGE_BLOCK);
        blockWithItem(ModBlocks.TIN_BLOCK);
        blockWithItem(ModBlocks.TIN_ORE);
        blockWithItem(ModBlocks.EIKTHYR_SUMMON);

        makeOnionCrop((CropBlock) ModBlocks.ONION_CROP.get(), "onion_stage", "onion_stage");

        stairsBlock(((StairBlock) ModBlocks.BRONZE_STAIRS.get()), blockTexture(ModBlocks.BRONZE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.BRONZE_SLAB.get()), blockTexture(ModBlocks.BRONZE_BLOCK.get()), blockTexture(ModBlocks.BRONZE_BLOCK.get()));

        buttonBlock((ButtonBlock) ModBlocks.BRONZE_BUTTON.get(), blockTexture(ModBlocks.BRONZE_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.BRONZE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BRONZE_BLOCK.get()));

        wallBlock((WallBlock) ModBlocks.BRONZE_WALL.get(), blockTexture(ModBlocks.BRONZE_BLOCK.get()));
        fenceBlock((FenceBlock) ModBlocks.BRONZE_FENCE.get(), blockTexture(ModBlocks.BRONZE_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.BRONZE_FENCE_GATE.get(), blockTexture(ModBlocks.BRONZE_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.BRONZE_DOOR.get()), modLoc("block/bronze_door_bottom"), modLoc("block/bronze_door_top"),"cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.BRONZE_TRAPDOOR.get(), modLoc("block/bronze_trapdoor"), true, "cutout");


        blockItem(ModBlocks.BRONZE_STAIRS);
        blockItem(ModBlocks.BRONZE_SLAB);
        blockItem(ModBlocks.BRONZE_PRESSURE_PLATE);
        blockItem(ModBlocks.BRONZE_FENCE_GATE);
        blockItem(ModBlocks.BRONZE_TRAPDOOR,"_bottom");
    }

    private void makeOnionCrop(CropBlock block, String modelname, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> onionStates(state, block, modelname, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] onionStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((OnionCropBlock) block).getAgeProperty()), new ResourceLocation(ValheimMod.MODID, "block/" + textureName + state.getValue(((OnionCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("valheimmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("valheimmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
}
