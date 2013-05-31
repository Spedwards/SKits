package com.theaetherserver.kits.selected;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;

public class Tank {
	String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	
	public static void selTank(Player player){
		PlayerInventory inventory = player.getInventory();
		
		if(player.hasPermission("kit.tank")){
			// Clear kit
			Clear.clearKits(player);

			// Enchantments
			Enchantment DURABILITY = new EnchantmentWrapper(34);

			// Helmet
			ItemStack tankHelmet = new ItemStack(Material.IRON_HELMET);
			ItemMeta tankHelmetMeta = tankHelmet.getItemMeta();
			tankHelmetMeta.setDisplayName(ChatColor.AQUA + "Tank's Helmet");
			tankHelmet.setItemMeta(tankHelmetMeta);

			// Chestplate
			ItemStack tankChest = new ItemStack(Material.IRON_CHESTPLATE);
			ItemMeta tankChestMeta = tankChest.getItemMeta();
			tankChestMeta.setDisplayName(ChatColor.AQUA + "Tank's Chestplate");
			tankChest.setItemMeta(tankChestMeta);

			// Leggings
			ItemStack tankLeggings = new ItemStack(Material.IRON_LEGGINGS);
			ItemMeta tankLeggingsMeta = tankLeggings.getItemMeta();
			tankLeggingsMeta.setDisplayName(ChatColor.AQUA + "Tank's Leggings");
			tankLeggings.setItemMeta(tankLeggingsMeta);

			// Boots
			ItemStack tankBoots = new ItemStack(Material.IRON_BOOTS);
			ItemMeta tankBootsMeta = tankBoots.getItemMeta();
			tankBootsMeta.setDisplayName(ChatColor.AQUA + "Tank's Boots");
			tankBoots.setItemMeta(tankBootsMeta);

			// Sword
			ItemStack tanksword = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta tankMeta = tanksword.getItemMeta();
			tankMeta.setDisplayName(ChatColor.AQUA + "Tank's Sword");
			tanksword.setItemMeta(tankMeta);
			tanksword.addUnsafeEnchantment(DURABILITY, 10);

			// Inventory
			inventory.addItem(tanksword);
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
			inventory.setHelmet(tankHelmet);
			inventory.setChestplate(tankChest);
			inventory.setLeggings(tankLeggings);
			inventory.setBoots(tankBoots);

			// Add kit
			Main.playTank.put(player.getName(), "Tank");
			
			Debug.tryDebug("Tank selected by " + player.getName());
		}else{
			player.sendMessage("You do not have permission to play as tank.");
		}
	}

}
