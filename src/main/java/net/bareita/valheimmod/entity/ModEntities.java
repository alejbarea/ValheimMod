package net.bareita.valheimmod.entity;

import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.entity.custom.DeerEntity;
import net.bareita.valheimmod.entity.custom.EikthyrEntity;
import net.bareita.valheimmod.entity.custom.SpearEntity;
import net.bareita.valheimmod.entity.custom.TrollEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Animal;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ValheimMod.MODID);

    public static final RegistryObject<EntityType<TrollEntity>> TROLL = ENTITY_TYPES.register("troll", () -> EntityType.Builder.of(TrollEntity::new, MobCategory.MONSTER).sized(2.5f,2.5f).build("troll"));
    public static final RegistryObject<EntityType<DeerEntity>> DEER = ENTITY_TYPES.register("deer", () -> EntityType.Builder.of(DeerEntity::new, MobCategory.AMBIENT).sized(1.2f,1.2f).build("deer"));
    public static final RegistryObject<EntityType<EikthyrEntity>> EIKTHYR = ENTITY_TYPES.register("eikthyr", () -> EntityType.Builder.of(EikthyrEntity::new, MobCategory.MONSTER).sized(3f,3f).build("eikthyr"));

    public static final RegistryObject<EntityType<SpearEntity>> SPEAR_ENTITY = ENTITY_TYPES.register("spear_entity", () -> EntityType.Builder.<SpearEntity>of(SpearEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("spear_entity"));

    public static void register(IEventBus eventBus) { ENTITY_TYPES.register(eventBus);}
}
