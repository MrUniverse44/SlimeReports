package dev.mruniverse.slimereports.runnables;

import dev.mruniverse.slimereports.SlimeFiles;
import dev.mruniverse.slimereports.SlimeReports;
import dev.mruniverse.slimereports.SlimeSettings;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.ArrayList;
import java.util.Collection;

public class BanExecutor implements Runnable{
    private final SlimeReports slime;

    private final String nick;

    public BanExecutor(SlimeReports slime,String nick) {
        this.slime = slime;
        this.nick = nick;
    }

    @Override
    public void run() {
        String cmd = slime.getStorage().getControl(SlimeFiles.SETTINGS).getString(SlimeSettings.BAN_EVADING_COMMAND.get(),"ban " + nick + " This user is doing ban-evading -s");
        String notify = slime.getStorage().getControl(SlimeFiles.SETTINGS).getString(SlimeSettings.BAN_EVADING_NOTIFY_MESSAGE.get(),"&c%player% &7has been&c banned &7for&c ban-evading&7!");
        ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), cmd.replace("%player%",nick));
        Collection<ProxiedPlayer> collection = new ArrayList<>(ProxyServer.getInstance().getPlayers());
        TextComponent component = new TextComponent(
                ChatColor.translateAlternateColorCodes('&',notify.replace("%player%",nick))
        );
        if(slime.getStorage().getControl(SlimeFiles.SETTINGS).getString(SlimeSettings.BAN_EVADING_NOTIFY_TYPE.get(),"STAFF_ONLY").contains("STAFF")) {
            for (ProxiedPlayer player : collection) {
                if (hasPermission(player)) {
                    player.sendMessage(component);
                }
            }
            return;
        }
        for (ProxiedPlayer player : collection) {
            player.sendMessage(component);
        }
    }

    private boolean hasPermission(ProxiedPlayer player) {
        return player.hasPermission("litebans.notify") ||
                player.hasPermission("litebans.notify.broadcast") ||
                player.hasPermission("litebans.notify.muted") ||
                player.hasPermission("litebans.notify.warned") ||
                player.hasPermission("litebans.notify.warned.offline") ||
                player.hasPermission("litebans.notify.mute") ||
                player.hasPermission("litebans.notify.silent");
    }
}
