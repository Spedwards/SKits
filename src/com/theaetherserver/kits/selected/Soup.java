package com.theaetherserver.kits.selected;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.Methods;

public class Soup {
	static String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	@SuppressWarnings("unused")
	private static Main plugin;
	
	@SuppressWarnings("static-access")
	public Soup(Main plugin){
		this.plugin = plugin;
	}
	
	public static void selSoup(Player player){
		PlayerInventory inventory = player.getInventory();

		if(Methods.isDouble(Main.inst().getConfig().getString("soup"))){
			inventory.addItem(soup);
				inventory.addItem(soup);
				inventory.addItem(soup);
				inventory.addItem(soup);
				inventory.addItem(soup);
				inventory.addItem(soup);
				inventory.addItem(soup);
				inventory.addItem(soup);
			
		}
	}

}
