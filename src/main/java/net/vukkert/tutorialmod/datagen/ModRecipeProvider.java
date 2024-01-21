package net.vukkert.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.vukkert.tutorialmod.block.ModBlocks;
import net.vukkert.tutorialmod.item.custom.Moditems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(Moditems.RAW_RUBY,
            ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE,
            ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, Moditems.RUBY,
                0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, Moditems.RUBY,
                0.7f, 200, "ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, Moditems.RUBY, RecipeCategory.DECORATIONS,
                ModBlocks.RUBY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Moditems.RAW_RUBY, 1)
                .pattern("sss")
                .pattern("srs")
                .pattern("sss")
                .input('s', Items.STONE)
                .input('r', Moditems.RUBY)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(Moditems.RUBY), conditionsFromItem(Moditems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(Moditems.RAW_RUBY)));



        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_WALL, ModBlocks.RUBY_BLOCK);
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_FENCE, ModBlocks.RUBY_BLOCK, 4);
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_FENCE_GATE, ModBlocks.RUBY_BLOCK, 1);
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_TRAPDOOR, ModBlocks.RUBY_BLOCK, 2);
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_DOOR, ModBlocks.RUBY_BLOCK, 3);
    }
}
