package dev.mruniverse.slimereports;

import dev.mruniverse.slimereports.commands.*;

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
