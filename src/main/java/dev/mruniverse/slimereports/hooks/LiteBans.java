package dev.mruniverse.slimereports.hooks;

import dev.mruniverse.slimereports.SlimeReports;
import dev.mruniverse.slimereports.runnables.BanExecutor;
import dev.mruniverse.slimereports.runnables.BanVerificator;
import litebans.api.Database;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class LiteBans implements Listener,Bans {
    private final SlimeReports slime;
    private BanDatabase database;

    public LiteBans(SlimeReports slime) {
        this.slime = slime;
        try {
            database = new LiteBansDatabase().get();
            slime.getLogs().info("Enabled hook with LiteBans");
        }catch (Throwable ignored) {
            this.database = null;
            slime.getLogs().info("You don't have installed LiteBans, Auto-Ban-Evading Disabled");
        }
    }

    @EventHandler
    public void onConnect(LoginEvent event) {
        if(database != null) {
            UUID personalID = event.getConnection().getUniqueId();
            String nick = event.getConnection().getName();
            String ip = event.getConnection().getSocketAddress().toString();
            slime.getLogs().debug(ip);
            slime.getProxy().getScheduler().schedule(slime,new BanVerificator(slime,nick,personalID,ip),3, TimeUnit.SECONDS);
        }
    }

    public void checkSame(String nick,UUID personalID,UUID uuid) {
        String id = uuid.toString();
        String query = "SELECT * FROM {bans} WHERE uuid=?";
        try (PreparedStatement st = Database.get().prepareStatement(query)) {
            st.setString(1, id);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    String resultIP = rs.getString("ip");
                    boolean active = rs.getBoolean("active");
                    if(active) {
                        checkPrevention(nick,personalID,resultIP);
                    }
                    rs.close();
                }
                st.close();
            }
        } catch (Throwable throwable) {
            slime.getLogs().error(throwable);
        }
    }

    public void checkPrevention(String nick,UUID personalID,String resultIP) {
        String toString = personalID.toString();
        for(UUID uuid : database.getUsersByIP(resultIP)) {
            if(uuid.toString().equalsIgnoreCase(toString)){
                slime.getProxy().getScheduler().schedule(slime,new BanExecutor(slime,nick),3, TimeUnit.SECONDS);
            }
        }
    }

    public BanDatabase getData() {
        return database;
    }


}
