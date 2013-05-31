package com.theaetherserver.kits.selected;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.Methods;

public class Angel {
	@SuppressWarnings("unused")
	private Main plugin;
	public Angel (Main plugin){
		this.plugin = plugin;
	}
	
	public static void selAngel(Player player){
		PlayerInventory inventory = player.getInventory();
		
		if(player.hasPermission("kit.angel")){
			// Clear kits
			Clear.clearKits(player);
			
			// Helmet
			ItemStack helm = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helm.getItemMeta();
			helmMeta.setDisplayName(ChatColor.YELLOW + "Angel's Helmet");
			helmMeta.setColor(Color.YELLOW);
			helm.setItemMeta(helmMeta);
			
			// Chestplate
			ItemStack chest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			ItemMeta chestMeta = chest.getItemMeta();
			chestMeta.setDisplayName(ChatColor.YELLOW + "Angel's Chestplate");
			chest.setItemMeta(chestMeta);
			
			// Leggings
			ItemStack legs = new ItemStack(Material.CHAINMAIL_LEGGINGS);
			ItemMeta legsMeta = legs.getItemMeta();
			legsMeta.setDisplayName(ChatColor.YELLOW + "Angel's Leggings");
			legs.setItemMeta(legsMeta);
			
			// Boots
			ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);
			ItemMeta bootsMeta = boots.getItemMeta();
			bootsMeta.setDisplayName(ChatColor.YELLOW + "Angels's Boots");
			boots.setItemMeta(bootsMeta);
			
			// Sword
			ItemStack sword = new ItemStack(Material.STONE_SWORD);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.YELLOW + "Angel's Sword");
			sword.setItemMeta(swordMeta);
			
			// Inventory Management
			inventory.addItem(sword);
			Methods.reSoup(player);
			inventory.setHelmet(helm);
			inventory.setChestplate(chest);
			inventory.setLeggings(legs);
			inventory.setBoots(boots);
			
			// Add kit
			Main.playAngel.put(player.getName(), "Angel");
			
			Debug.tryDebug("Angel selected by " + player.getName());
		}
	}
}
