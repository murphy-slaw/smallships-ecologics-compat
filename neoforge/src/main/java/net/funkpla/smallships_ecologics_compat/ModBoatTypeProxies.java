package net.funkpla.smallships_ecologics_compat;

import com.talhanation.smallships.world.entity.ship.ModBoatTypes;
import java.util.function.Supplier;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import samebutdifferent.ecologics.registry.ModBlocks;

public class ModBoatTypeProxies {

    public static final EnumProxy<Boat.Type> AZALEA = new EnumProxy<>(Boat.Type.class,
            (Supplier<Block>) () -> ModBlocks.AZALEA_PLANKS,
            "smallships_ecologics_compat:azalea",
            (Supplier<Item>) () -> Items.AIR,
            (Supplier<Item>) () -> Items.AIR,
            (Supplier<Item>) () -> Items.STICK,
            false);
    public static final EnumProxy<Boat.Type> FLOWERING_AZALEA = new EnumProxy<>(Boat.Type.class,
            (Supplier<Block>) () -> ModBlocks.FLOWERING_AZALEA_PLANKS,
            "smallships_ecologics_compat:flowering_azalea",
            (Supplier<Item>) () -> Items.AIR,
            (Supplier<Item>) () -> Items.AIR,
            (Supplier<Item>) () -> Items.STICK,
            false);
    public static final EnumProxy<Boat.Type> WALNUT = new EnumProxy<>(Boat.Type.class,
            (Supplier<Block>) () -> ModBlocks.WALNUT_PLANKS,
            "smallships_ecologics_compat:walnut",
            (Supplier<Item>) () -> Items.AIR,
            (Supplier<Item>) () -> Items.AIR,
            (Supplier<Item>) () -> Items.STICK,
            false);
    public static final EnumProxy<Boat.Type> COCONUT = new EnumProxy<>(Boat.Type.class,
            (Supplier<Block>) () -> ModBlocks.COCONUT_PLANKS,
            "smallships_ecologics_compat:coconut",
            (Supplier<Item>) () -> Items.AIR,
            (Supplier<Item>) () -> Items.AIR,
            (Supplier<Item>) () -> Items.STICK,
            false);
}
