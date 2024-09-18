package net.bareita.valheimmod.datagen.loot;

import net.bareita.valheimmod.block.ModBlocks;
import net.bareita.valheimmod.block.custom.OnionCropBlock;
import net.bareita.valheimmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {



    public ModBlockLootTableProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    @Override
    protected void generate() {
        dropSelf(ModBlocks.BRONZE_BLOCK.get());
        dropSelf(ModBlocks.TIN_BLOCK.get());
        dropSelf(ModBlocks.FORGE_BLOCK.get());
        dropSelf(ModBlocks.BRONZE_FENCE_GATE.get());
        dropSelf(ModBlocks.BRONZE_WALL.get());
        dropSelf(ModBlocks.BRONZE_DOOR.get());
        dropSelf(ModBlocks.BRONZE_STAIRS.get());
        dropSelf(ModBlocks.BRONZE_SLAB.get());
        dropSelf(ModBlocks.BRONZE_BUTTON.get());
        dropSelf(ModBlocks.BRONZE_TRAPDOOR.get());
        dropSelf(ModBlocks.BRONZE_FENCE.get());
        dropSelf(ModBlocks.BRONZE_PRESSURE_PLATE.get());

        dropSelf(ModBlocks.BRONZE_STAIRS.get());
        dropSelf(ModBlocks.BRONZE_BUTTON.get());
        dropSelf(ModBlocks.BRONZE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.BRONZE_FENCE.get());
        dropSelf(ModBlocks.BRONZE_FENCE_GATE.get());
        dropSelf(ModBlocks.BRONZE_WALL.get());
        dropSelf(ModBlocks.BRONZE_TRAPDOOR.get());

        this.add(ModBlocks.BRONZE_SLAB.get(), block -> createSlabItemTable(ModBlocks.BRONZE_SLAB.get()));

        this.add(ModBlocks.BRONZE_DOOR.get(), block -> createDoorTable(ModBlocks.BRONZE_DOOR.get()));



        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ONION_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE,3));
        this.add(ModBlocks.ONION_CROP.get(), block -> createCropDrops(ModBlocks.ONION_CROP.get(), ModItems.ONION.get(), ModItems.ONION_SEED.get(), lootitemcondition$builder));

        this.add(ModBlocks.TIN_ORE.get(), block -> createOreDrop(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get()));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
