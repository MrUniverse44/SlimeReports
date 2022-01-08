package dev.mruniverse.slimereports.api.spigot;

import dev.mruniverse.slimereports.api.ReportEntry;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@SuppressWarnings("unused")
public class PlayerReportEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final ReportEntry entry;
    private boolean cancel = false;

    public PlayerReportEvent(ReportEntry entry) {
        this.entry = entry;
    }

    public ReportEntry getEntry() {
        return entry;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
