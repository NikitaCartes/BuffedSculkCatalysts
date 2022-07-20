package xyz.nikitacartes.buffedsculkcatalysts.mixin;

import net.minecraft.block.SculkCatalystBlock;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SculkCatalystBlock.class)
public class SculkCatalystBlockMixin {
    @ModifyArg(method = "onStacksDropped", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/SculkCatalystBlock;dropExperienceWhenMined(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/math/intprovider/IntProvider;)V"), index = 3)
    private IntProvider adjustXP(final IntProvider experience) {
        return ConstantIntProvider.create(20);
    }
}
