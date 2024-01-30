package net.vukkert.tutorialmod.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vukkert.tutorialmod.TutorialMod;

public class Moditems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item COAL_BRICK = registerFuelItem("coal_brick", new Item(new FabricItemSettings()),200);
    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item SCYTHE = registerItem("scythe", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(ModToolMaterial.RUBY,
            2, 2f, new FabricItemSettings())); //pickaxe
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterial.RUBY,
            2, 2f, new FabricItemSettings()));
    public static final Item RUBY_SWORD = registerItem("ruby_sword", new SwordItem(ModToolMaterial.RUBY,
            10, 2f, new FabricItemSettings()));
    public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(ModToolMaterial.RUBY,
            15, 2f, new FabricItemSettings()));
    public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(ModToolMaterial.RUBY,
            0, 0f, new FabricItemSettings()));

    public static final Item RUBY_STAFF = registerItem("ruby_staff",
    new RubyStaffItem(new FabricItemSettings().maxCount(1)));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet", new ModArmorItem(ModArmorMaterials.RUBY,
            ArmorItem.Type.HELMET, new FabricItemSettings())); //phelmet
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate", new ArmorItem(ModArmorMaterials.RUBY,
            ArmorItem.Type.CHESTPLATE, new FabricItemSettings())); //chestplate
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings", new ArmorItem(ModArmorMaterials.RUBY,
            ArmorItem.Type.LEGGINGS, new FabricItemSettings())); //leggings
    public static final Item RUBY_BOOTS = registerItem("ruby_boots", new ArmorItem(ModArmorMaterials.RUBY,
            ArmorItem.Type.BOOTS, new FabricItemSettings())); //boots

    public static final Item COAT_HELMET = registerItem("coat_helmet", new CoatArmorItem(ModArmorMaterials.COAT,
            ArmorItem.Type.HELMET, new FabricItemSettings())); //helmet
    public static final Item COAT_CHESTPLATE = registerItem("coat_chestplate", new ArmorItem(ModArmorMaterials.COAT,
            ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item COAT_LEGGINGS = registerItem("coat_leggings", new ArmorItem(ModArmorMaterials.COAT,
            ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item COAT_BOOTS = registerItem("coat_boots", new ArmorItem(ModArmorMaterials.COAT,
            ArmorItem.Type.BOOTS, new FabricItemSettings()));
    private static void addItemsToIngridientItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }
    private static Item registerFuelItem(String name, Item item, Integer cookSpeed){
        FuelRegistry.INSTANCE.add(item, cookSpeed);
        return registerItem(name, item);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering mod items for" + TutorialMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(Moditems::addItemsToIngridientItemGroup);
    }
}
