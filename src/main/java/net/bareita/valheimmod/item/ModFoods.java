package net.bareita.valheimmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RAW_DEER_MEAT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).build();
    public static final FoodProperties COOKED_DEER_MEAT = new FoodProperties.Builder().nutrition(6).saturationModifier(1f).build();
    public static final FoodProperties ONION = new FoodProperties.Builder().nutrition(4).saturationModifier(5f).build();
}
