package net.vukkert.tutorialmod.item.custom;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vukkert.tutorialmod.TutorialMod;
import net.vukkert.tutorialmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(()-> new ItemStack(ModBlocks.RUBY_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(Moditems.RUBY);
                        entries.add(Moditems.RAW_RUBY);

                        entries.add(Moditems.METAL_DETECTOR);
                        entries.add(Moditems.TOMATO);
                        entries.add(Moditems.COAL_BRICK);
                        entries.add(Moditems.RUBY_STAFF);
                        entries.add(Moditems.SCYTHE);

                        entries.add(Moditems.RUBY_PICKAXE);
                        entries.add(Moditems.RUBY_AXE);
                        entries.add(Moditems.RUBY_SWORD);
                        entries.add(Moditems.RUBY_SHOVEL);
                        entries.add(Moditems.RUBY_HOE);

                        entries.add(Moditems.RUBY_HELMET);
                        entries.add(Moditems.RUBY_CHESTPLATE);
                        entries.add(Moditems.RUBY_LEGGINGS);
                        entries.add(Moditems.RUBY_BOOTS);

                        entries.add(Moditems.COAT_HELMET);
                        entries.add(Moditems.COAT_CHESTPLATE);
                        entries.add(Moditems.COAT_LEGGINGS);
                        entries.add(Moditems.COAT_BOOTS);

                        entries.add(Items.DIAMOND);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);

                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_STONE_RUBY_ORE);

                        entries.add(ModBlocks.RUBY_SLAB);
                        entries.add(ModBlocks.RUBY_STAIRS);
                        entries.add(ModBlocks.RUBY_FENCE);
                        entries.add(ModBlocks.RUBY_FENCE_GATE);
                        entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                        entries.add(ModBlocks.RUBY_BUTTON);
                        entries.add(ModBlocks.RUBY_DOOR);
                        entries.add(ModBlocks.RUBY_TRAPDOOR);
                        entries.add(ModBlocks.RUBY_WALL);

                        entries.add(ModBlocks.SOUND_BLOCK);
                    }).build());
    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Regestering item groups for" + TutorialMod.MOD_ID);
    }
}
