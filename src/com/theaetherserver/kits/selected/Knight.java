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

public class Knight {
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("unused")
	private static Main plugin;

	@SuppressWarnings("static-access")
	public Knight(Main plugin){
		this.plugin = plugin;
	}

	public static void selKnight(Player player) {
		PlayerInventory inventory = player.getInventory();
		if(player.hasPermission("kit.knight")){
			// Clear kit
			Clear.clearKits(player);

			// Enchantments
			Enchantment DURABILITY = new EnchantmentWrapper(34);

			// Helmet
			ItemStack knightHelmet = new ItemStack(Material.DIAMOND_HELMET);
			ItemMeta knightHelmetMeta = knightHelmet.getItemMeta();
			knightHelmetMeta.setDisplayName(ChatColor.DARK_RED + "Knight's Helmet");
			knightHelmet.setItemMeta(knightHelmetMeta);

			// Chestplate
			ItemStack knightChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
			ItemMeta knightChestMeta = knightChest.getItemMeta();
			knightChestMeta.setDisplayName(ChatColor.DARK_RED + "Knight's Chestplate");
			knightChest.setItemMeta(knightChestMeta);

			// Leggings
			ItemStack knightLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
			ItemMeta knightLeggingsMeta = knightLeggings.getItemMeta();
			knightLeggingsMeta.setDisplayName(ChatColor.DARK_RED + "Knight's Leggings");
			knightLeggings.setItemMeta(knightLeggingsMeta);

			// Boots
			ItemStack knightBoots = new ItemStack(Material.DIAMOND_BOOTS);
			ItemMeta knightBootsMeta = knightBoots.getItemMeta();
			knightBootsMeta.setDisplayName(ChatColor.DARK_RED + "Knight's Boots");
			knightBoots.setItemMeta(knightBootsMeta);

			// Sword
			ItemStack knightsword = new ItemStack(Material.IRON_SWORD);
			ItemMeta knightMeta = knightsword.getItemMeta();
			knightMeta.setDisplayName(ChatColor.DARK_RED + "Knight's Sword");
			knightsword.setItemMeta(knightMeta);
			knightsword.addUnsafeEnchantment(DURABILITY, 10);

			// Inventory
			inventory.addItem(new ItemStack(knightsword));
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
			inventory.setHelmet(knightHelmet);
			inventory.setChestplate(knightChest);
			inventory.setLeggings(knightLeggings);
			inventory.setBoots(knightBoots);

			// Add kit
			Main.playKnight.put(player.getName(), "Knight");
			
			Debug.tryDebug("Knight selected by " + player.getName());

		}else{
			player.sendMessage("You do not have permission to play as knight.");
		}		
	}

}
