package dev.mruniverse.slimereports.hooks;

import litebans.api.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

public class LiteBansDatabase implements BanDatabase{

    private Database database = null;

    @Override
    public BanDatabase get() {
        database = Database.get();
        return this;
    }

    @Override
    public boolean isPlayerBanned(UUID uuid, String ip) {
        return database.isPlayerBanned(uuid,ip);
    }

    @Override
    public boolean isPlayerBanned(UUID uuid, String ip, String server) {
        return database.isPlayerBanned(uuid,ip,server);
    }

    @Override
    public boolean isPlayerMuted(UUID uuid, String ip) {
        return database.isPlayerMuted(uuid,ip);
    }

    @Override
    public boolean isPlayerMuted(UUID uuid, String ip, String server) {
        return database.isPlayerMuted(uuid,ip,server);
    }

    @Override
    public Collection<UUID> getUsersByIP(String ip) {
        return database.getUsersByIP(ip);
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return database.prepareStatement(sql);
    }
}
