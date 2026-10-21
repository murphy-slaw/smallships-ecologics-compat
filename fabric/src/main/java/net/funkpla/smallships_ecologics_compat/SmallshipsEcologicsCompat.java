package net.funkpla.smallships_ecologics_compat;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.entity.vehicle.Boat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmallshipsEcologicsCompat implements ModInitializer {
	public static final String MOD_ID = "smallships-ecologics-compat";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        for (Boat.Type boat : Boat.Type.values()) {
            LOGGER.debug("{} => {}", boat.ordinal(), boat);
        }
	}
}