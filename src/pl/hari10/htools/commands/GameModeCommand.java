package pl.hari10.htools.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.hari10.htools.HTools;
import pl.hari10.htools.utils.Util;

public class GameModeCommand implements CommandExecutor {

	HTools plugin;
	
	public GameModeCommand(HTools plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("hari.command.gm")) {
			Util.sendMessage(sender, "Nie mozesz uzywac tej komendy!");
			return true;
		}
		
		if(args.length == 1) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				setGm(p, args);
				Util.sendMessage(sender, "Twoj tryb zostal zmieniony na &6" + p.getGameMode().toString() + "&7.");
				return true;
			} else {
				Util.sendMessage(sender, "Poprawne uzycie: &6/gamemode <survival/creative> <gracz>&7.");
			}
		}
		else if(args.length == 2) {
			Player other = Bukkit.getPlayerExact(args[1]);
			setGm(other, args);
			Util.sendMessage(other, "Twoj tryb zostal zmieniony na &6" + other.getGameMode().toString() + "&7.");
			Util.sendMessage(sender, "Zmieniles tryb gracza §6" + other.getName() + "§7 na §6" + other.getGameMode().toString() + "§7.");
			return true;
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	void setGm(Player p, String[] args) {
		GameMode gm;
		if(Character.isDigit(args[0].charAt(0))) {
			gm = GameMode.getByValue(Character.getNumericValue(args[0].charAt(0)));
		} else {
			gm = GameMode.valueOf(args[0].toUpperCase());
		}
		if(gm == null) {
			Util.sendMessage(p, "Poprawne uzycie: &6/gamemode <survival/creative> <gracz>&7.");
			return;
		}
		p.setGameMode(gm);
	}
}
