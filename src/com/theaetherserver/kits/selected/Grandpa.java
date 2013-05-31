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
import com.theaetherserver.kits.Methods;

public class Grandpa {
	@SuppressWarnings("unused")
	private Main plugin;
	public Grandpa(Main plugin){
		this.plugin = plugin;
	}
	
	public static void selGrandpa(Player player){
		PlayerInventory inventory = player.getInventory();
		if(player.hasPermission("kit.grandpa")){
			// Clear Kits
			Clear.clearKits(player);
			
			// Enchantments
			Enchantment KNOCKBACK = new EnchantmentWrapper(19);
			
			// Helmet
			ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helm.getItemMeta();
			helmMeta.setColor(Color.fromRGB(0x5b4735));
			helmMeta.setDisplayName(ChatColor.DARK_GRAY + "Grandpa's Helmet");
			helm.setItemMeta(helmMeta);
			
			// Chestplate
			ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
			chestMeta.setColor(Color.fromRGB(0x5b4735));
			chestMeta.setDisplayName(ChatColor.DARK_GRAY + "Grandpa's Chestplate");
			chest.setItemMeta(chestMeta);
			
			// Leggings
			ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) legs.getItemMeta();
			legsMeta.setColor(Color.fromRGB(0x5b4735));
			legsMeta.setDisplayName(ChatColor.DARK_GRAY + "Grandpa's Leggings");
			legs.setItemMeta(legsMeta);
			
			// Boots
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setColor(Color.fromRGB(0x5b4735));
			bootsMeta.setDisplayName(ChatColor.DARK_GRAY + "Grandpa's Boots");
			boots.setItemMeta(bootsMeta);
			
			// Sword
			ItemStack sword = new ItemStack(Material.IRON_SWORD);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.DARK_GRAY + "Grandpa's Sword");
			sword.setItemMeta(swordMeta);
			
			// Special Weapon
			ItemStack spec = new ItemStack(Material.STICK);
			ItemMeta specMeta = spec.getItemMeta();
			specMeta.setDisplayName(ChatColor.GRAY + "Grandpa's Walking Stick");
			ArrayList<String> specLore = new ArrayList<String>();
			specLore.add(ChatColor.DARK_PURPLE + "GET OFF MY LAWN!");
			specMeta.setLore(specLore);
			spec.setItemMeta(specMeta);
			spec.addUnsafeEnchantment(KNOCKBACK, 5);
			
			// Inventory Management
			inventory.addItem(sword);
			inventory.addItem(spec);
			Methods.reSoup(player);
			inventory.setHelmet(helm);
			inventory.setChestplate(chest);
			inventory.setLeggings(legs);
			inventory.setBoots(boots);
			
			// Add kit
			Main.playGrandpa.put(player.getName(), "Grandpa");
			
			Debug.tryDebug("Grandpa selected by " + player.getName());
		}
	}
}
