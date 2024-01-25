package net.vukkert.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.vukkert.tutorialmod.block.ModBlocks;

public class RubyStaffItem extends Item {
    public RubyStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient){
            BlockPos positionClick = context.getBlockPos();
            var world = context.getWorld();
            world.breakBlock(positionClick, false);
            context.getWorld().setBlockState(positionClick, ModBlocks.RUBY_BLOCK.getDefaultState());
            //changes clicked block into a block of ruby
        }
        return ActionResult.SUCCESS;
    }

}
