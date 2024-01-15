package net.vukkert.tutorialmod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.vukkert.tutorialmod.block.ModBlocks;
import net.vukkert.tutorialmod.item.custom.Moditems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.RAW_RUBY_BLOCK);
        addDrop(ModBlocks.SOUND_BLOCK);

        addDrop(ModBlocks.RUBY_ORE, SeveralOreDrops(ModBlocks.RUBY_ORE, Moditems.RAW_RUBY, 2f, 5f));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, SeveralOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, Moditems.RAW_RUBY, 2f, 5f));
        addDrop(ModBlocks.NETHER_RUBY_ORE, SeveralOreDrops(ModBlocks.NETHER_RUBY_ORE, Moditems.RAW_RUBY, 2f, 5f));
        addDrop(ModBlocks.END_STONE_RUBY_ORE, SeveralOreDrops(ModBlocks.END_STONE_RUBY_ORE, Moditems.RAW_RUBY, 2f, 5f));
    }

    public LootTable.Builder SeveralOreDrops(Block drop, Item item, float min, float max) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this
                .applyExplosionDecay(drop, ((LeafEntry.Builder) ItemEntry
                .builder(item)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider
                .create(min, max))))
                .apply(ApplyBonusLootFunction
                .oreDrops(Enchantments.FORTUNE))));
    }
}
