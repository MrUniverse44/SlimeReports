package dev.mruniverse.slimereports.spigot;

import dev.mruniverse.slimereports.SlimeUtils;
import dev.mruniverse.slimereports.commands.spigot.GotoCommand;
import dev.mruniverse.slimereports.commands.spigot.ReloadCommand;
import dev.mruniverse.slimereports.commands.spigot.ReportCommand;
import dev.mruniverse.slimereports.commands.spigot.ReportsCommand;

public class SlimeCommands {
    private final SlimeUtils slimeUtils = new SlimeUtils();

    private final SlimeReports slime;

    private GotoCommand gotoCommand;

    private ReloadCommand reloadCommand;

    private ReportsCommand reportsCommand;

    private ReportCommand reportCommand;


    public SlimeCommands(SlimeReports slime) {
        this.slime = slime;
        init();
    }

    private void init() {

    }

    public void update() {
        gotoCommand.update();
        reloadCommand.update();
        reportsCommand.update();
        reportCommand.update();
    }

    public SlimeUtils getSlimeUtils() {
        return slimeUtils;
    }
}