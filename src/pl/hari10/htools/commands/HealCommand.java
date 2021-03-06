package pl.hari10.htools.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import pl.hari10.htools.HTools;
import pl.hari10.htools.utils.Util;

public class HealCommand implements CommandExecutor {

	HTools plugin;
	
	public HealCommand(HTools plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("hari.command.heal")) {
			Util.sendMessage(sender, "Nie mozesz uzywac tej komendy!");
			return true;
		}
		
		if(args.length == 0) {
			if(sender instanceof Player) {
				healPlayer((Player) sender);
				Util.sendMessage(sender, "Zostales uleczony!");
				return true;
			} else {
				Util.sendMessage(sender, "Poprawne uzycie: &6/heal <gracz>&7.");
			}
		}
		else if(args.length == 1) {
			Player other = Bukkit.getPlayerExact(args[0]);
			if(other == null) {
				Util.sendMessage(sender, "Nie ma takiego gracza na serwerze!");
				return true;
			}
			healPlayer(other);
			Util.sendMessage(other, "Zostales uleczony!");
			Util.sendMessage(sender, "Uleczyles gracza &6" + other.getName() + "&7.");
			return true;
		} else {
			Util.sendMessage(sender, "Poprawne uzycie: &6/heal <gracz>&7.");
		}
		return true;
	}
	
	void healPlayer(Player p) {
		p.setHealth(20.0);
		p.setFoodLevel(20);
		p.setFireTicks(0);
		for(PotionEffect pf : p.getActivePotionEffects()) {
			p.removePotionEffect(pf.getType());
		}
	}
}
