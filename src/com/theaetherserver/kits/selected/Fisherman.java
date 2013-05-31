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

public class Fisherman {
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("unused")
	private static Main plugin;
	
	@SuppressWarnings("static-access")
	public Fisherman(Main plugin){
		this.plugin = plugin;
	}
	
	public static void selFisherman(Player player){
		PlayerInventory inventory = player.getInventory();

		if(player.hasPermission("kit.fisherman")){
					// Clear kit
					Clear.clearKits(player);

					// Enchantment
					Enchantment DURABILITY = new EnchantmentWrapper(34);
					Enchantment KNOCKBACK = new EnchantmentWrapper(19);

					// Helmet
					ItemStack fisherHelm = new ItemStack(Material.LEATHER_HELMET);
					LeatherArmorMeta fisherHelmMeta = (LeatherArmorMeta) fisherHelm.getItemMeta();
					fisherHelmMeta.setDisplayName(ChatColor.RED + "Fisherman's Helmet");
					fisherHelmMeta.setColor(Color.fromRGB(0xFF0000));
					fisherHelm.setItemMeta(fisherHelmMeta);

					// Chestplate
					ItemStack  fisherChest = new ItemStack(Material.LEATHER_CHESTPLATE);
					LeatherArmorMeta fisherChestMeta = (LeatherArmorMeta) fisherChest.getItemMeta();
					fisherChestMeta.setDisplayName(ChatColor.RED + "Fisherman's Chestplate");
					fisherChestMeta.setColor(Color.fromRGB(0xFF0000));
					fisherChest.setItemMeta(fisherChestMeta);

					// Leggings
					ItemStack fisherLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
					LeatherArmorMeta fisherLeggingsMeta = (LeatherArmorMeta) fisherLeggings.getItemMeta();
					fisherLeggingsMeta.setDisplayName(ChatColor.RED + "Fisherman's Leggings");
					fisherLeggingsMeta.setColor(Color.fromRGB(0xFF0000));
					fisherLeggings.setItemMeta(fisherLeggingsMeta);

					// Boots
					ItemStack fisherBoots = new ItemStack(Material.LEATHER_BOOTS);
					LeatherArmorMeta fisherBootsMeta = (LeatherArmorMeta) fisherBoots.getItemMeta();
					fisherBootsMeta.setDisplayName(ChatColor.RED + "Fisherman's Boots");
					fisherBootsMeta.setColor(Color.fromRGB(0xFF0000));
					fisherBoots.setItemMeta(fisherBootsMeta);
					
					// Sword
					ItemStack fisherSword = new ItemStack(Material.DIAMOND_SWORD);
					ItemMeta fisherSwordMeta = fisherSword.getItemMeta();
					fisherSwordMeta.setDisplayName(ChatColor.RED + "Fisherman's Sword");
					fisherSword.setItemMeta(fisherSwordMeta);
					fisherSword.addEnchantment(KNOCKBACK, 1);
					
					// Special Weapon
					ItemStack fisherRod = new ItemStack(Material.FISHING_ROD);
					ItemMeta fisherRodMeta = fisherRod.getItemMeta();
					fisherRodMeta.setDisplayName(ChatColor.RED + "Fisherman's Rod");
					ArrayList<String> fisherLore = new ArrayList<String>();
					fisherLore.add(ChatColor.DARK_PURPLE + "Reel in your opponents!");
					fisherRodMeta.setLore(fisherLore);
					fisherRod.setItemMeta(fisherRodMeta);
					fisherRod.addUnsafeEnchantment(DURABILITY, 10);

					// Inventory
					inventory.addItem(fisherSword);
					inventory.addItem(fisherRod);
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
					inventory.setHelmet(fisherHelm);
					inventory.setChestplate(fisherChest);
					inventory.setLeggings(fisherLeggings);
					inventory.setBoots(fisherBoots);

					// Add kit
					Main.playFisher.put(player.getName(), "Fisherman");
					
					Debug.tryDebug("Fisherman selected by " + player.getName());
				
		}else{
			player.sendMessage("You do not have permission to play as fisherman");
		}
	}

}
