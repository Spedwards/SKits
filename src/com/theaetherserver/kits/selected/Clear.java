package com.theaetherserver.kits.selected;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.Methods;

public class Clear {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public Clear(Main plugin){
		this.plugin = plugin;
	}
	
	public static void clearKits(Player player){
		Debug.tryDebug(player.getName() + "'s kit has been cleared");
		
		// Clear kit
		Methods.clearKitMap(player);

		// Clear Inventory
		player.getInventory().clear();
		player.setItemInHand(null);

		// Clear Armour
		player.getInventory().setArmorContents(null);

		// Remove Potion Effects
		for(PotionEffect pe: player.getActivePotionEffects()){
			player.removePotionEffect(pe.getType());
		}		
	}
}
