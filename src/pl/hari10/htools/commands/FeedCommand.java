package pl.hari10.htools.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.hari10.htools.HTools;
import pl.hari10.htools.utils.Util;

public class FeedCommand implements CommandExecutor {

	HTools plugin;
	
	public FeedCommand(HTools plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("hari.command.feed")) {
			Util.sendMessage(sender, "Nie mozesz uzywac tej komendy!");
			return true;
		}
		
		if(args.length == 0) {
			if(sender instanceof Player) {
				((Player) sender).setFoodLevel(20);
				Util.sendMessage(sender, "Zostales nakarmiony!");
				return true;
			} else {
				Util.sendMessage(sender, "Poprawne uzycie: &6/feed <gracz>&7.");
			}
		}
		else if(args.length == 1) {
			Player other = Bukkit.getPlayerExact(args[0]);
			if(other == null) {
				Util.sendMessage(sender, "Nie ma takiego gracza na serwerze!");
				return true;
			}
			other.setFoodLevel(20);
			Util.sendMessage(other, "Zostales nakarmiony!");
			Util.sendMessage(sender, "Nakarmiles gracza &6" + other.getName() + "&7.");
			return true;
		} else {
			Util.sendMessage(sender, "Poprawne uzycie: &6/feed <gracz>&7.");
		}
		return true;
	}
}
