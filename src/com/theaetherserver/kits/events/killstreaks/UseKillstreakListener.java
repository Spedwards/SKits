package com.theaetherserver.kits.events.killstreaks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.checkworld.CheckWorld;

public class UseKillstreakListener implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;
	public UseKillstreakListener(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void useKillstreak(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if(CheckWorld.check(player)){
			if(player.getItemInHand().getType().equals(Material.ANVIL)){
				player.getInventory().remove(Material.ANVIL);
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 300, 3));
				Debug.tryDebug(player.getName() + " used Super Strength");
			}
		}
	}
	
}
