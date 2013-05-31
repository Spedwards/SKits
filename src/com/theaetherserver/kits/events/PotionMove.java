package com.theaetherserver.kits.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.checkworld.CheckWorld;

public class PotionMove implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;
	public PotionMove (Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void potionMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		if(CheckWorld.check(player)){
			if(Main.playBlaze.containsKey(player.getName())){
				// player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 0));
			}else if(Main.playNinja.containsKey(player.getName())){
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
			}else if(Main.playTank.containsKey(player.getName())){
				// player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 0));
			}
		}
	}

}
