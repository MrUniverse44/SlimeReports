package dev.mruniverse.slimereports.spigot;

import dev.mruniverse.slimereports.hooks.BanDatabase;
import dev.mruniverse.slimereports.hooks.Bans;
import dev.mruniverse.slimereports.hooks.LiteBansDatabase;
import dev.mruniverse.slimereports.runnables.spigot.BanExecutor;
import dev.mruniverse.slimereports.runnables.spigot.BanVerificator;
import litebans.api.Database;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.net.InetAddress;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class LiteBans implements Listener, Bans {
    private final SlimeReports slime;
    private BanDatabase database;

    public LiteBans(SlimeReports slime) {
        this.slime = slime;
        try {
            database = new LiteBansDatabase().get();
            slime.getLogs().info("Enabled hook with LiteBans");
        } catch (Throwable ignored) {
            this.database = null;
            slime.getLogs().info("You don't have installed LiteBans, Auto-Ban-Evading Disabled");
        }
    }

    @EventHandler
    public void onConnect(PlayerLoginEvent event) {
        if (database != null) {
            final Player player = event.getPlayer();
            UUID personalID = player.getUniqueId();
            String nick = player.getName();
            InetAddress address = event.getAddress();
            String ip = address.getHostAddress();
            slime.getLogs().debug(ip);
            new BanVerificator(slime, nick, personalID, ip).runTaskTimer(slime,0L,20L);
        }
    }

    public void checkSame(String nick, UUID personalID, UUID uuid) {
        String id = uuid.toString();
        String query = "SELECT * FROM {bans} WHERE uuid=?";
        try (PreparedStatement st = Database.get().prepareStatement(query)) {
            st.setString(1, id);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    String resultIP = rs.getString("ip");
                    boolean active = rs.getBoolean("active");
                    if (active) {
                        checkPrevention(nick, personalID, resultIP);
                    }
                    rs.close();
                }
                st.close();
            }
        } catch (Throwable throwable) {
            slime.getLogs().error(throwable);
        }
    }

    public void checkPrevention(String nick, UUID personalID, String resultIP) {
        String toString = personalID.toString();
        for (UUID uuid : database.getUsersByIP(resultIP)) {
            if (uuid.toString().equalsIgnoreCase(toString)) {
                new BanExecutor(slime, nick).runTaskTimer(slime,0L,20L);
            }
        }
    }

    public BanDatabase getData() {
        return database;
    }
}
