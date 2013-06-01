package com.theaetherserver.kits.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.checkworld.CheckWorld;

public class Update implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;
	public Update (Main plugin){
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void updateInventory(PlayerMoveEvent event){
		Player player = event.getPlayer();
		if(CheckWorld.check(player)){
			if(!Main.playArcher.containsKey(player.getName())){
				player.updateInventory();
			}
		}
	}
	
}
