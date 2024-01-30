package net.vukkert.tutorialmod.item.custom;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.vukkert.tutorialmod.TutorialMod;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    RUBY("ruby",25, new int[] {3,8,6,3}, 19,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2f, 0.1f,() -> Ingredient.ofItems(Moditems.RUBY)),
    COAT("coat", 25, new int[]{0,0,0,0}, 0,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.EMPTY);
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngridient;
    private static final int[] BASE_DURABILITY = {11,16,15,13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent quipSound,
                      float toughness, float knockbackResistance, Supplier<Ingredient> repairIngridient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = quipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngridient = repairIngridient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngridient.get();
    }

    @Override
    public String getName() {
        return TutorialMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
