package com.syntaxtm.AutoSaver.Utils;

import java.util.List;
import java.util.NoSuchElementException;

import org.bukkit.Bukkit;
import org.bukkit.World;

import com.syntaxtm.AutoSaver.Logging.LogHelper;

public class WorldUtils {

	public static World getDefaultWorld() {
		List<World> worlds = getWorlds();
		
		if (worlds == null) throw new IllegalArgumentException("Worlds list cannot be null.");
		if (worlds.isEmpty()) throw new IllegalArgumentException("Worlds list cannot be empty.");
		
		return worlds.get(0);
	}
	
	public static World getWorld(String name) {
		if (name == null) throw new IllegalArgumentException("String name cannot be null");
		
		List<World> worlds = getWorlds();
		
		if (worlds == null) throw new IllegalArgumentException("Worlds list cannot be null.");
		if (worlds.isEmpty()) throw new IllegalArgumentException("Worlds list cannot be empty.");
		
		for (World world: worlds) {
			if (world.getName().equalsIgnoreCase(name)) {
				return world;
			}
		}
		
		throw new NoSuchElementException("No worlds named '" + name + "' were found.");
	}
	
	// TODO: add ability to ignore certain worlds, or better yet make settings be world-specific OR global
	public static List<World> getWorlds() {
		return Bukkit.getWorlds();
	}
	
	public static void saveDefaultWorld() {
		World world = getDefaultWorld();
		world.save();
	}
	
	public static void saveWorld(String name) {
		if (name == null) throw new IllegalArgumentException("String name cannot be null");
		
		World world = getWorld(name);
		world.save();
	}
	
	public static void saveAllWorlds() {
		for(World worlds: getWorlds()) {
		    worlds.save();
		}
		
		LogHelper.info("All worlds saved successfully.");
	}
	
}
