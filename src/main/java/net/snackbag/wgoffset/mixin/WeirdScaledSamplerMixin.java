package net.snackbag.wgoffset.mixin;

import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.snackbag.wgoffset.WorldgenOffset;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.world.gen.densityfunction.DensityFunctionTypes$WeirdScaledSampler")
public abstract class WeirdScaledSamplerMixin {
    @Redirect(method = "apply(Lnet/minecraft/world/gen/densityfunction/DensityFunction$NoisePos;D)D", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/gen/densityfunction/DensityFunction$NoisePos;blockX()I"))
    private int worldgenOffset$offsetX(DensityFunction.NoisePos pos) {
        return pos.blockX() + WorldgenOffset.CONFIG.offsetX.get();
    }

    @Redirect(method = "apply", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/gen/densityfunction/DensityFunction$NoisePos;blockZ()I"))
    private int worldgenOffset$offsetZ(DensityFunction.NoisePos pos) {
        return pos.blockZ() + WorldgenOffset.CONFIG.offsetZ.get();
    }
}
