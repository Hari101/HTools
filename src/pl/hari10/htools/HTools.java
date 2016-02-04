package pl.hari10.htools;

import org.bukkit.plugin.java.JavaPlugin;

import pl.hari10.htools.commands.ClearCommand;
import pl.hari10.htools.commands.FeedCommand;
import pl.hari10.htools.commands.FlyCommand;
import pl.hari10.htools.commands.GameModeCommand;
import pl.hari10.htools.commands.HealCommand;
import pl.hari10.htools.commands.TpCommand;
import pl.hari10.htools.commands.TpposCommand;

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
		getCommand("fly").setExecutor(new FlyCommand(this));
		getCommand("tp").setExecutor(new TpCommand(this));
		getCommand("tppos").setExecutor(new TpposCommand(this));
	}
}
