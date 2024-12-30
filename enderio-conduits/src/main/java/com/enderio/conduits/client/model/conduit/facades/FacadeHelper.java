package com.enderio.conduits.client.model.conduit.facades;

import com.enderio.conduits.common.conduit.block.ConduitBundleBlockEntity;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.core.SectionPos;

// TODO: In future, support hiding specific conduit types too.
public class FacadeHelper {

    private static boolean FACADES_VISIBLE = true;

    public static void setFacadesVisible(boolean visible) {
        if (visible != FACADES_VISIBLE) {
            Set<SectionPos> facadeSections = new HashSet<>();

            ConduitBundleBlockEntity.FACADES.keySet().forEach((pos) -> facadeSections.add(SectionPos.of(pos)));

            RenderSystem.recordRenderCall(() -> {
                facadeSections.forEach((section) -> {
                    Minecraft.getInstance().levelRenderer.setSectionDirty(section.x(), section.y(), section.z());
                });
            });
        }

        FACADES_VISIBLE = visible;
    }

    public static boolean areFacadesVisible() {
        return FACADES_VISIBLE;
    }
}
