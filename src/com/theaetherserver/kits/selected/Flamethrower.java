package com.theaetherserver.kits.selected;

import java.util.ArrayList;
import java.util.List;

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

public class Flamethrower {
	public static void selFlamethrower(Player player){
		PlayerInventory inventory = player.getInventory();
		if(player.hasPermission("kit.flamethrower")){
			// Clear kits
			Clear.clearKits(player);
			
			// Helmet
			ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helm.getItemMeta();
			helmMeta.setDisplayName(ChatColor.RED + "Flamethrower's Helmet");
			helmMeta.setColor(Color.RED);
			helm.setItemMeta(helmMeta);
			
			// Chestplate
			ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
			chestMeta.setDisplayName(ChatColor.RED + "Flamethrower's Chestplate");
			chestMeta.setColor(Color.BLACK);
			chest.setItemMeta(chestMeta);
			
			// Leggings
			ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) legs.getItemMeta();
			legsMeta.setDisplayName(ChatColor.RED + "Flamethrower's Leggings");
			legsMeta.setColor(Color.BLACK);
			legs.setItemMeta(legsMeta);
			
			// Boots
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setDisplayName(ChatColor.RED + "Flamethrower's Boots");
			bootsMeta.setColor(Color.RED);
			boots.setItemMeta(bootsMeta);
			
			// Sword
			ItemStack sword = new ItemStack(Material.WOOD_SWORD);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.RED + "Flamethrower's Sword");
			sword.setItemMeta(swordMeta);
			
			// Flamethrower
			ItemStack spec = new ItemStack(Material.FLINT_AND_STEEL);
			ItemMeta specMeta = spec.getItemMeta();
			specMeta.setDisplayName(ChatColor.RED + "Flamethrower");
			List<String> specLore = new ArrayList<String>();
			specLore.add(ChatColor.DARK_PURPLE + "Right click to shoot. Watch your ammo though!");
			specMeta.setLore(specLore);
			spec.setItemMeta(specMeta);
			
			// Flamethrower Ammunition
			ItemStack ammo = new ItemStack(Material.COAL, 64);
			ItemMeta ammoMeta = ammo.getItemMeta();
			ammoMeta.setDisplayName(ChatColor.RESET + "Flamethrower Ammunition");
			ammo.setItemMeta(ammoMeta);
			
			// Inventory Management
			inventory.addItem(sword);
			inventory.addItem(spec);
			inventory.setItem(9, ammo);
			inventory.setItem(10, ammo);
			inventory.setItem(11, ammo);
			inventory.setItem(12, ammo);
			inventory.setItem(13, ammo);
			inventory.setItem(14, ammo);
			inventory.setItem(15, ammo);
			Methods.reSoup(player);
			inventory.setHelmet(helm);
			inventory.setChestplate(chest);
			inventory.setLeggings(legs);
			inventory.setBoots(boots);
			
			// Add kit
			Main.playFlamethrower.put(player.getName(), "Flamethrower");
			
			// Debug
			Debug.tryDebug("Flamethrower selected by " + player.getName());
		}else{
			player.sendMessage("You do not have permission to play Flamethrower");
		}
	}
}
