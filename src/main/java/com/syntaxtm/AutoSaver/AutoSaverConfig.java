package com.syntaxtm.AutoSaver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

public class AutoSaverConfig implements ConfigurationSerializable {

	private static File file = new File("plugins/AutoSaver/config.yml");
    private static YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
	
    private static AutoSaverConfig _instance;
    
    private boolean auto_save;
    private int auto_save_interval;
    private boolean save_on_login;
    private boolean save_on_quit;
    private boolean save_on_join;
    private boolean save_on_kick;
    private boolean save_on_world_change;
    
    public boolean getAutoSave() {
    	return this.auto_save;
    }
    
    public int getAutoSaveInterval() {
    	return this.auto_save_interval;
    }
    
    public boolean getSaveOnLogin() {
    	return this.save_on_login;
    }
    
    public boolean getSaveOnQuit() {
    	return this.save_on_quit;
    }
    
    public boolean getSaveOnJoin() {
    	return this.save_on_join;
    }
    
    public boolean getSaveOnKick() {
    	return this.save_on_kick;
    }
    
    public boolean getSaveOnWorldChange() {
    	return this.save_on_world_change;
    }
    
    public AutoSaverConfig() {
    	
    }
    
    public AutoSaverConfig(Map<String, Object> map) {
        this.auto_save = (Boolean) map.get("auto_save");
        this.auto_save_interval = (Integer) map.get("auto_save_interval");
        this.save_on_login = (Boolean) map.get("save_on_login");
        this.save_on_quit = (Boolean) map.get("save_on_quit");
    	this.save_on_join = (Boolean) map.get("save_on_join");
    	this.save_on_kick = (Boolean) map.get("save_on_kick");
    	this.save_on_world_change = (Boolean) map.get("save_on_world_change");
    }
    
    public static AutoSaverConfig getInstance() {
    	if (_instance != null) return _instance;
    	_instance = loadConfig();
    	return _instance;
    }

    public static AutoSaverConfig deserialize(Map<String, Object> map) {
        return new AutoSaverConfig(map);
    }

    public static AutoSaverConfig valueOf(Map<String, Object> map) {
        return new AutoSaverConfig(map);
    }

    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("auto_save", auto_save);
        map.put("auto_save_interval", auto_save_interval);
        map.put("save_on_login", save_on_login);
        map.put("save_on_quit", save_on_quit);
        map.put("save_on_join", save_on_join);
        map.put("save_on_kick", save_on_kick);
        map.put("save_on_world_change", save_on_world_change);

        return map;
    }
    
    private void validate() {
    	if (auto_save_interval < 1) throw new IllegalArgumentException("auto_save_interval cannot be less than 1");
    }
    
	private static AutoSaverConfig loadConfig() {
		// this will copy any missing/new keys in the default config.yml to the existing file
        config.options().copyDefaults(true);
        
        // loads the map from the file
        Map<String, Object> loadedMap = config.getValues(true);        
        
        // use the constructor with the map param to create an instance of AutoSaverConfig
        AutoSaverConfig loadedConfig = new AutoSaverConfig(loadedMap);
        
        // validate that the config settings are within allowed values
        loadedConfig.validate();
        
        return loadedConfig;
    }
	
}
