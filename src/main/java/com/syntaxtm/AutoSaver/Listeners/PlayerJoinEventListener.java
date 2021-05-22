package com.syntaxtm.AutoSaver.Listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import com.syntaxtm.AutoSaver.AutoSaver;
import com.syntaxtm.AutoSaver.Utils.WorldUtils;

public final class PlayerJoinEventListener implements Listener {
	
	@SuppressWarnings("unused")
	private AutoSaver plugin;
	
	public PlayerJoinEventListener(AutoSaver plugin) {
		this.plugin = plugin;
		
		// register event with the plugin manager
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
    	WorldUtils.saveAllWorlds();
    }
    
}
