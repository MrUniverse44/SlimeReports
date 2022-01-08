package dev.mruniverse.slimereports.api;

import dev.mruniverse.slimereports.SlimePlayer;

import java.text.DateFormat;

@SuppressWarnings("unused")
public class ReportEntry {

    private final SlimePlayer reporter;
    private final SlimePlayer reported;
    private final DateFormat date;
    private final String reason;

    public ReportEntry(SlimePlayer reporter,SlimePlayer reported,DateFormat date,String reason) {
        this.reported = reported;
        this.reporter = reporter;
        this.reason = reason;
        this.date = date;
    }

    /**
     * Get the SlimePlayer of the reported user, here you can get the name, uuid and the server or world of the player.
     *
     * @return the PlayerInfo in a SlimePlayer
     **/
    public SlimePlayer getReported() {
        return reported;
    }

    /**
     * Get the SlimePlayer of the reporter user, here you can get the name, uuid and the server or world of the player.
     *
     * @return the PlayerInfo in a SlimePlayer
     **/
    public SlimePlayer getReporter() {
        return reporter;
    }

    /**
     * Get the DateFormat of the report
     *
     * @return the report-date in a DateFormat
     **/
    public DateFormat getDate() {
        return date;
    }

    /**
     * Get the reason of the report
     *
     * @return the reason in a String
     **/
    public String getReason() {
        return reason;
    }
}
