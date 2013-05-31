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

public class Wither {
	@SuppressWarnings("unused")
	private static Main plugin;
	static String prefix = ChatColor.BLACK + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("static-access")
	public Wither(Main plugin) {
		this.plugin = plugin;
	}

	public static void selWither(Player player){
		PlayerInventory inventory = player.getInventory();

		if(player.hasPermission("kit.wither")){
			// Clear kit
			Clear.clearKits(player);

			// Helmet
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetMeta.setDisplayName(ChatColor.BLACK + "Wither's Helmet");
			helmetMeta.setColor(Color.fromRGB(0x000000));
			helmet.setItemMeta(helmetMeta);

			// Chestplate
			ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
			chestMeta.setDisplayName(ChatColor.BLACK + "Wither's Chestplate");
			chestMeta.setColor(Color.fromRGB(0x000000));
			chest.setItemMeta(chestMeta);

			// Leggings
			ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) legs.getItemMeta();
			legsMeta.setDisplayName(ChatColor.BLACK + "Wither's Leggings");
			legsMeta.setColor(Color.fromRGB(0x000000));
			legs.setItemMeta(legsMeta);

			// Boots
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setDisplayName(ChatColor.BLACK + "Wither's Boots");
			bootsMeta.setColor(Color.fromRGB(0x000000));
			boots.setItemMeta(bootsMeta);

			// Sword
			ItemStack sword = new ItemStack(Material.WOOD_SWORD);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.BLACK + "Wither's Sword");
			sword.setItemMeta(swordMeta);

			// Special Weapon
			ItemStack spec = new ItemStack(Material.WOOD_HOE);
			ItemMeta specMeta = spec.getItemMeta();
			specMeta.setDisplayName(ChatColor.BLACK + "Wither Scythe");
			ArrayList<String> specLore = new ArrayList<String>();
			specLore.add(ChatColor.BLACK + "Fire wither heads");
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
			Main.playWither.put(player.getName(), "Wither");
			
			Debug.tryDebug("Wither selected by " + player.getName());

		}else{
			player.sendMessage("You do not have permission to play as wither");
		}
	}

}
