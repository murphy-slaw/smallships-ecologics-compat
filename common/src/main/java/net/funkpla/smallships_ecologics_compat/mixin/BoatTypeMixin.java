package net.funkpla.smallships_ecologics_compat.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.talhanation.smallships.mixin.vanillaboat.BoatTypeAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import samebutdifferent.ecologics.entity.ModBoat;

@Mixin(value=Boat.Type.class)
public abstract class BoatTypeMixin {
  @Unique private static Boat.Type[] ecologicsCompat$values;

  @ModifyReturnValue(method = {"values","m_150277_"}, at = @At(value = "RETURN"))
  private static Boat.Type[] smallships$addWoodTypes(Boat.Type[] original) {
    if (ecologicsCompat$values == null) {
      List<Boat.Type> types = new ArrayList<>(Arrays.asList(original));
      types.add(
          BoatTypeAccessor.smallships$create(
              ModBoat.Type.AZALEA.toString(), types.size(), Blocks.OAK_PLANKS, "azalea"));
      types.add(
          BoatTypeAccessor.smallships$create(
              ModBoat.Type.FLOWERING_AZALEA.toString(),
              types.size(),
              Blocks.ACACIA_PLANKS,
              "flowering_azalea"));
      types.add(
          BoatTypeAccessor.smallships$create(
              ModBoat.Type.WALNUT.toString(), types.size(), Blocks.DARK_OAK_PLANKS, "walnut"));
      types.add(
          BoatTypeAccessor.smallships$create(
              ModBoat.Type.COCONUT.toString(), types.size(), Blocks.BAMBOO_PLANKS, "coconut"));
      ecologicsCompat$values = types.toArray(new Boat.Type[0]);
    }
    // Arrays.copyOf, not clone(): Mixin cannot remap a method call on an
    // array of the target type and fails the whole class with an NPE
    return Arrays.copyOf(ecologicsCompat$values, ecologicsCompat$values.length);
  }
}
