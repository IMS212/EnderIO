package com.enderio.armory.common.init;

import com.enderio.armory.api.capability.IDarkSteelUpgradable;
import com.enderio.base.api.EnderIO;
import net.neoforged.neoforge.capabilities.ItemCapability;

public class ArmoryCapabilities {
    public static final class DarkSteelUpgradable {
        public static final ItemCapability<IDarkSteelUpgradable, Void> ITEM =
            ItemCapability.createVoid(
                EnderIO.loc("dark_steel_upgradable"),
                IDarkSteelUpgradable.class);
    }
}
