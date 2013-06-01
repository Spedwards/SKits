package com.theaetherserver.kits.selected;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.Methods;

public class Wizard {
	public static void selWizard(Player player){
		PlayerInventory inventory = player.getInventory();
		if(player.hasPermission("kit.wizard")){
			// Clear Kits
			Clear.clearKits(player);
			
			// Helmet
			ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helm.getItemMeta();
			helmMeta.setDisplayName(ChatColor.DARK_BLUE + "Wizard's Hat");
			helmMeta.setColor(Color.BLUE);
			helm.setItemMeta(helmMeta);
			
			// Chestplate
			ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
			chestMeta.setDisplayName(ChatColor.DARK_BLUE + "Wizard's Robes");
			chestMeta.setColor(Color.BLUE);
			chest.setItemMeta(chestMeta);
			
			// Leggings
			ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) legs.getItemMeta();
			legsMeta.setDisplayName(ChatColor.DARK_BLUE + "Wizard's Robes");
			legsMeta.setColor(Color.BLUE);
			legs.setItemMeta(legsMeta);
			
			// Boots
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setDisplayName(ChatColor.DARK_BLUE + "Wizard's Robes");
			bootsMeta.setColor(Color.BLUE);
			boots.setItemMeta(bootsMeta);
			
			// Wand
			ItemStack wand = new ItemStack(Material.STICK);
			ItemMeta wandMeta = wand.getItemMeta();
			wandMeta.setDisplayName(ChatColor.BLUE + "Wand");
			List<String> wandLore = new ArrayList<String>();
			wandLore.add(ChatColor.DARK_PURPLE + "Mode: Melee");
			wandMeta.setLore(wandLore);
			wand.setItemMeta(wandMeta);
			wand.addUnsafeEnchantment(new EnchantmentWrapper(222), 3);
			
			// Inventory Management
			inventory.addItem(wand);
			Methods.reSoup(player);
			inventory.setHelmet(helm);
			inventory.setChestplate(chest);
			inventory.setLeggings(legs);
			inventory.setBoots(boots);
			
			// Add kit
			Main.playWizard.put(player.getName(), "Wizard");
			
			// Debug
			Debug.tryDebug("Wizard selected by " + player.getName());			
		}else{
			player.sendMessage("You do not have permission to play Wizard");
		}
	}
}
