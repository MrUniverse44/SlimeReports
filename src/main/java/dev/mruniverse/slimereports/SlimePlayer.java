package dev.mruniverse.slimereports;

import java.util.UUID;

@SuppressWarnings("unused")
public class SlimePlayer {
    private final String name;

    private final String current;

    private final UUID uuid;

    public SlimePlayer(String name,UUID uuid,String current) {
        this.name = name;
        this.uuid = uuid;
        this.current = current;
    }
    /**
     * Get the name of the Player if using bukkit or ProxiedPlayer if using bungeecord
     *
     * @return the name in a String
     **/
    public String getName() {
        return name;
    }

    /**
     * Get the uuid of the Player if using bukkit or ProxiedPlayer if using bungeecord
     *
     * @return the UniqueId in a UUID
     **/
    public UUID getUniqueId() {
        return uuid;
    }

    /**
     * Get the name of the world if using bukkit or the name of the server if using bungeecord
     *
     * @return the world or server in a String
     **/
    public String getServerOrWorld() {
        return current;
    }

}
