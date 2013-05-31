package com.theaetherserver.kits.selected;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.Methods;

public class Jumper {
	public static void selJumper(Player player){
		PlayerInventory inventory = player.getInventory();
		if(player.hasPermission("kit.jumper")){
			// Clear kit
			Clear.clearKits(player);
			
			// Helmet
			ItemStack helm = new ItemStack(Material.SNOW_BLOCK);
			ItemMeta helmMeta = helm.getItemMeta();
			helmMeta.setDisplayName(ChatColor.GREEN + "Jumper's Helmet");
			helm.setItemMeta(helmMeta);
			helm.addUnsafeEnchantment(new EnchantmentWrapper(222), 3);
			
			// Chestplate
			
			// Leggings
			ItemStack legs = new ItemStack(Material.IRON_LEGGINGS);
			ItemMeta legsMeta = legs.getItemMeta();
			legsMeta.setDisplayName(ChatColor.GREEN + "Jumper's Leggings");
			legs.setItemMeta(legsMeta);
			
			// Boots
			ItemStack boots = new ItemStack(Material.IRON_BOOTS);
			ItemMeta bootsMeta = boots.getItemMeta();
			bootsMeta.setDisplayName(ChatColor.GREEN + "Jumper's Boots");
			boots.setItemMeta(bootsMeta);
			
			// Sword
			ItemStack sword = new ItemStack(Material.STONE_SWORD);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.GREEN + "Jumper's Sword");
			sword.setItemMeta(swordMeta);
			sword.addUnsafeEnchantment(new EnchantmentWrapper(222), 3);
			
			// Special Weapon
			ItemStack spec = new ItemStack(Material.DIAMOND_BOOTS);
			ItemMeta specMeta = spec.getItemMeta();
			specMeta.setDisplayName(ChatColor.GREEN + "Jumper's Booster Boots");
			spec.setItemMeta(specMeta);
			
			// Inventory Management
			inventory.addItem(sword);
			inventory.addItem(spec);
			Methods.reSoup(player);
			inventory.setHelmet(helm);
			inventory.setLeggings(legs);
			inventory.setBoots(boots);
			
			// Add kit
			Main.playJumper.put(player.getName(), "Jumper");
			
			// Debug Message
			Debug.tryDebug("Jumper selected by " + player.getName());
			
		}else{
			player.sendMessage("You do not have permission to play Jumper");
		}
	}
}
