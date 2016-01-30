package pl.hari10.htools.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Util {

	private static String tag = "&8[&4>>&8]&7 ";
	
	public static String setColor(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
	public static void sendMessage(CommandSender player, String text) {
		player.sendMessage(tag + setColor(text));
	}
}
