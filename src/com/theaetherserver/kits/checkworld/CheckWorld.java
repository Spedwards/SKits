package com.theaetherserver.kits.checkworld;

import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;

public class CheckWorld {
	@SuppressWarnings("unused")
	private Main plugin;
	public CheckWorld (Main plugin) {
		this.plugin = plugin;
	}
	
	public final static List<String> worlds = Main.inst().getConfig().getStringList("worlds");
	
	public static boolean check(Player player){
		if(worlds.contains(player.getWorld().getName()))
			return true;
		else
			return false;
	}
	
	public static boolean check(Entity e){
		if(worlds.contains(e.getWorld().getName())){
			Debug.tryDebug(e + " is in world list.");
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean check(Block b){
		if(worlds.contains(b.getWorld().getName())){
			return true;
		}else{
			return false;
		}
	}
}
