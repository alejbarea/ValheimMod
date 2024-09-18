package net.bareita.valheimmod.datagen.loot;

import net.bareita.valheimmod.block.ModBlocks;
import net.bareita.valheimmod.entity.ModEntities;
import net.bareita.valheimmod.item.ModItems;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Stream;

public class ModMobLootTableProvider extends EntityLootSubProvider {


    public ModMobLootTableProvider() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        this.add(ModEntities.TROLL.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))  // Number of items to drop
                        .add(LootItem.lootTableItem(ModItems.SURTLING_CORE.get())) // Item to drop
                )
        );

        this.add(ModEntities.DEER.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))  // Number of items to drop
                        .add(LootItem.lootTableItem(ModItems.RAW_DEER_MEAT.get())) // Common item to drop
                )
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))  // Roll once for the rare drop
                        .add(LootItem.lootTableItem(ModItems.DEER_TROPHY.get()))  // Rare item to drop
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))  // 5% chance to drop
                )
        );
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return Stream.of(ModEntities.TROLL.get(), ModEntities.DEER.get());
    }
}
