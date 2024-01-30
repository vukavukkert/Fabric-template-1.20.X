package net.vukkert.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.vukkert.tutorialmod.block.ModBlocks;
import net.vukkert.tutorialmod.item.custom.Moditems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool rubyPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RUBY_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_RUBY_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);


        rubyPool.stairs(ModBlocks.RUBY_STAIRS);
        rubyPool.slab(ModBlocks.RUBY_SLAB);
        rubyPool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);
        rubyPool.fence(ModBlocks.RUBY_FENCE);
        rubyPool.fenceGate(ModBlocks.RUBY_FENCE_GATE);
        rubyPool.button(ModBlocks.RUBY_BUTTON);
        rubyPool.wall(ModBlocks.RUBY_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.RUBY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_TRAPDOOR);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Moditems.RUBY, Models.GENERATED);
        itemModelGenerator.register(Moditems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(Moditems.COAL_BRICK, Models.GENERATED);
        itemModelGenerator.register(Moditems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(Moditems.METAL_DETECTOR, Models.GENERATED);

        itemModelGenerator.register(Moditems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(Moditems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(Moditems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(Moditems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(Moditems.RUBY_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) Moditems.RUBY_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) Moditems.RUBY_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) Moditems.RUBY_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) Moditems.RUBY_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) Moditems.COAT_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) Moditems.COAT_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) Moditems.COAT_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) Moditems.COAT_BOOTS));
    }
}
