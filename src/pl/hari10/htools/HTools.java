package pl.hari10.htools;

import org.bukkit.plugin.java.JavaPlugin;

import pl.hari10.htools.commands.ClearCommand;
import pl.hari10.htools.commands.FeedCommand;
import pl.hari10.htools.commands.GameModeCommand;
import pl.hari10.htools.commands.HealCommand;

public class HTools extends JavaPlugin {
	
	public void onEnable() {
		System.out.println("[HTools] Zostal uruchomiony pomyslnie!");
		registerCommand("[HTools] Pomyslnie zaladowano wszystkie komendy!");
	}
	
	public void registerCommand(String text) {
		System.out.println(text);
		getCommand("heal").setExecutor(new HealCommand(this));
		getCommand("feed").setExecutor(new FeedCommand(this));
		getCommand("gamemode").setExecutor(new GameModeCommand(this));
		getCommand("clear").setExecutor(new ClearCommand(this));
	}
}
