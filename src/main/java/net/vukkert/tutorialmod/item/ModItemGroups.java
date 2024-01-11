package net.vukkert.tutorialmod.item;

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

                        entries.add(Items.DIAMOND);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                    }).build());
    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Regestering item groups for" + TutorialMod.MOD_ID);
    }
}
