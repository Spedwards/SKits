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

public class Cannon {
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("unused")
	private static Main plugin;

	@SuppressWarnings("static-access")
	public Cannon (Main plugin){
		this.plugin = plugin;
	}

	public static void selCannon(Player player){
		PlayerInventory inventory = player.getInventory();

		if(player.hasPermission("kit.cannon")){
			// Clear Kit
			Clear.clearKits(player);

			// Helmet
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmetMeta.setDisplayName(ChatColor.RED + "Cannon's Helmet");
			helmetMeta.setColor(Color.RED);
			helmet.setItemMeta(helmetMeta);

			// Chestplate
			ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
			chestMeta.setDisplayName("Cannon's Chestplate");
			chestMeta.setColor(Color.WHITE);
			chest.setItemMeta(chestMeta);

			// Leggings
			ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) legs.getItemMeta();
			legsMeta.setDisplayName("Cannon's Leggings");
			legsMeta.setColor(Color.WHITE);
			legs.setItemMeta(legsMeta);

			// Boots
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setDisplayName(ChatColor.RED +  "Cannon's Boots");
			bootsMeta.setColor(Color.RED);
			boots.setItemMeta(bootsMeta);

			// Sword
			ItemStack sword = new ItemStack(Material.STONE_SWORD);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.RED + "Cannon's Sword");
			sword.setItemMeta(swordMeta);

			// Special Weapon
			ItemStack tnt = new ItemStack(Material.TNT);
			ItemMeta tntMeta = tnt.getItemMeta();
			tntMeta.setDisplayName(ChatColor.RED + "Cannon's " + ChatColor.WHITE + "Cannon");
			ArrayList<String> tntLore = new ArrayList<String>();
			tntLore.add(ChatColor.DARK_PURPLE + "Right click to shoot your cannon!");
			tntMeta.setLore(tntLore);
			tnt.setItemMeta(tntMeta);

			// Inventory Management
			inventory.addItem(sword);
			inventory.addItem(tnt);
			Methods.reSoup(player);
			inventory.setHelmet(helmet);
			inventory.setChestplate(chest);
			inventory.setLeggings(legs);
			inventory.setBoots(boots);

			// Add kit
			Main.playCannon.put(player.getName(), "Cannon");
			
			Debug.tryDebug("Cannon selected by " + player.getName());

		}else{
			player.sendMessage("You do not have permission to play as Cannon");
		}
	}

}
