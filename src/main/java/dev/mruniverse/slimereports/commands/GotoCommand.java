package dev.mruniverse.slimereports.commands;

import dev.mruniverse.slimereports.SlimeReports;
import dev.mruniverse.slimereports.SlimeUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class GotoCommand extends Command {
    private final SlimeReports slime;

    private final SlimeUtils utils;

    private final String command;

    private final String prefix;

    public GotoCommand(SlimeReports slime,String command) {
        super(command);
        this.slime = slime;
        this.command = command;
        this.utils = slime.getCommands().getSlimeUtils();
        this.prefix = "&8» &a/" + command;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
            /*
             * WORKING
             */
            return;
        }
        utils.send(sender,"&cWorking");
    }

    @SuppressWarnings("unused")
    public void update() {

    }
}
