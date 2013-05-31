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

public class Ninja {
	@SuppressWarnings("unused")
	private static Main plugin;
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("static-access")
	public Ninja (Main plugin) {
		this.plugin = plugin;
	}
	
	public static void selNinja(Player player){
		PlayerInventory inventory = player.getInventory();
		
		if(player.hasPermission("kit.ninja")){
					// Clear kit
					Clear.clearKits(player);

					// Enchantments
					Enchantment DURABILITY = new EnchantmentWrapper(34);
					Enchantment DAMAGE_ALL = new EnchantmentWrapper(16);
					Enchantment PROTECTION_FALL = new EnchantmentWrapper(2);
					Enchantment PROTECTION_ENVIRONMENTAL = new EnchantmentWrapper(0);

					// Boots
					ItemStack ninjaBoots = new ItemStack(Material.GOLD_BOOTS);
					ItemMeta ninjaBootsMeta = ninjaBoots.getItemMeta();
					ninjaBootsMeta.setDisplayName(ChatColor.GOLD + "Ninja's Boots");
					ninjaBoots.setItemMeta(ninjaBootsMeta);
					ninjaBoots.addUnsafeEnchantment(PROTECTION_FALL, 10);
					ninjaBoots.addUnsafeEnchantment(PROTECTION_ENVIRONMENTAL, 5);
					ninjaBoots.addUnsafeEnchantment(DURABILITY, 10);

					// Sword
					ItemStack ninjasword = new ItemStack(Material.GOLD_SWORD);
					ItemMeta ninjaMeta = ninjasword.getItemMeta();
					ninjaMeta.setDisplayName(ChatColor.GOLD + "Ninja's Sword");
					ninjasword.setItemMeta(ninjaMeta);
					ninjasword.addUnsafeEnchantment(DURABILITY, 10);
					ninjasword.addEnchantment(DAMAGE_ALL, 3);

					// Inventory
					inventory.addItem(ninjasword);
					inventory.addItem(new ItemStack(Material.ENDER_PEARL, 8));
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
					inventory.setBoots(ninjaBoots);

					// Add kit
					Main.playNinja.put(player.getName(), "Ninja");
					
					Debug.tryDebug("Ninja selected by " + player.getName());
				
		}else{
			player.sendMessage("You do not have permission to play as ninja.");
		}
	}

}
