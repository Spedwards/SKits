package com.theaetherserver.kits.selected;

import java.util.ArrayList;

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

public class Thor {
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("unused")
	private static Main plugin;

	@SuppressWarnings("static-access")
	public Thor(Main plugin){
		this.plugin = plugin;
	}
	
	public static void selThor(Player player){
		PlayerInventory inventory = player.getInventory();
		
		if(player.hasPermission("kit.thor")){

			// Clear Kit
			Clear.clearKits(player);
			
			// Helmet
			ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helm.getItemMeta();
			helmMeta.setColor(Color.ORANGE);
			helmMeta.setDisplayName(ChatColor.GOLD + "Thor's Helmet");
			helm.setItemMeta(helmMeta);
			
			// Chestplate
			ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
			chestMeta.setColor(Color.ORANGE);
			chestMeta.setDisplayName(ChatColor.GOLD + "Thor's Chestplate");
			chest.setItemMeta(chestMeta);
			
			// Leggings
			ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
			ItemMeta legsMeta = legs.getItemMeta();
			legsMeta.setDisplayName(ChatColor.GOLD + "Thor's Leggings");
			legs.setItemMeta(legsMeta);
			
			// Boots
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setColor(Color.ORANGE);
			bootsMeta.setDisplayName(ChatColor.GOLD + "Thor's Boots");
			boots.setItemMeta(bootsMeta);
			
			// Sword
			ItemStack sword = new ItemStack(Material.STONE_SWORD);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.GOLD + "Thor's Sword");
			sword.setItemMeta(swordMeta);
			
			// Special Weapon
			ItemStack spec = new ItemStack(Material.WOOD_AXE);
			ItemMeta specMeta = spec.getItemMeta();
			specMeta.setDisplayName(ChatColor.GOLD + "Mjölnir");
			ArrayList<String> thorLore = new ArrayList<String>();
			thorLore.add(ChatColor.DARK_PURPLE + "Right click to strike down lightning!");
			specMeta.setLore(thorLore);
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
			Main.playThor.put(player.getName(), "Thor");
			
			Debug.tryDebug("Thor selected by " + player.getName());
		}else{
			player.sendMessage("You do not have permission to play as Thor");
		}
	}

}
