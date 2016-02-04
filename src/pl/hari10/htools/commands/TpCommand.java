package pl.hari10.htools.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.hari10.htools.HTools;
import pl.hari10.htools.utils.Util;

public class TpCommand implements CommandExecutor {

	HTools plugin;
	
	public TpCommand(HTools plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("hari.command.tp")) {
			Util.sendMessage(sender, "Nie mozesz uzywac tej komendy!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(args.length == 1) {
			Player other = Bukkit.getPlayerExact(args[0]);
			if(other == null) {
				Util.sendMessage(sender, "Nie ma takiego gracza na serwerze!");
				return true;
			} else {
				p.teleport(other.getLocation());
				Util.sendMessage(p, "Zostales teleportowany do gracza &6" + other.getName() + "&7.");
				return true;
			}
		}
		
		else if(args.length == 2) {
			Player other = Bukkit.getPlayerExact(args[0]);
			Player other2 = Bukkit.getPlayerExact(args[1]);
			if(other != null) {
				if(other2 != null) {
					other.teleport(other2.getLocation());
					Util.sendMessage(other, "Zostales przeteleportowany do gracza &6" + other2.getName() + "&7.");
					Util.sendMessage(sender, "Przeteleportowano gracza &6" + other.getName() + " &7do gracza &6" + other.getName() + "&7.");
					return true;
				} else {
					Util.sendMessage(sender, "Nie ma takiego gracza na serwerze!");
				}
			} else {
				Util.sendMessage(sender, "Nie ma takiego gracza na serwerze!");
			}
		} else {
			Util.sendMessage(sender, "Poprawne uzycie: &6/tp <gracz> <inny gracz>&7.");
		}
		return true;
	}
}
