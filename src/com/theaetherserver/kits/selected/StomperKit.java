package com.theaetherserver.kits.selected;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.Methods;

public class StomperKit {
	@SuppressWarnings("unused")
	private static Main plugin;
	static String prefix = ChatColor.GREEN + "[SlimeKits]" + ChatColor.DARK_AQUA;
	static ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	
	@SuppressWarnings("static-access")
	public StomperKit(Main plugin){
		this.plugin = plugin;
	}
	
	public static void selStomper(Player player){
		PlayerInventory inventory = player.getInventory();
		
		if(player.hasPermission("kit.stomper")){
					// Clear Kit
					Clear.clearKits(player);
					
					// Helmet
					ItemStack helm = new ItemStack(Material.IRON_HELMET);
					ItemMeta helmMeta = helm.getItemMeta();
					helmMeta.setDisplayName(ChatColor.GRAY + "Stomper's Helmet");
					helm.setItemMeta(helmMeta);
					
					// Chestplate
					ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
					LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
					chestMeta.setDisplayName(ChatColor.GRAY + "Stomper's Chestplate");
					chestMeta.setColor(Color.GRAY);
					chest.setItemMeta(chestMeta);					
					
					// Leggings
					ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
					LeatherArmorMeta legsMeta = (LeatherArmorMeta) legs.getItemMeta();
					legsMeta.setDisplayName(ChatColor.GRAY + "Stomper's Leggings");
					legsMeta.setColor(Color.GRAY);
					legs.setItemMeta(legsMeta);
					
					// Boots
					ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
					LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
					bootsMeta.setDisplayName(ChatColor.GRAY + "Stomper's Boots");
					bootsMeta.setColor(Color.GRAY);
					boots.setItemMeta(bootsMeta);
					
					// Sword
					ItemStack sword = new ItemStack(Material.STONE_SWORD);
					ItemMeta swordMeta = sword.getItemMeta();
					swordMeta.setDisplayName(ChatColor.GRAY + "Stomper's Sword");
					sword.setItemMeta(swordMeta);
					sword.addUnsafeEnchantment(new EnchantmentWrapper(222), 3);
					
					// Inventory Management
					inventory.addItem(sword);
					Methods.reSoup(player);
					inventory.setHelmet(helm);
					inventory.setChestplate(chest);
					inventory.setLeggings(legs);
					inventory.setBoots(boots);
					
					// Add kit
					Main.playStomper.put(player.getName(), "Stomper");
					
					Debug.tryDebug("Stomer selected by " + player.getName());
		}else{
			player.sendMessage("You do not have permission to play Stomper");
		}
	}
}
