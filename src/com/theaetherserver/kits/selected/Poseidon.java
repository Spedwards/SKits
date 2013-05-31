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
import com.theaetherserver.kits.Methods;

public class Poseidon {
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("unused")
	private static Main plugin;

	@SuppressWarnings("static-access")
	public Poseidon (Main plugin){
		this.plugin = plugin;
	}

	public static void selPoseidon(Player player){
		PlayerInventory inventory = player.getInventory();

		if(player.hasPermission("kit.poseidon")){

			// Clear Kit
			Clear.clearKits(player);

			// Helmet
			ItemStack helm = new ItemStack(Material.IRON_HELMET);
			ItemMeta helmMeta = helm.getItemMeta();
			helmMeta.setDisplayName(ChatColor.BLUE + "Poseidon's Helmet");
			helm.setItemMeta(helmMeta);

			// Chestplate
			ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
			chestMeta.setDisplayName(ChatColor.BLUE + "Poseidon's Chestplate");
			chestMeta.setColor(Color.fromRGB(0x4CD5FF));
			chest.setItemMeta(chestMeta);

			// Leggings
			ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) legs.getItemMeta();
			legsMeta.setDisplayName(ChatColor.BLUE + "Poseidon's Leggings");
			legsMeta.setColor(Color.fromRGB(0x4CD5FF));
			legs.setItemMeta(chestMeta);

			// Boots
			ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
			ItemMeta bootsMeta = boots.getItemMeta();
			bootsMeta.setDisplayName(ChatColor.BLUE + "Poseidon's Boots");
			boots.setItemMeta(bootsMeta);

			// Sword
			ItemStack sword = new ItemStack(Material.STONE_SWORD);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName(ChatColor.BLUE + "Poseidon's Sword");
			sword.setItemMeta(swordMeta);

			// Inventory Management
			inventory.addItem(sword);
			Methods.reSoup(player);
			inventory.setHelmet(helm);
			inventory.setChestplate(chest);
			inventory.setLeggings(legs);
			inventory.setBoots(boots);

			// Add kit
			Main.playPoseidon.put(player.getName(), "Poseidon");
			
			Debug.tryDebug("Poseidon selected by " + player.getName());

		}else{
			player.sendMessage("You do not have permission to play as Poseidon");
		}
	}

}
