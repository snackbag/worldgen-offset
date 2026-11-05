package net.snackbag.wgoffset.mixin;

import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.snackbag.wgoffset.WorldgenOffset;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// using strings because I'm too lazy to make an access widener
@Mixin(targets = {
        "net.minecraft.world.gen.densityfunction.DensityFunctionTypes$Noise",
        "net.minecraft.world.gen.densityfunction.DensityFunctionTypes$ShiftedNoise",
        "net.minecraft.world.gen.densityfunction.DensityFunctionTypes$ShiftA",
        "net.minecraft.util.math.noise.InterpolatedNoiseSampler",
})
public abstract class NoiseMixin {
    @Redirect(method = "sample", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/gen/densityfunction/DensityFunction$NoisePos;blockX()I"))
    private int worldgenOffset$offsetX(DensityFunction.NoisePos pos) {
        return pos.blockX() + WorldgenOffset.CONFIG.offsetX.get();
    }

    @Redirect(method = "sample", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/gen/densityfunction/DensityFunction$NoisePos;blockZ()I"))
    private int worldgenOffset$offsetZ(DensityFunction.NoisePos pos) {
        return pos.blockZ() + WorldgenOffset.CONFIG.offsetZ.get();
    }
}