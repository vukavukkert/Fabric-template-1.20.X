package net.vukkert.tutorialmod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.vukkert.tutorialmod.item.custom.Moditems;

public class ModLootTableModifiers {

    private static final Identifier JUNGLE_TEMPLE_ID = new Identifier("minecraft", "chests/jungle_temple");
    private static final Identifier CREEPER_ID = new Identifier("minecraft", "entities/creeper");
    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (JUNGLE_TEMPLE_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))// 0f ==drops never; 1f == drops 100% of the time
                        .with(ItemEntry.builder(Moditems.METAL_DETECTOR)) // loot
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());//amount
                tableBuilder.pool(poolBuilder.build());
            }
            if (CREEPER_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))// 0f ==drops never; 1f == drops 100% of the time
                        .with(ItemEntry.builder(Moditems.COAL_BRICK)) // loot
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());//amount
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
