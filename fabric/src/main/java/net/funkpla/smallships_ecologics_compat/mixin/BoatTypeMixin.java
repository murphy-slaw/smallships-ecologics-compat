package net.funkpla.smallships_ecologics_compat.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.talhanation.smallships.mixin.fabric.BoatTypeAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import samebutdifferent.ecologics.entity.ModBoat;
import samebutdifferent.ecologics.registry.ModBlocks;

@Mixin(Boat.Type.class)
public abstract class BoatTypeMixin {
  @Unique private static Boat.Type[] ecologicsCompat$values;

  @ModifyReturnValue(method = "values", at = @At("RETURN"))
  private static Boat.Type[] smallships$addWoodTypes(Boat.Type[] original) {
    if (ecologicsCompat$values == null) {
      List<Boat.Type> types = new ArrayList<>(Arrays.asList(original));
      types.add(
          BoatTypeAccessor.smallships$create(
                  "SMALLSHIPS_ECOLOGICS_COMPAT_"+
              ModBoat.Type.AZALEA,
              types.size(),
              ModBlocks.AZALEA_PLANKS,
              "smallships_ecologics_compat/azalea"));
      types.add(
          BoatTypeAccessor.smallships$create(
                  "SMALLSHIPS_ECOLOGICS_COMPAT_"+
              ModBoat.Type.FLOWERING_AZALEA.toString(),
              types.size(),
              ModBlocks.FLOWERING_AZALEA_PLANKS,
              "smallships_ecologics_compat/flowering_azalea"));
      types.add(
          BoatTypeAccessor.smallships$create(
                  "SMALLSHIPS_ECOLOGICS_COMPAT_"+
              ModBoat.Type.WALNUT.toString(),
              types.size(), ModBlocks.WALNUT_PLANKS,
              "smallships_ecologics_compat/walnut"));
      types.add(
          BoatTypeAccessor.smallships$create(
                  "SMALLSHIPS_ECOLOGICS_COMPAT_"+
              ModBoat.Type.COCONUT.toString(),
              types.size(),
              ModBlocks.COCONUT_PLANKS,
              "smallships_ecologics_compat/coconut"));
      ecologicsCompat$values = types.toArray(new Boat.Type[0]);
    }
    // Arrays.copyOf, not clone(): Mixin cannot remap a method call on an
    // array of the target type and fails the whole class with an NPE
    return Arrays.copyOf(ecologicsCompat$values, ecologicsCompat$values.length);
  }
}
