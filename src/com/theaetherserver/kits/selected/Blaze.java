package com.theaetherserver.kits.selected;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;

public class Blaze {
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("unused")
	private static Main plugin;

	@SuppressWarnings("static-access")
	public Blaze(Main plugin){
		this.plugin = plugin;
	}

	public static void selBlaze(Player player){
		PlayerInventory inventory = player.getInventory();


		if(player.hasPermission("kit.blaze")){
			// Clear kit
			Clear.clearKits(player);

			// Enchantment
			Enchantment DURABILITY = new EnchantmentWrapper(34);

			// Helmet
			ItemStack blazeHelm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta blazeHelmMeta = (LeatherArmorMeta) blazeHelm.getItemMeta();
			blazeHelmMeta.setDisplayName(ChatColor.YELLOW + "Blaze's Helmet");
			blazeHelmMeta.setColor(Color.fromRGB(0xFFFF00));
			blazeHelm.setItemMeta(blazeHelmMeta);

			// Chestplate
			ItemStack  blazeChest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta blazeChestMeta = (LeatherArmorMeta) blazeChest.getItemMeta();
			blazeChestMeta.setDisplayName(ChatColor.YELLOW + "Blaze's Chestplate");
			blazeChestMeta.setColor(Color.fromRGB(0xFFFF00));
			blazeChest.setItemMeta(blazeChestMeta);

			// Leggings
			ItemStack blazeLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta blazeLeggingsMeta = (LeatherArmorMeta) blazeLeggings.getItemMeta();
			blazeLeggingsMeta.setDisplayName(ChatColor.YELLOW + "Blaze's Leggings");
			blazeLeggingsMeta.setColor(Color.fromRGB(0xFFFF00));
			blazeLeggings.setItemMeta(blazeLeggingsMeta);

			// Boots
			ItemStack blazeBoots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta blazeBootsMeta = (LeatherArmorMeta) blazeBoots.getItemMeta();
			blazeBootsMeta.setDisplayName(ChatColor.YELLOW + "Blaze's Boots");
			blazeBootsMeta.setColor(Color.fromRGB(0xFFFF00));
			blazeBoots.setItemMeta(blazeBootsMeta);

			// Sword
			ItemStack blazeSword = new ItemStack(Material.IRON_SWORD);
			ItemMeta blazeSwordMeta = blazeSword.getItemMeta();
			blazeSwordMeta.setDisplayName(ChatColor.YELLOW + "Blaze's Sword");
			blazeSword.setItemMeta(blazeSwordMeta);
			blazeSword.addUnsafeEnchantment(DURABILITY, 10);

			// Special Weapon
			ItemStack blazeRod = new ItemStack(Material.BLAZE_ROD);
			ItemMeta blazeRodMeta = blazeRod.getItemMeta();
			blazeRodMeta.setDisplayName(ChatColor.YELLOW + "Scepter of the Blaze");
			ArrayList<String> blazeLore = new ArrayList<String>();
			blazeLore.add(ChatColor.DARK_PURPLE + "Hit a player with your scepter to burn them!");
			blazeRodMeta.setLore(blazeLore);
			blazeRod.setItemMeta(blazeRodMeta);

			// Inventory
			inventory.addItem(blazeSword);
			inventory.addItem(blazeRod);
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
			inventory.setHelmet(blazeHelm);
			inventory.setChestplate(blazeChest);
			inventory.setLeggings(blazeLeggings);
			inventory.setBoots(blazeBoots);

			// Add kit
			Main.playBlaze.put(player.getName(), "Blaze");
			
			Debug.tryDebug("Blaze selected by " + player.getName());

		}else{
			player.sendMessage("You do not have permission to play as blaze.");
		}
	}

}
