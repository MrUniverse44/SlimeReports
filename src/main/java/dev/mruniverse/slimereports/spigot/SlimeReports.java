package dev.mruniverse.slimereports.spigot;

import dev.mruniverse.guardianstorageapi.GuardianStorageAPI;
import dev.mruniverse.guardianstorageapi.enums.ControlType;
import dev.mruniverse.guardianstorageapi.inputs.SpigotInputManager;
import dev.mruniverse.guardianstorageapi.interfaces.FileStorage;
import dev.mruniverse.guardianstorageapi.interfaces.GLogger;
import dev.mruniverse.guardianstorageapi.logs.SpigotLogs;
import dev.mruniverse.guardianstorageapi.utils.GuardianHelper;
import dev.mruniverse.slimereports.SlimeFiles;
import dev.mruniverse.slimereports.hooks.Bans;
import org.bukkit.plugin.java.JavaPlugin;

public class SlimeReports extends JavaPlugin {
    private Bans bans;

    private SlimeCommands commands;

    private FileStorage storage;

    private GLogger logs;

    @Override
    public void onEnable() {
        logs = new SpigotLogs("SlimeReports", "dev.mruniverse.slimereports.", "dev.mruniverse")
                .setDebugPrefix("&8[&bSlimeReports&8] &7")
                .setErrorPrefix("&8[&cSlimeReports&8] &7")
                .setInfoPrefix("&8[&eSlimeReports&8] &7")
                .setWarnPrefix("&8[&dSlimeReports&8] &7");

        storage = new GuardianStorageAPI(ControlType.SPIGOT, logs)
                .setInputManager(new SpigotInputManager(this))
                .createStorage(
                        getDataFolder(),
                        GuardianHelper.process(SlimeFiles.class)
                );

        commands = new SlimeCommands(this);

        if(getStorage().getControl(SlimeFiles.SETTINGS).getStatus("settings.ban-evading.Enabled")) {
            if (getServer().getPluginManager().getPlugin("LiteBans") != null) {
                bans = new LiteBans(this);
            } else {
                bans = null;
            }
        }
    }

    public GLogger getLogs() {
        return logs;
    }

    public Bans getBans() {
        return bans;
    }

    public FileStorage getStorage() {
        return storage;
    }

    public SlimeCommands getCommands() {
        return commands;
    }
}
