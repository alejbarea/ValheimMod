package net.bareita.valheimmod.item;

import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.block.ModBlocks;
import net.bareita.valheimmod.entity.ModEntities;
import net.bareita.valheimmod.item.custom.BronzeArmorItem;
import net.bareita.valheimmod.item.custom.FuelItem;
import net.bareita.valheimmod.item.custom.SpearItem;
import net.bareita.valheimmod.item.custom.WishboneItem;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ValheimMod.MODID);

    public static final RegistryObject<Item> TIN = ITEMS.register("tin",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE = ITEMS.register("bronze",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WISHBONE = ITEMS.register("wishbone",() -> new WishboneItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> RAW_DEER_MEAT = ITEMS.register("raw_deer_meat", () -> new Item(new Item.Properties().food(ModFoods.RAW_DEER_MEAT)));
    public static final RegistryObject<Item> COOKED_DEER_MEAT = ITEMS.register("cooked_deer_meat", () -> new Item(new Item.Properties().food(ModFoods.COOKED_DEER_MEAT)));
    public static final RegistryObject<Item> ONION = ITEMS.register("onion", () -> new Item(new Item.Properties().food(ModFoods.ONION)));


    public static final RegistryObject<Item> SURTLING_CORE = ITEMS.register("surtling_core", () -> new FuelItem(new Item.Properties(), 400));

    public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword", () -> new SwordItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe", () -> new PickaxeItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register("bronze_axe", () -> new AxeItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_HOE = ITEMS.register("bronze_hoe",() -> new HoeItem(ModToolTiers.BRONZE, new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",() -> new ShovelItem(ModToolTiers.BRONZE, new Item.Properties()));

    public static final RegistryObject<Item> SPEAR = ITEMS.register("spear", () -> new SpearItem(new Item.Properties().durability(200),4.0f, 's'));

    public static final RegistryObject<Item> BRONZE_SPEAR = ITEMS.register("bronze_spear", () -> new SpearItem(new Item.Properties().durability(500),6.0f, 'b'));

    public static final RegistryObject<Item> BRONZE_HELMET = ITEMS.register("bronze_helmet", () -> new BronzeArmorItem(ModArmorMaterials.BRONZE,ArmorItem.Type.HELMET,new Item.Properties().durability(300)));
    public static final RegistryObject<Item> BRONZE_BOOTS = ITEMS.register("bronze_boots", () -> new BronzeArmorItem(ModArmorMaterials.BRONZE,ArmorItem.Type.BOOTS,new Item.Properties().durability(300)));
    public static final RegistryObject<Item> BRONZE_CHEST = ITEMS.register("bronze_chest", () -> new BronzeArmorItem(ModArmorMaterials.BRONZE,ArmorItem.Type.CHESTPLATE,new Item.Properties().durability(300)));
    public static final RegistryObject<Item> BRONZE_LEGS = ITEMS.register("bronze_legs", () -> new BronzeArmorItem(ModArmorMaterials.BRONZE,ArmorItem.Type.LEGGINGS,new Item.Properties().durability(300)));

    public static final RegistryObject<Item> ONION_SEED = ITEMS.register("onion_seed", () -> new ItemNameBlockItem(ModBlocks.ONION_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> TROLL_SPAWN_EGG = ITEMS.register("troll_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.TROLL, 0x111111, 0x222222, new Item.Properties()));
    public static final RegistryObject<Item> DEER_SPAWN_EGG = ITEMS.register("deer_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.DEER, 0x122111, 0x432222, new Item.Properties()));
    public static final RegistryObject<Item> DEER_TROPHY = ITEMS.register("deer_trophy", () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
