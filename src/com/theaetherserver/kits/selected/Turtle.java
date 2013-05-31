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

public class Turtle {
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("unused")
	private static Main plugin;

	@SuppressWarnings("static-access")
	public Turtle(Main plugin){
		this.plugin = plugin;
	}

	public static void selTurtle(Player player){
		PlayerInventory inventory = player.getInventory();


		if(player.hasPermission("kit.turtle")){
			// Clear kit
			Clear.clearKits(player);

			// Helmet
			ItemStack turtleHelm = new ItemStack(Material.CHAINMAIL_HELMET);
			ItemMeta turtleHelmMeta = turtleHelm.getItemMeta();
			turtleHelmMeta.setDisplayName(ChatColor.DARK_AQUA + "Turtle's Helmet");
			turtleHelm.setItemMeta(turtleHelmMeta);

			// Chestplate
			ItemStack turtleChest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta turtleChestMeta = (LeatherArmorMeta) turtleChest.getItemMeta();
			turtleChestMeta.setDisplayName(ChatColor.DARK_AQUA + "Turtle's Chestplate");
			turtleChestMeta.setColor(Color.fromRGB(0x00FFFF));
			turtleChest.setItemMeta(turtleChestMeta);

			// Leggings
			ItemStack turtleLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta turtleLeggingsMeta = (LeatherArmorMeta) turtleLeggings.getItemMeta();
			turtleLeggingsMeta.setDisplayName(ChatColor.DARK_AQUA + "Turtle's Leggings");
			turtleLeggingsMeta.setColor(Color.fromRGB(0x00FFFF));
			turtleLeggings.setItemMeta(turtleLeggingsMeta);

			// Boots
			ItemStack turtleBoots = new ItemStack(Material.CHAINMAIL_BOOTS);
			ItemMeta turtleBootsMeta = turtleBoots.getItemMeta();
			turtleBootsMeta.setDisplayName(ChatColor.DARK_AQUA + "Turtle's Boots");
			turtleBoots.setItemMeta(turtleBootsMeta);

			// Sword
			ItemStack turtleSword = new ItemStack(Material.IRON_SWORD);
			ItemMeta turtleSwordMeta = turtleSword.getItemMeta();
			turtleSwordMeta.setDisplayName(ChatColor.DARK_AQUA + "Turtle's Sword");
			turtleSword.setItemMeta(turtleSwordMeta);

			// Inventory
			inventory.addItem(turtleSword);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.addItem(soup);
			inventory.setHelmet(turtleHelm);
			inventory.setChestplate(turtleChest);
			inventory.setLeggings(turtleLeggings);
			inventory.setBoots(turtleBoots);

			// Add kit
			Main.playTurtle.put(player.getName(), "Turtle");
			
			Debug.tryDebug("Turtle selected by " + player.getName());

		}else{
			player.sendMessage("You do not have permission to play as turtle");
		}
	}
}
