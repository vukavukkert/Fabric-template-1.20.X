package net.vukkert.tutorialmod.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.vukkert.tutorialmod.TutorialMod;
import net.vukkert.tutorialmod.item.custom.Moditems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useRubyStaffModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded,
                                        MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        //the thing we're saying is hey if we are currently
        //looking for the render off or the model
        //for the Ruby staff and we're not in the
        //GUI then I actually want to take the 3D
        //model instead and that's pretty much it
        if (stack.isOf(Moditems.RUBY_STAFF) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager()
                    .getModel(new ModelIdentifier(TutorialMod.MOD_ID, "ruby_staff_3d", "inventory"));
        }
        return value;
    }
}
