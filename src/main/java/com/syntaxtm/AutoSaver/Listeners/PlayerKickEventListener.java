package com.syntaxtm.AutoSaver.Listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerKickEvent;

import com.syntaxtm.AutoSaver.AutoSaver;
import com.syntaxtm.AutoSaver.Utils.WorldUtils;

public final class PlayerKickEventListener implements Listener {
	
	@SuppressWarnings("unused")
	private AutoSaver plugin;
	
	public PlayerKickEventListener(AutoSaver plugin) {
		this.plugin = plugin;
		
		// register event with the plugin manager
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	
    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
    	WorldUtils.saveAllWorlds();
    }
    
}
