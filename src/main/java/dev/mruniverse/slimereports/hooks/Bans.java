package dev.mruniverse.slimereports.hooks;

import java.util.UUID;

public interface Bans {
    void checkSame(String nick,UUID personalID,UUID uuid);

    void checkPrevention(String nick, UUID personalID, String resultIP);

    BanDatabase getData();

}
