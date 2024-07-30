package me.spzla.itemnames.access;

import net.minecraft.component.ComponentType;

public interface ItemStackAccessor {
    boolean contains(ComponentType<?> type);

    default <T> T get(ComponentType<? extends T> type) {
        return null;
    }
}