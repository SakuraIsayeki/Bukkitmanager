package org.efreak1996.Bukkitmanager.PluginManager.Updater.DevBukkit;

import java.net.MalformedURLException;
import java.net.URL;

import org.efreak1996.Bukkitmanager.PluginManager.Updater.PluginPage;


public class DB_PluginPage extends PluginPage {
	
	public DB_PluginPage() {
		super();
		try {
			mainUrl = new URL("http://dev.bukkit.org/server-mods/");
		} catch (MalformedURLException e) {
			if (config.getDebug()) e.printStackTrace();
		}
	}
	
}