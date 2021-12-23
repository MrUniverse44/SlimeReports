package dev.mruniverse.slimereports.hooks;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

@SuppressWarnings("unused")
public interface BanDatabase {

    BanDatabase get();

    boolean isPlayerBanned(@Nullable UUID uuid, @Nullable String ip);

    boolean isPlayerBanned(@Nullable UUID uuid, @Nullable String ip, @Nullable String server);

    boolean isPlayerMuted(@Nullable UUID uuid, @Nullable String ip);

    boolean isPlayerMuted(@Nullable UUID uuid, @Nullable String ip, @Nullable String server);

    Collection<UUID> getUsersByIP(String ip);

    PreparedStatement prepareStatement(@NotNull String sql) throws SQLException;
}
