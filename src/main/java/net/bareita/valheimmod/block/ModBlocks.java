package net.bareita.valheimmod.block;

import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.block.custom.EikthyrSummonBlock;
import net.bareita.valheimmod.block.custom.ForgeBlock;
import net.bareita.valheimmod.block.custom.OnionCropBlock;
import net.bareita.valheimmod.item.ModItems;
import net.bareita.valheimmod.sound.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ValheimMod.MODID);

    public static final RegistryObject<Block> EIKTHYR_SUMMON = registerBlock("eikthyr_summon", () -> new EikthyrSummonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK)));
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> BRONZE_BLOCK = registerBlock("bronze_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> BRONZE_STAIRS = registerBlock("bronze_stairs", () -> new StairBlock(ModBlocks.BRONZE_BLOCK.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> BRONZE_SLAB = registerBlock("bronze_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> BRONZE_BUTTON = registerBlock("bronze_button", () -> new ButtonBlock(BlockSetType.IRON,10,BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<Block> BRONZE_PRESSURE_PLATE = registerBlock("bronze_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> BRONZE_FENCE = registerBlock("bronze_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> BRONZE_FENCE_GATE = registerBlock("bronze_fence_gate", () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), SoundEvents.BAMBOO_WOOD_DOOR_OPEN, SoundEvents.BAMBOO_WOOD_DOOR_CLOSE));
    public static final RegistryObject<Block> BRONZE_WALL = registerBlock("bronze_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> BRONZE_DOOR = registerBlock("bronze_door", () -> new DoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BRONZE_TRAPDOOR = registerBlock("bronze_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));


    public static final RegistryObject<Block> FORGE_BLOCK = registerBlock("forge_block",() -> new ForgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> ONION_CROP = BLOCKS.register("onion_crop", () -> new OnionCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion().noCollission()));





    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
