package net.funkpla.smallships_ecologics_compat;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.world.level.block.Blocks;

public class EarlyRiser implements Runnable {
  @Override
  public void run() {
    MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();

    String boat = remapper.mapClassName("intermediary", "net.minecraft.class_1690$class_1692");
    String block = 'L' + remapper.mapClassName("intermediary", "net.minecraft.class_2248") + ';';
    ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;")
        .addEnum("COCONUT", () -> new Object[] {Blocks.BAMBOO_PLANKS, "coconut"})
        .addEnum("WALNUT", () -> new Object[] {Blocks.DARK_OAK_PLANKS, "walnut"})
        .addEnum("AZALEA", () -> new Object[] {Blocks.ACACIA_PLANKS, "azalea"})
        .addEnum(
            "FLOWERING_AZALEA",
            () -> new Object[] {Blocks.MANGROVE_PLANKS, "flowering_azalea"})
        .build();
  }
}
