package com.theaetherserver.kits.events.killstreaks;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.theaetherserver.kits.Main;

public class Rewards {
	@SuppressWarnings("unused")
	private Main plugin;
	public Rewards(Main plugin){
		this.plugin = plugin;
	}
	
	public static void four(Player player){
		player.getInventory().addItem(new ItemStack(Material.POTION, 1, (short) 8201));
		player.sendMessage(ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA + "4 kill streak!");
	}
	
	public static void six(Player player){
		ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
		chest.addEnchantment(new EnchantmentWrapper(0), 1);
		player.getInventory().setChestplate(chest);
		player.sendMessage(ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA + "6 kill streak!");
	}
	
	public static void ten(Player player){
		ItemStack legs = new ItemStack(Material.IRON_LEGGINGS);
		legs.addEnchantment(new EnchantmentWrapper(0), 1);
		player.getInventory().setLeggings(legs);
		player.sendMessage(ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA + "10 kill streak!");
	}
	
	public static void twelve(Player player){
		ItemStack anvil = new ItemStack(Material.ANVIL);
		ItemMeta anvilMeta = anvil.getItemMeta();
		anvilMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Super Strength");
		ArrayList<String> anvilLore = new ArrayList<String>();
		anvilLore.add(ChatColor.DARK_PURPLE + "Right click for super strength!");
		anvilMeta.setLore(anvilLore);
		anvil.setItemMeta(anvilMeta);
		
		
		player.getInventory().addItem(anvil);
		player.sendMessage(ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA + "12 kill streak!");
	}
}
