package dev.mruniverse.slimereports.commands.bungee;

import dev.mruniverse.slimereports.bungee.SlimeReports;
import dev.mruniverse.slimereports.SlimeUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class ReportsCommand extends Command {
    private final SlimeReports slime;

    private final SlimeUtils utils;

    private final String command;

    private final String prefix;

    public ReportsCommand(SlimeReports slime, String command) {
        super(command);
        this.slime = slime;
        this.command = command;
        this.utils = slime.getCommands().getSlimeUtils();
        this.prefix = "&8» &a/" + command;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
            // TODO
            return;
        }
        utils.send(sender,"&cWorking");
    }

    public void update() {
        //TODO
    }
}
