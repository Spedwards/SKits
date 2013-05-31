package com.theaetherserver.kits.events.killstreaks;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;

public class KillstreakManagement {
	@SuppressWarnings("unused")
	private Main plugin;
	public KillstreakManagement(Main plugin){
		this.plugin = plugin;
	}
	public static final ArrayList<String> fourKillstreak = new ArrayList<String>();
	public static final ArrayList<String> sixKillstreak = new ArrayList<String>();
	public static final ArrayList<String> tenKillstreak = new ArrayList<String>();
	
	public static boolean isKillstreak(Player player){
		if(player.getLevel() >= 2){
			Debug.tryDebug(player.getName() + " is on a killstreak");
			return true;
		}
		return false;
	}
}
