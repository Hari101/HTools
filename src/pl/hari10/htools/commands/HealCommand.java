package pl.hari10.htools.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import pl.hari10.htools.HTools;
import pl.hari10.htools.utils.Util;

public class HealCommand implements CommandExecutor {

	private HTools plugin;
	
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
				
			}
		}
		return false;
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
