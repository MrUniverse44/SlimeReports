package dev.mruniverse.slimereports;

import dev.mruniverse.guardianstorageapi.GuardianStorageAPI;
import dev.mruniverse.guardianstorageapi.enums.ControlType;
import dev.mruniverse.guardianstorageapi.inputs.BungeeInputManager;
import dev.mruniverse.guardianstorageapi.interfaces.FileStorage;
import dev.mruniverse.guardianstorageapi.interfaces.GLogger;
import dev.mruniverse.guardianstorageapi.logs.BungeeLogs;
import dev.mruniverse.guardianstorageapi.utils.GuardianHelper;
import dev.mruniverse.slimereports.hooks.Bans;
import dev.mruniverse.slimereports.hooks.LiteBans;
import net.md_5.bungee.api.plugin.Plugin;

public final class SlimeReports extends Plugin {

    private Bans bans;

    private SlimeCommands commands;

    private FileStorage storage;

    private GLogger logs;

    @Override
    public void onEnable() {
        logs = new BungeeLogs(this, "SlimeReports", "dev.mruniverse.slimereports.")
                .setDebugPrefix("&8[&bSlimeReports&8] &7")
                .setErrorPrefix("&8[&cSlimeReports&8] &7")
                .setInfoPrefix("&8[&eSlimeReports&8] &7")
                .setWarnPrefix("&8[&dSlimeReports&8] &7");

        storage = new GuardianStorageAPI(ControlType.BUNGEECORD, logs)
                .setInputManager(new BungeeInputManager(this))
                .createStorage(
                        getDataFolder(),
                        GuardianHelper.process(SlimeFiles.class)
                );

        commands = new SlimeCommands(this);

        if(getStorage().getControl(SlimeFiles.SETTINGS).getStatus("settings.ban-evading.Enabled")) {
            if (getProxy().getPluginManager().getPlugin("LiteBans") != null) {
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

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
