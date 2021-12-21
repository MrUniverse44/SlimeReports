package dev.mruniverse.slimereports;

import dev.mruniverse.slimereports.commands.*;

public class SlimeCommands {
    private final SlimeReports slime;

    private AcceptHistoryCommand acceptHistoryCommand;

    private GotoCommand gotoCommand;

    private ReloadCommand reloadCommand;

    private RemoveHistoryCommand removeHistoryCommand;

    private ReportsCommand reportsCommand;

    private ReportCommand reportCommand;


    public SlimeCommands(SlimeReports slime) {
        this.slime = slime;
        init();
    }

    private void init() {

    }

    public void update() {

    }
}
