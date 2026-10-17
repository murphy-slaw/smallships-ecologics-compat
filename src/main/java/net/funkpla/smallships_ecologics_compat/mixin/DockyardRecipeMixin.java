package net.funkpla.smallships_ecologics_compat.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.talhanation.smallships.world.dockyard.DockyardRecipe;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import samebutdifferent.ecologics.registry.ModBlocks;

@Mixin(DockyardRecipe.class)
public class DockyardRecipeMixin {
  @WrapMethod(method = "plankItemOf", remap = false)
  private static Item extraPlankTypes(Boat.Type type, Operation<Item> original) {
    switch (type.getName()) {
      case "azalea" -> {
        return ModBlocks.AZALEA_PLANKS.get().asItem();
      }
      case "coconut" -> {
        return ModBlocks.COCONUT_PLANKS.get().asItem();
      }
      case "flowering_azalea" -> {
        return ModBlocks.FLOWERING_AZALEA_PLANKS.get().asItem();
      }
      case "walnut" -> {
        return ModBlocks.WALNUT_PLANKS.get().asItem();
      }
      default -> {
        return original.call(type);
      }
    }
  }
}
