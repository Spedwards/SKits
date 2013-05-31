package com.theaetherserver.kits.selected;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PVP {
	String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	
	public static void selPVP(Player player){
		PlayerInventory inventory = player.getInventory();

		// Clear Inventory
		inventory.clear();
		player.setItemInHand(null);

		// Clear Armour
		inventory.setArmorContents(null);

		// Remove Potion Effects
		for(PotionEffect pe: player.getActivePotionEffects()){
			player.removePotionEffect(pe.getType());
		}
		// Inventory
		inventory.addItem(new ItemStack(Material.DIAMOND_SWORD));
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(new ItemStack(Material.BOWL));
		inventory.setHelmet(new ItemStack(Material.IRON_HELMET));
		inventory.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		inventory.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		inventory.setBoots(new ItemStack(Material.IRON_BOOTS));
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));	
	}

}
