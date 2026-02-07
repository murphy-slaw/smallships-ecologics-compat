package net.funkpla.smallships_ecologics_compat;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.world.entity.vehicle.Boat;

import static net.funkpla.smallships_ecologics_compat.SmallshipsEcologicsCompat.LOGGER;

public class SmallshipsEcologicsCompatClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        for (Boat.Type boat : Boat.Type.values()) {
            LOGGER.debug("{} => {}", boat.ordinal(), boat);
        }
    }
}
