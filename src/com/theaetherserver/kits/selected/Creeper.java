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

public class Creeper {
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("unused")
	private static Main plugin;

	@SuppressWarnings("static-access")
	public Creeper (Main plugin){
		this.plugin = plugin;
	}

	public static void selCreeper(Player player){
		PlayerInventory inventory = player.getInventory();

		if(player.hasPermission("kit.creeper")){
			// Clear Kits
			Clear.clearKits(player);

			// Helmet
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetMeta.setDisplayName(ChatColor.GREEN + "Creeper's Helmet");
			helmetMeta.setColor(Color.fromRGB(0x008000));
			helmet.setItemMeta(helmetMeta);

			// Chestplate
			ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
			chestMeta.setDisplayName(ChatColor.GREEN + "Creeper's Chestplate");
			chestMeta.setColor(Color.fromRGB(0x008000));
			chest.setItemMeta(chestMeta);

			// Leggings
			ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) legs.getItemMeta();
			legsMeta.setDisplayName(ChatColor.GREEN + "Creeper's Leggings");
			legsMeta.setColor(Color.fromRGB(0x008000));
			legs.setItemMeta(legsMeta);

			// Boots
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setDisplayName(ChatColor.GREEN + "Creeper's Boots");
			bootsMeta.setColor(Color.fromRGB(0x008000));
			boots.setItemMeta(bootsMeta);

			// Sword
			ItemStack sword = new ItemStack(Material.WOOD_SWORD);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.GREEN + "Creeper's Sword");
			sword.setItemMeta(swordMeta);

			// Special Weapon
			ItemStack spec = new ItemStack(Material.SULPHUR);
			ItemMeta specMeta = spec.getItemMeta();
			specMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "BOOM!");
			ArrayList<String> specLore = new ArrayList<String>();
			specLore.add(ChatColor.GREEN + "Right click to go BOOM!");
			specMeta.setLore(specLore);
			spec.setItemMeta(specMeta);

			// Inventory Management
			inventory.addItem(sword);
			inventory.addItem(spec);
			Methods.reSoup(player);
			inventory.setHelmet(helmet);
			inventory.setChestplate(chest);
			inventory.setLeggings(legs);
			inventory.setBoots(boots);

			// Add kit
			Main.playCreeper.put(player.getName(), "Creeper");
			
			Debug.tryDebug("Creeper selected by " + player.getName());			

		}else{
			player.sendMessage("You do not have permission to play as fisherman");
		}
	}

}
