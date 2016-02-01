package pl.hari10.htools.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.hari10.htools.HTools;
import pl.hari10.htools.utils.Util;

public class FlyCommand implements CommandExecutor {

	HTools plugin;
	
	public FlyCommand(HTools plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("hari.command.fly")) {
			Util.sendMessage(sender, "Nie mozesz uzywac tej komendy!");
			return true;
		}
		
		if(args.length == 0) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(!p.getAllowFlight()) {
					p.setAllowFlight(true);
					Util.sendMessage(p, "Tryb latania zostal wlaczony!");
					return true;
				} else {
					p.setAllowFlight(false);
					Util.sendMessage(p, "Tryb latania zostal wylaczony!");
					return true;
				}
			} else {
				Util.sendMessage(sender, "Poprawne uzycie: &6/fly <gracz>&7.");
			}
		}
		else if(args.length == 1) {
			Player other = Bukkit.getPlayerExact(args[0]);
			if(other == null) {
				Util.sendMessage(sender, "Nie ma takiego gracza na serwerze!");
				return true;
			} else {
				if(!other.getAllowFlight()) {
					other.setAllowFlight(true);
					Util.sendMessage(other, "Tryb latania zostal wlaczony!");
					Util.sendMessage(sender, "Tryb latania zostal wlaczony dla gracza &6" + other.getDisplayName() + "&7.");
					return true;
				} else {
					other.setAllowFlight(false);
					Util.sendMessage(other, "Tryb latania zostal wylaczony!");
					Util.sendMessage(sender, "Tryb latania zostal wylaczony dla gracza &6" + other.getDisplayName() + "&7.");
					return true;
				}
			}
		} else {
			Util.sendMessage(sender, "Poprawne uzycie: &6/fly <gracz>&7.");
		}
		return true;
	}
}
