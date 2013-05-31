package com.theaetherserver.kits.selected;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.Methods;

public class Soldier {
	@SuppressWarnings("unused")
	private Main plugin;
	public Soldier(Main plugin){
		this.plugin = plugin;
	}
	
	
	public static void selSoldier(Player player){
		PlayerInventory inventory = player.getInventory();
		
		if(player.hasPermission("kit.soldier")){
			// Clear Kits
			Clear.clearKits(player);
			
			// Helmet
			ItemStack helm = new ItemStack(Material.GOLD_CHESTPLATE);
			ItemMeta helmMeta = helm.getItemMeta();
			helmMeta.setDisplayName(ChatColor.BLUE + "Soldier's Helmet");
			helm.setItemMeta(helmMeta);
			
			// Chestplate
			ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
			ItemMeta chestMeta = chest.getItemMeta();
			chestMeta.setDisplayName(ChatColor.BLUE + "Soldier's Chestplate");
			chest.setItemMeta(chestMeta);
			
			// Leggings
			ItemStack legs = new ItemStack(Material.IRON_CHESTPLATE);
			ItemMeta legsMeta = legs.getItemMeta();
			legsMeta.setDisplayName(ChatColor.BLUE + "Soldier's Leggings");
			legs.setItemMeta(legsMeta);
			
			// Boots
			ItemStack boots = new ItemStack(Material.IRON_CHESTPLATE);
			ItemMeta bootsMeta = boots.getItemMeta();
			bootsMeta.setDisplayName(ChatColor.BLUE + "Soldier's Boots");
			boots.setItemMeta(bootsMeta);
			
			// Sword
			ItemStack sword = new ItemStack(Material.IRON_SWORD);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.BLUE + "Soldier's Sword");
			sword.setItemMeta(swordMeta);
			
			// Special Weapon
			ItemStack spec = new ItemStack(Material.SLIME_BALL, 15);
			ItemMeta specMeta = spec.getItemMeta();
			specMeta.setDisplayName(ChatColor.BLUE + "Soldier's Flash Grenade");
			spec.setItemMeta(specMeta);
			
			// Inventory Management
			inventory.addItem(sword);
			inventory.addItem(spec);
			Methods.reSoup(player);
			inventory.setHelmet(helm);
			inventory.setChestplate(chest);
			inventory.setLeggings(legs);
			inventory.setBoots(boots);
			
			// Add kit
			Main.playSoldier.put(player.getName(), "Soldier");
			
			Debug.tryDebug("Soldier selected by " + player.getName());
		}else{
			player.sendMessage("You do not have permission to play Soldier");
		}
	}
}
