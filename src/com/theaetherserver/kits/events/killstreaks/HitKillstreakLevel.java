package com.theaetherserver.kits.events.killstreaks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.checkworld.CheckWorld;

public class HitKillstreakLevel implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;
	public HitKillstreakLevel (Main plugin){
		this.plugin = plugin;
	}
	
	
	
	@EventHandler
	public void killstreak(PlayerLevelChangeEvent event){
		Player player = event.getPlayer();
		int level = event.getNewLevel();
		if(CheckWorld.check(player)){
			if(level == 4){
				Rewards.four(player);
				Debug.tryDebug(player.getName() + " hit a 4 killstreak");
			}else if(level == 6){
				Rewards.six(player);
				Debug.tryDebug(player.getName() + " hit a 6 killstreak");
			}else if(level == 10){
				Rewards.ten(player);
				Debug.tryDebug(player.getName() + " hit a 10 killstreak");
			}else if(level == 12){
				Rewards.twelve(player);
				Debug.tryDebug(player.getName() + " hit a 12 killstreak");
			}
		}
	}
	
}
