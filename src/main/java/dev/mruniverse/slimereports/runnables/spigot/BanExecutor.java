package dev.mruniverse.slimereports.runnables.spigot;

import dev.mruniverse.slimereports.SlimeFiles;
import dev.mruniverse.slimereports.SlimeSettings;
import dev.mruniverse.slimereports.spigot.SlimeReports;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;

public class BanExecutor extends BukkitRunnable {
    private final SlimeReports slime;

    private final String nick;

    public BanExecutor(SlimeReports slime, String nick) {
        this.slime = slime;
        this.nick = nick;
    }

    @Override
    public void run() {
        String cmd = slime.getStorage().getControl(SlimeFiles.SETTINGS).getString(SlimeSettings.BAN_EVADING_COMMAND.get(),"ban " + nick + " This user is doing ban-evading -s");
        String notify = slime.getStorage().getControl(SlimeFiles.SETTINGS).getString(SlimeSettings.BAN_EVADING_NOTIFY_MESSAGE.get(),"&c%player% &7has been&c banned &7for&c ban-evading&7!");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd.replace("%player%",nick));
        Collection<Player> collection = new ArrayList<>(slime.getServer().getOnlinePlayers());
        String component = ChatColor.translateAlternateColorCodes('&',notify.replace("%player%",nick));
        if(slime.getStorage().getControl(SlimeFiles.SETTINGS).getString(SlimeSettings.BAN_EVADING_NOTIFY_TYPE.get(),"STAFF_ONLY").contains("STAFF")) {
            for (Player player : collection) {
                if (hasPermission(player)) {
                    player.sendMessage(component);
                }
            }
            return;
        }
        for (Player player : collection) {
            player.sendMessage(component);
        }
    }

    private boolean hasPermission(Player player) {
        return player.hasPermission("litebans.notify") ||
                player.hasPermission("litebans.notify.broadcast") ||
                player.hasPermission("litebans.notify.muted") ||
                player.hasPermission("litebans.notify.warned") ||
                player.hasPermission("litebans.notify.warned.offline") ||
                player.hasPermission("litebans.notify.mute") ||
                player.hasPermission("litebans.notify.silent");
    }
}
