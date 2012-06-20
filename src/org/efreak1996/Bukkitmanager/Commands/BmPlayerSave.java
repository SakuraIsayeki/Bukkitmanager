package org.efreak1996.Bukkitmanager.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.efreak1996.Bukkitmanager.IOManager;
import org.efreak1996.Bukkitmanager.Permissions;


public class BmPlayerSave {

	public static IOManager io;
	private static Permissions permHandler;
	
	public void initialize() {
		io = new IOManager();
		permHandler = new Permissions();
	}
	public void shutdown() {}
	
	public void cmd(CommandSender sender, String[] args, boolean prefixed) {
		if (prefixed) {
			if (args.length < 2) io.sendFewArgs(sender, "/bm player save [player]");
			else if (args.length > 3) io.sendManyArgs(sender, "/bm player save [player]");
			else {
				if (args.length == 2 && sender instanceof Player) {
					if (permHandler.has(sender, "bm.player.save")) {
						((Player) sender).saveData();
						io.send(sender, io.translate("Command.Player.Save").replaceAll("%player%", sender.getName()));
					}
				}else if (args.length == 3 && Bukkit.getPlayer(args[2]) != null) {
					if (permHandler.has(sender, "bm.player.save.other")) {
						Player player = Bukkit.getPlayer(args[2]);
						player.saveData();
						io.send(sender, io.translate("Command.Player.Save").replaceAll("%player%", sender.getName()));
					}
				}else if (args.length == 2) io.sendError(sender, io.translate("Command.Player.SpecifyPlayer"));
				else io.sendError(sender, io.translate("Command.Player.UnknownPlayer"));
			}
		}else {
			if (args.length < 1) io.sendFewArgs(sender, "/player save [player]");
			else if (args.length > 2) io.sendManyArgs(sender, "/player save [player]");
			else {
				if (args.length == 1 && sender instanceof Player) {
					if (permHandler.has(sender, "bm.player.save")) {
						((Player) sender).saveData();
						io.send(sender, io.translate("Command.Player.Save").replaceAll("%player%", sender.getName()));
					}
				}else if (args.length == 2 && Bukkit.getPlayer(args[1]) != null) {
					if (permHandler.has(sender, "bm.player.save.other")) {
						Player player = Bukkit.getPlayer(args[1]);
						player.saveData();
						io.send(sender, io.translate("Command.Player.Save").replaceAll("%player%", sender.getName()));
					}
				}else if (args.length == 1) io.sendError(sender, io.translate("Command.Player.SpecifyPlayer"));
				else io.sendError(sender, io.translate("Command.Player.UnknownPlayer"));
			}
		}
	}
}
