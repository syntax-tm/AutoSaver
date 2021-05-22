package com.syntaxtm.AutoSaver.Utils;

import org.bukkit.entity.Player;

import com.syntaxtm.AutoSaver.Logging.LogHelper;

public final class PlayerUtils
{
	// TODO: move constants here to config.yml
	private final static boolean USE_EXP_MULTIPLIER = true;
	
	public static void addExpToPlayer(Player player, int exp) {
		if (player == null) throw new IllegalArgumentException("Player player cannot be null");
		if (exp < 0) throw new IllegalArgumentException("int exp must be greater than 0");
		
		addExpToPlayer(player, exp, 1);
	}
	
	public static void addExpToPlayer(Player player, int exp, int multiplier) {
		if (player == null) throw new IllegalArgumentException("Player player cannot be null");
		if (exp < 0) throw new IllegalArgumentException("int exp must be greater than 0");
		if (multiplier < 0) throw new IllegalArgumentException("int multiplier must be greater than 0");
		
		// give the player the exp from a normal drop multiplied by the amount of material dropping
		int earnedExp = USE_EXP_MULTIPLIER ? exp * multiplier : exp;
        
        player.giveExp(earnedExp);
        
        LogHelper.debug("Added " + earnedExp + " exp to " + player.getName() + " (" + exp + " * " + multiplier + " multiplier).");
	}	
}
