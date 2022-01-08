package dev.mruniverse.slimereports.api.bungee;

import dev.mruniverse.slimereports.api.ReportEntry;
import net.md_5.bungee.api.plugin.Cancellable;
import net.md_5.bungee.api.plugin.Event;

@SuppressWarnings("unused")
public class PlayerReportEvent extends Event implements Cancellable {
    private final ReportEntry entry;
    private boolean cancel = false;

    public PlayerReportEvent(ReportEntry entry) {
        this.entry = entry;
    }

    public ReportEntry getEntry() {
        return entry;
    }

    /**
     * Get whether this event is cancelled.
     *
     * @return the cancelled state of this event
     */
    @Override
    public boolean isCancelled() {
        return cancel;
    }

    /**
     * Sets the cancelled state of this event.
     *
     * @param cancel the state to set
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
