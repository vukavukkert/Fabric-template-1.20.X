package net.vukkert.tutorialmod.item.custom;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder().saturationModifier(0.25f).hunger(3).
            statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.25f).build();
}
