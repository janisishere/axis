package at.axis.apiDepends;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ConfigAPIChangeEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final String path;
    private final Object oldValue;
    private final Object newValue;

    public ConfigAPIChangeEvent(String path, @Nullable Object oldValue, @Nullable Object newValue) {
        this.path = path;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getPath() { return path; }
    public @Nullable Object getOldValue() { return oldValue; }
    public @Nullable Object getNewValue() { return newValue; }

    @Override public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}
