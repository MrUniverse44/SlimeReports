package dev.mruniverse.slimereports.commands;

import dev.mruniverse.slimereports.SlimeReports;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class GotoCommand extends Command {
    private final SlimeReports slime;

    private final String command;

    public GotoCommand(SlimeReports slime,String command) {
        super(command);
        this.slime = slime;
        this.command = command;

    }

    public void execute(CommandSender sender, String[] args) {

    }
}
