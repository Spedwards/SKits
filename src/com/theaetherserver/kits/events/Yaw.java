package com.theaetherserver.kits.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.theaetherserver.kits.Main;

public class Yaw {
	@SuppressWarnings("unused")
	private Main plugin;
	public Yaw (Main plugin){
		this.plugin = plugin;
	}
	
	
	public static String tryYaw(Player player){
		Location loc = player.getLocation();
		float yaw = loc.getYaw();
		if(yaw == 0){
			return "south";
		}else if(yaw == 90){
			return "west";
		}else if(yaw == -90){
			return "east";
		}else if(yaw == -179){
			return "north";
		}
		return null;
	}
}
