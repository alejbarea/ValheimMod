package net.bareita.valheimmod.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BronzeArmorItem extends ArmorItem {
    public BronzeArmorItem(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean inner) {
        if (slot == EquipmentSlot.LEGS) {
            return new ResourceLocation("valheimmod:textures/models/armor/bronze_layer_2.png");
        } else {
            return new ResourceLocation("valheimmod:textures/models/armor/bronze_layer_1.png");
        }
    }
}
