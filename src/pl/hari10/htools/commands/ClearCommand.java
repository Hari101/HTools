package pl.hari10.htools.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.hari10.htools.HTools;
import pl.hari10.htools.utils.Util;

public class ClearCommand implements CommandExecutor {

	HTools plugin;
	
	public ClearCommand(HTools plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("hari.command.clear")) {
			Util.sendMessage(sender, "Nie mozesz uzywac tej komendy!");
			return true;
		}
		
		if(args.length == 0) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				p.getInventory().clear();
				Util.sendMessage(p, "Wyczysciles swoj ekwipunek!");
				return true;
			} else {
				Util.sendMessage(sender, "Poprawne uzycie: &6/clear <gracz>&7.");
			}
		}
		else if(args.length == 1) {
			Player other = Bukkit.getPlayerExact(args[0]);
			if(other == null) {
				Util.sendMessage(sender, "Nie ma takiego gracza na serwerze!");
				return true;
			}
			other.getInventory().clear();
			Util.sendMessage(other, "Twoj ekwipunek zostal wyczyszczony!");
			Util.sendMessage(sender, "Wyczysciles ekwipunek gracza &6" + other.getName() + "&7.");
			return true;
		} else {
			Util.sendMessage(sender, "Poprawne uzycie: &6/clear <gracz>&7.");
		}
		return true;
	}
}
