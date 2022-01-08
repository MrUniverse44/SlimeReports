package dev.mruniverse.slimereports.api;

import dev.mruniverse.slimereports.SlimePlayer;

import java.util.Date;

@SuppressWarnings("unused")
public class PunishmentEntry {

    private final SlimePlayer user;
    private final Date date;
    private final String reason;

    public PunishmentEntry(SlimePlayer user,Date date,String reason) {
        this.user = user;
        this.date = date;
        this.reason = reason;
    }

    /**
     * Get the SlimePlayer of the punished user, here you can get the name, uuid and the server or world of the player.
     *
     * @return the PlayerInfo in a SlimePlayer
     **/
    public SlimePlayer getUser() {
        return user;
    }

    /**
     * Get the DateFormat of the punishment
     *
     * @return the report-date in a DateFormat
     **/
    public Date getDate() {
        return date;
    }

    /**
     * Get the reason of the punishment
     *
     * @return the reason in a String
     **/
    public String getReason() {
        return reason;
    }
}
