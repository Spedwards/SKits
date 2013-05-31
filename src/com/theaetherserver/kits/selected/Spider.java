package com.theaetherserver.kits.selected;

import java.util.ArrayList;

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

public class Spider {
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("unused")
	private static Main plugin;
	
	@SuppressWarnings("static-access")
	public Spider(Main plugin){
		this.plugin = plugin;
	}
	
	public static void selSpider(Player player){
		PlayerInventory inventory = player.getInventory();

		if(player.hasPermission("kit.spider")){
					// Clear kit
					Clear.clearKits(player);

					// Enchantments
					Enchantment DURABILITY = new EnchantmentWrapper(34);

					// Helmet
					ItemStack spiderHelm = new ItemStack(Material.LEATHER_HELMET);
					ItemMeta spiderHelmMeta = spiderHelm.getItemMeta();
					spiderHelmMeta.setDisplayName(ChatColor.DARK_GREEN + "Spider's Helmet");
					spiderHelm.setItemMeta(spiderHelmMeta);

					// Chestplate
					ItemStack spiderChest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
					ItemMeta spiderChestMeta = spiderChest.getItemMeta();
					spiderChestMeta.setDisplayName(ChatColor.DARK_GREEN + "Spider's Chestplate");
					spiderChest.setItemMeta(spiderChestMeta);

					// Leggings
					ItemStack  spiderLeggings = new ItemStack(Material.GOLD_LEGGINGS);
					ItemMeta spiderLeggingsMeta = spiderLeggings.getItemMeta();
					spiderLeggingsMeta.setDisplayName(ChatColor.DARK_GREEN + "Spider's Leggings");
					spiderLeggings.setItemMeta(spiderLeggingsMeta);

					// Boots
					ItemStack spiderBoots = new ItemStack(Material.LEATHER_BOOTS);
					ItemMeta spiderBootsMeta = spiderBoots.getItemMeta();
					spiderBootsMeta.setDisplayName(ChatColor.DARK_GREEN + "Spider's Helmet");
					spiderBoots.setItemMeta(spiderBootsMeta);

					// Sword
					ItemStack spiderSword = new ItemStack(Material.GOLD_SWORD);
					ItemMeta spiderSwordMeta = spiderSword.getItemMeta();
					spiderSwordMeta.setDisplayName(ChatColor.DARK_GREEN + "Spider's Sword");
					spiderSword.setItemMeta(spiderSwordMeta);
					spiderSword.addUnsafeEnchantment(DURABILITY, 10);

					//  Special Weapon
					ItemStack spiderEye = new ItemStack(Material.SPIDER_EYE);
					ItemMeta spiderEyeMeta = spiderEye.getItemMeta();
					spiderEyeMeta.setDisplayName(ChatColor.DARK_GREEN + "Spider's Eye");
					ArrayList<String> spiderLore = new ArrayList<String>();
					spiderLore.add(ChatColor.DARK_PURPLE + "Hit a player with the eye to give them poison!");
					spiderEyeMeta.setLore(spiderLore);
					spiderEye.setItemMeta(spiderEyeMeta);

					// Inventory
					inventory.addItem(spiderSword);
					inventory.addItem(spiderEye);
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
					inventory.setHelmet(spiderHelm);
					inventory.setChestplate(spiderChest);
					inventory.setLeggings(spiderLeggings);
					inventory.setBoots(spiderBoots);

					// Add kit
					Main.playSpider.put(player.getName(), "Spider");
					
					Debug.tryDebug("Spider selected by " + player.getName());
				
		}else{
			player.sendMessage("You do not have permission to play as spider");
		}
	}

}
