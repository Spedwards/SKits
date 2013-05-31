package com.theaetherserver.kits.selected;

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

public class Dwarf {
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("unused")
	private static Main plugin;

	@SuppressWarnings("static-access")
	public Dwarf(Main plugin){
		this.plugin = plugin;
	}

	public static void selDwarf(Player player){
		PlayerInventory inventory = player.getInventory();


		if(player.hasPermission("kit.dwarf")){
			// Clear kit
			Clear.clearKits(player);

			// Enchantment
			Enchantment DAMAGE_ALL = new EnchantmentWrapper(16);
			Enchantment KNOCKBACK = new EnchantmentWrapper(19);

			// Helmet
			ItemStack dwarfHelm = new ItemStack(Material.DIAMOND_HELMET);
			ItemMeta dwarfHelmMeta = dwarfHelm.getItemMeta();
			dwarfHelmMeta.setDisplayName(ChatColor.DARK_PURPLE + "Dwarf's Helmet");
			dwarfHelm.setItemMeta(dwarfHelmMeta);

			// Chestplate
			ItemStack dwarfChest = new ItemStack(Material.IRON_CHESTPLATE);
			ItemMeta dwarfChestMeta = dwarfChest.getItemMeta();
			dwarfChestMeta.setDisplayName(ChatColor.DARK_PURPLE + "Dwarf's Chestplate");
			dwarfChest.setItemMeta(dwarfChestMeta);

			// Leggings
			ItemStack dwarfLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta dwarfLeggingsMeta = (LeatherArmorMeta)dwarfLeggings.getItemMeta();
			dwarfLeggingsMeta.setDisplayName(ChatColor.DARK_PURPLE + "Dwarf's Leggings");
			dwarfLeggingsMeta.setColor(Color.fromRGB(0xC0C0C0));
			dwarfLeggings.setItemMeta(dwarfLeggingsMeta);

			// Boots
			ItemStack dwarfBoots = new ItemStack(Material.GOLD_BOOTS);
			ItemMeta dwarfBootsMeta = dwarfBoots.getItemMeta();
			dwarfBootsMeta.setDisplayName(ChatColor.DARK_PURPLE + "Dwarf's Boots");
			dwarfBoots.setItemMeta(dwarfBootsMeta);

			// Special Weapon
			ItemStack dwarfAxe = new ItemStack(Material.IRON_AXE);
			ItemMeta dwarfAxeMeta = dwarfAxe.getItemMeta();
			dwarfAxeMeta.setDisplayName(ChatColor.DARK_PURPLE + "Dwarf's Battleaxe");
			dwarfAxe.setItemMeta(dwarfAxeMeta);
			dwarfAxe.addUnsafeEnchantment(DAMAGE_ALL, 2);
			dwarfAxe.addUnsafeEnchantment(KNOCKBACK, 1);

			// Inventory
			inventory.addItem(dwarfAxe);
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
			inventory.setHelmet(dwarfHelm);
			inventory.setChestplate(dwarfChest);
			inventory.setLeggings(dwarfLeggings);
			inventory.setBoots(dwarfBoots);

			// Add kit
			Main.playDwarf.put(player.getName(), "Dwarf");
			
			Debug.tryDebug("Dwarf selected by " + player.getName());

		}else{
			player.sendMessage("You do not have permission to play as dwarf.");
		}
	}

}
