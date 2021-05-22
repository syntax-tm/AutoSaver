package com.syntaxtm.AutoSaver.Listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import com.syntaxtm.AutoSaver.AutoSaver;
import com.syntaxtm.AutoSaver.Utils.WorldUtils;

public final class PlayerChangedWorldEventListener implements Listener {
	
	@SuppressWarnings("unused")
	private AutoSaver plugin;
	
	public PlayerChangedWorldEventListener(AutoSaver plugin) {
		this.plugin = plugin;
		
		// register event with the plugin manager
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	
    @EventHandler
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
    	WorldUtils.saveAllWorlds();
    }
    
}
