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

public class Archer {
	String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	

	public static void selArcher(Player player){
		PlayerInventory inventory = player.getInventory();
		
		if(player.hasPermission("kit.archer")){
			
			// Clear kit
			Clear.clearKits(player);

			// Enchantments
			Enchantment ARROW_DAMAGE = new EnchantmentWrapper(48);
			Enchantment ARROW_INFINITE = new EnchantmentWrapper(51);
			Enchantment DURABILITY = new EnchantmentWrapper(34);
			Enchantment DAMAGE_ALL = new EnchantmentWrapper(16);

			// Helmet
			ItemStack archHelmet = new ItemStack(Material.CHAINMAIL_HELMET);
			ItemMeta archHelmetMeta = archHelmet.getItemMeta();
			archHelmetMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Archer's Helmet");
			archHelmet.setItemMeta(archHelmetMeta);

			// Chestplate
			ItemStack archChest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			ItemMeta archChestMeta = archChest.getItemMeta();
			archChestMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Archer's Chestplate");
			archChest.setItemMeta(archChestMeta);

			// Leggings
			ItemStack archLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
			ItemMeta archLeggingsMeta = archLeggings.getItemMeta();
			archLeggingsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Archer's Leggings");
			archLeggings.setItemMeta(archLeggingsMeta);

			// Boots
			ItemStack archBoots = new ItemStack(Material.CHAINMAIL_BOOTS);
			ItemMeta archBootsMeta = archBoots.getItemMeta();
			archBootsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Archer's Boots");
			archBoots.setItemMeta(archBootsMeta);

			// Bow
			ItemStack archerbow = new ItemStack(Material.BOW);
			ItemMeta archerMeta = archerbow.getItemMeta();
			archerMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Archer's Bow");
			archerbow.setItemMeta(archerMeta);
			archerbow.addEnchantment(ARROW_DAMAGE, 2);
			archerbow.addEnchantment(ARROW_INFINITE, 1);
			archerbow.addUnsafeEnchantment(DURABILITY, 10);
			archerbow.addUnsafeEnchantment(DAMAGE_ALL, 1);

			// Inventory
			inventory.addItem(archerbow);
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
			inventory.addItem(new ItemStack(Material.ARROW, 1));
			inventory.setHelmet(archHelmet);
			inventory.setChestplate(archChest);
			inventory.setLeggings(archLeggings);
			inventory.setBoots(archBoots);

			Main.inst();
			// Add kit
			Main.playArcher.put(player.getName(), "Archer");
			
			Debug.tryDebug("Archer selected by " + player.getName());
		}else{
			player.sendMessage("You do not have permission to play as archer.");
		}
	}
	
}
