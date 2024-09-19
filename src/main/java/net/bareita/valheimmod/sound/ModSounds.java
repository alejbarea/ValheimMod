package net.bareita.valheimmod.sound;

import net.bareita.valheimmod.ValheimMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ValheimMod.MODID);

    public static final RegistryObject<SoundEvent> HALDOR_GREETINGS = registerSoundEvents("haldor_greetings");

    public static final RegistryObject<SoundEvent> TROLL_AMBIENT = registerSoundEvents("troll_ambient");
    public static final RegistryObject<SoundEvent> TROLL_HURT = registerSoundEvents("troll_hurt");
    public static final RegistryObject<SoundEvent> TROLL_DEATH = registerSoundEvents("troll_death");

    public static final RegistryObject<SoundEvent> DEER_AMBIENT = registerSoundEvents("deer_ambient");
    public static final RegistryObject<SoundEvent> DEER_HURT = registerSoundEvents("deer_hurt");
    public static final RegistryObject<SoundEvent> DEER_DEATH = registerSoundEvents("deer_death");

    public static final RegistryObject<SoundEvent> EIKTHYR_AMBIENT = registerSoundEvents("eikthyr_ambient");
    public static final RegistryObject<SoundEvent> EIKTHYR_HURT = registerSoundEvents("eikthyr_hurt");
    public static final RegistryObject<SoundEvent> EIKTHYR_DEATH = registerSoundEvents("eikthyr_death");
    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ValheimMod.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }


}

