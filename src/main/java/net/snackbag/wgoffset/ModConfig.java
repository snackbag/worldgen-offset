package net.snackbag.wgoffset;

import dev.lemonnik.fern_config.CConfig;
import dev.lemonnik.fern_config.CExporter;
import dev.lemonnik.fern_config.types.CInteger;
import dev.lemonnik.fern_config.utils.CCategory;
import org.jetbrains.annotations.NotNull;

public class ModConfig extends CConfig {
    @Override
    public @NotNull String getFileName() {
        return WorldgenOffset.MOD_ID;
    }

    @Override
    protected CExporter.@NotNull Format getFormat() {
        return CExporter.Format.TOML;
    }

    public final CCategory base = CCategory.of("base", "Configuration for Worldgen Offset.");
    public final CInteger offsetX = register(base, new CInteger("offsetX", "The X-coordinate offset applied to world generation. The value 1000 means that the generation at world x=0 will be the generation at x=1000 if the world were generated normally.", 0));
    public final CInteger offsetY = register(base, new CInteger("offsetY", "The Y-coordinate offset applied to world generation. The value 1000 means that the generation at world y=0 will be the generation at y=1000 if the world were generated normally.", 0));
}
