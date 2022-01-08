package dev.mruniverse.slimereports.runnables.bungee;

import dev.mruniverse.slimereports.bungee.SlimeReports;

import java.util.UUID;

public class BanVerificator implements Runnable {

    private final SlimeReports slime;

    private final UUID personalID;

    private final String nick;

    private final String ip;

    public BanVerificator(SlimeReports slime, String nick, UUID personalID, String ip) {
        this.slime = slime;
        this.personalID = personalID;
        this.ip = ip;
        this.nick = nick;
    }

    @Override
    public void run() {
        for(UUID uuid : slime.getBans().getData().getUsersByIP(ip)) {
            if(slime.getBans().getData().isPlayerBanned(uuid,null)) {
                slime.getBans().checkSame(nick,personalID,uuid);
            }
        }
    }


}
