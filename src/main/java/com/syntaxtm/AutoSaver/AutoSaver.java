package com.syntaxtm.AutoSaver;

import org.bukkit.plugin.java.JavaPlugin;

import com.syntaxtm.AutoSaver.Listeners.PlayerChangedWorldEventListener;
import com.syntaxtm.AutoSaver.Listeners.PlayerJoinEventListener;
import com.syntaxtm.AutoSaver.Listeners.PlayerKickEventListener;
import com.syntaxtm.AutoSaver.Listeners.PlayerLoginEventListener;
import com.syntaxtm.AutoSaver.Listeners.PlayerQuitEventListener;
import com.syntaxtm.AutoSaver.Logging.LogHelper;

public final class AutoSaver extends JavaPlugin {
	
	private AutoSaverConfig config;
	
    @Override
    public void onEnable() {
    	// set the static plugin to this so that the LogHelper can access the bukkit log functions
    	LogHelper.setPlugin(this);
    	
    	// ensure that a config.yml exists (for first start)
    	saveDefaultConfig();
    	
    	// config uses the singleton pattern to keep one instance and we need this to know
    	// what event listeners to register/skip
    	config = AutoSaverConfig.getInstance();
    	
    	LogHelper.debug("Registering event listeners...");    	
    	
    	// register the block break event with the server's plug-in manager
		if (config.getSaveOnLogin())
			new PlayerLoginEventListener(this);
		if (config.getSaveOnQuit())
			new PlayerQuitEventListener(this);
		if (config.getSaveOnJoin())
			new PlayerJoinEventListener(this);
		if (config.getSaveOnKick())
			new PlayerKickEventListener(this);
		if (config.getSaveOnWorldChange())
			new PlayerChangedWorldEventListener(this);
		
		LogHelper.debug("Registered event listeners.");
    }

    @Override
    public void onDisable() {
        // called when the plug-in is disabled
    }

}