package com.theaetherserver.kits.selected;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;

public class Trickster {
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("unused")
	private static Main plugin;

	@SuppressWarnings("static-access")
	public Trickster(Main plugin){
		this.plugin = plugin;
	}

	public static void selTrickster(Player player){
		PlayerInventory inventory = player.getInventory();


		if(player.hasPermission("kit.reaper")){
			// Clear kit
			Clear.clearKits(player);

			// Enchantments
			Enchantment DURABILITY = new EnchantmentWrapper(34);

			// Helmet
			ItemStack reaperHelmet = new ItemStack(Material.IRON_HELMET);
			ItemMeta reaperHelmetMeta = reaperHelmet.getItemMeta();
			reaperHelmetMeta.setDisplayName(ChatColor.DARK_GRAY + "Trickster's Helmet");
			reaperHelmet.setItemMeta(reaperHelmetMeta);

			// Chestplate
			ItemStack reaperChest = new ItemStack(Material.IRON_CHESTPLATE);
			ItemMeta reaperChestMeta = reaperChest.getItemMeta();
			reaperChestMeta.setDisplayName(ChatColor.DARK_GRAY + "Trickster's Chestplate");
			reaperChest.setItemMeta(reaperChestMeta);

			// Leggings
			ItemStack reaperLeggings = new ItemStack(Material.IRON_LEGGINGS);
			ItemMeta reaperLeggingsMeta = reaperLeggings.getItemMeta();
			reaperLeggingsMeta.setDisplayName(ChatColor.DARK_GRAY + "Trickster's Leggings");
			reaperLeggings.setItemMeta(reaperLeggingsMeta);

			// Boots
			ItemStack reaperBoots = new ItemStack(Material.DIAMOND_BOOTS);
			ItemMeta reaperBootsMeta = reaperBoots.getItemMeta();
			reaperBootsMeta.setDisplayName(ChatColor.DARK_GRAY + "Trickster's Boots");
			reaperBoots.setItemMeta(reaperBootsMeta);

			// Sword
			ItemStack tricksterSword = new ItemStack(Material.GOLD_SWORD);
			ItemMeta tricksterSwordMeta = tricksterSword.getItemMeta();
			tricksterSwordMeta.setDisplayName(ChatColor.DARK_GRAY + "Trickster's Sword");
			tricksterSword.setItemMeta(tricksterSwordMeta);
			tricksterSword.addUnsafeEnchantment(DURABILITY, 10);

			// Special Weapon
			ItemStack reaperScythe = new ItemStack(Material.REDSTONE_TORCH_ON);
			ItemMeta reaperScytheMeta = reaperScythe.getItemMeta();
			reaperScytheMeta.setDisplayName(ChatColor.DARK_GRAY + "Trickster's Wand");
			ArrayList<String> trickLore = new ArrayList<String>();
			trickLore.add(ChatColor.DARK_PURPLE + "Hit a player to make them turn around!");
			trickLore.add(ChatColor.DARK_PURPLE + "Cooldown: 30 seconds.");
			reaperScytheMeta.setLore(trickLore);
			reaperScythe.setItemMeta(reaperScytheMeta);
			reaperScythe.addUnsafeEnchantment(DURABILITY, 10);

			// Inventory
			inventory.addItem(tricksterSword);
			inventory.addItem(reaperScythe);
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
			inventory.setHelmet(reaperHelmet);
			inventory.setChestplate(reaperChest);
			inventory.setLeggings(reaperLeggings);
			inventory.setBoots(reaperBoots);

			// Add kit
			Main.playReaper.put(player.getName(), "Trickster");
			
			Debug.tryDebug("Trickster selected by " + player.getName());

		}else{
			player.sendMessage("You do not have permission to play as trickster");
		}
	}

}
