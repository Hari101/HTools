package pl.hari10.htools.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.hari10.htools.HTools;
import pl.hari10.htools.utils.Util;

public class TpposCommand implements CommandExecutor {

	HTools plugin;
	
	public TpposCommand(HTools plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("hari.command.tppos")) {
			Util.sendMessage(sender, "Nie mozesz uzywac tej komendy!");
			return true;
		}
		
		Player p = (Player) sender;
		Location l = p.getLocation();
		
		if(args.length == 3) {
			if(sender instanceof Player) {
				teleport(p, args);
				Util.sendMessage(p, "Przeteleportowano na koordynaty x: &6" + l.getBlockX() + " &7y: &6" + l.getBlockY() + " &7z: &6" + l.getBlockZ() + "&7.");
				return true;
			} else {
				Util.sendMessage(sender, "Poprawne uzycie: &6/tpp <x> <y> <z> <gracz>&7.");
			}
		}
		
		else if(args.length == 4) {
			Player other = Bukkit.getPlayerExact(args[3]);
			if(other == null) {
				Util.sendMessage(sender, "Nie ma takiego gracza na serwerze!");
				return true;
			} else {
				teleport(other, args);
				Util.sendMessage(other, "Przeteleportowano na koordynaty x: &6" + other.getLocation().getBlockX() + " &7y: &6" + other.getLocation().getBlockY() + " &7z: &6" + other.getLocation().getBlockZ() + "&7.");
				Util.sendMessage(sender, "Przeteleportowales gracza &6" + other.getName() + " &7na koordynaty x: &6" + other.getLocation().getBlockX() + " &7y: &6" + other.getLocation().getBlockY() + " &7z: &6" + other.getLocation().getBlockZ() + "&7.");
			}
		} else {
			Util.sendMessage(sender, "Poprawne uzycie: &6/tpp <x> <y> <z> <gracz>&7.");
		}
		return true;
	}
	
	void teleport(Player p, String[] args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int z = Integer.parseInt(args[2]);
		Location loc = new Location(p.getWorld(), x, y, z);	
		try {
			p.teleport(loc);
		} catch(NumberFormatException e) {
			Util.sendMessage(p, "Nie mozesz uzywac liczb po przecinku!");
			return;
		}
	}
}
