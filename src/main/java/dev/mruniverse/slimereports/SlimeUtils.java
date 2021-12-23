package dev.mruniverse.slimereports;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class SlimeUtils {
    public boolean hasPermission(CommandSender sender, String permission) {
        if(sender instanceof ProxiedPlayer) {
            return (sender.hasPermission(permission) || sender.hasPermission("slimereports.*") || sender.hasPermission("slimereports.usage.*"));
        }
        return true;
    }

    public void send(CommandSender sender,String message) {
        if(message == null) message = "Unknown Message";
        message = ChatColor.translateAlternateColorCodes('&',message);
        sender.sendMessage(new TextComponent(message));
    }

    public void send(CommandSender sender, List<String> list,SlimeListFormat format) {
        if(format == SlimeListFormat.MULTI_MESSAGE) {
            for (String value : list) {
                value = ChatColor.translateAlternateColorCodes('&', value);
                sender.sendMessage(new TextComponent(value));
            }
            return;
        }
        sender.sendMessage(SlimeListFormat.ListToComponent(list));
    }

    public void send(CommandSender sender, List<String> list) {
        for (String value : list) {
            value = ChatColor.translateAlternateColorCodes('&', value);
            sender.sendMessage(new TextComponent(value));
        }
    }

    public void send(CommandSender sender, List<String> list,SlimeReplacer replacer) {
        for (String value : list) {
            value = ChatColor.translateAlternateColorCodes('&', replacer.replace(value));
            sender.sendMessage(new TextComponent(value));
        }
    }

    public void send(CommandSender sender, List<String> list,SlimeListFormat format,SlimeReplacer replacer) {
        if(format == SlimeListFormat.MULTI_MESSAGE) {
            for (String value : list) {
                value = ChatColor.translateAlternateColorCodes('&', value);
                sender.sendMessage(new TextComponent(value));
            }
            return;
        }
        sender.sendMessage(SlimeListFormat.ListToComponent(list,replacer));
    }

    public enum SlimeListFormat {
        SINGLE_MESSAGE,
        MULTI_MESSAGE;

        public static TextComponent ListToComponent(List<String> list) {
            TextComponent builder = new TextComponent();
            int line = 0;
            int maxLine = list.size();
            for (String lines : list) {
                lines = ChatColor.translateAlternateColorCodes('&',lines);
                line++;
                builder.addExtra(lines);
                if(line != maxLine) {
                    builder.addExtra("\n");
                }
            }
            return builder;
        }

        public static TextComponent ListToComponent(List<String> list,SlimeReplacer replacer) {
            TextComponent builder = new TextComponent();
            int line = 0;
            int maxLine = list.size();
            for (String lines : list) {
                lines = ChatColor.translateAlternateColorCodes('&',replacer.replace(lines));
                line++;
                builder.addExtra(lines);
                if(line != maxLine) {
                    builder.addExtra("\n");
                }
            }
            return builder;
        }
    }

    public static class SlimeReplacer {
        Map<String,String> replaceable = new HashMap<>();

        public void addReplacer(String key,String value) {
            replaceable.put(key,value);
        }

        public String replace(String message) {
            for(Map.Entry<String,String> entry : replaceable.entrySet()) {
                message = message.replace(entry.getKey(),entry.getValue());
            }
            return message;
        }
    }
}
