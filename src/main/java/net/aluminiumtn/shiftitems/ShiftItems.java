package net.aluminiumtn.shiftitems;

import net.fabricmc.api.ModInitializer;

public class ShiftItems implements ModInitializer {
    @Override
    public void onInitialize() {
        AutoCollectHandler.register();
        System.out.println("ShiftItems has been initialized.");
    }
}
