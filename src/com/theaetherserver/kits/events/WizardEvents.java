package com.theaetherserver.kits.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.theaetherserver.cooldown.Cooldowns;
import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;

public class WizardEvents implements Listener{
	
	@EventHandler
	public void wandSwap(PlayerToggleSneakEvent event){
		Player player = event.getPlayer();
		if(Main.playWizard.containsKey(player.getName())){
			if(player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Wand")){
				ItemStack item = player.getItemInHand();
				List<String> type = item.getItemMeta().getLore();
				if(type.contains(ChatColor.DARK_PURPLE + "Mode: Melee")){
					String lore = ChatColor.DARK_PURPLE + "Mode: Fire";
					recreateWand(player, lore, item);
				}else if(type.contains(ChatColor.DARK_PURPLE + "Mode: Fire")){
					String lore = ChatColor.DARK_PURPLE + "Mode: Arrow";
					recreateWand(player, lore, item);
				}else if(type.contains(ChatColor.DARK_PURPLE + "Mode: Arrow")){
					String lore = ChatColor.DARK_PURPLE + "Mode: Melee";
					recreateWand(player, lore, item);
				}
			}
		}
	}
	
	@EventHandler
	public void wandUse(PlayerInteractEvent event){
		Player player = event.getPlayer();
		String prefix = ChatColor.GREEN + "[SlimeKits]" + ChatColor.DARK_AQUA + " ";
		if(Main.playWizard.containsKey(player.getName())){
			if(player.getItemInHand().getType().equals(Material.STICK)){
				List<String> type = player.getItemInHand().getItemMeta().getLore();
				if(type.contains(ChatColor.DARK_PURPLE + "Mode: Melee")){
					
				}else if(type.contains(ChatColor.DARK_PURPLE + "Mode: Fire")){
					if(Cooldowns.tryCooldown(player, "Wizard:Fire", 10000)){
						FallingBlock fire = player.getWorld().spawnFallingBlock(player.getEyeLocation().add(player.getLocation().getDirection().normalize()), Material.FIRE, (byte)0);
						fire.setVelocity(player.getLocation().getDirection().multiply(2));
						Debug.tryDebug(player.getName() + " shot fire as Wizard");
					}else{
						player.sendMessage(prefix + "You have " + (Cooldowns.getCooldown(player, "Wizard:Fire") / 1000) + " seconds left.");
						Debug.tryDebug(player.getName() + " is on cooldown for move: Wizard. Type: Fire");
					}
				}else if(type.contains(ChatColor.DARK_PURPLE + "Mode: Arrow")){
					if(Cooldowns.tryCooldown(player, "Wizard:Arrow", 10000)){
						Arrow arrow = player.getWorld().spawn(player.getEyeLocation().add(player.getLocation().getDirection().normalize()), Arrow.class);
						arrow.setVelocity(player.getLocation().getDirection().multiply(5));
						Debug.tryDebug(player.getName() + " shot an arrow as Wizard");
					}else{
						player.sendMessage(prefix + "You have " + (Cooldowns.getCooldown(player, "Wizard:Arrow") / 1000) + " seconds left");
						Debug.tryDebug(player.getName() + " is on cooldown for move: Wizard. Type: Arrow");
					}
				}
			}
		}
	}
	
	@EventHandler
	public void wandMelee(EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Player){
			Player damager = (Player) event.getDamager();
			if(Main.playWizard.containsKey(damager.getName())){
				if(damager.getItemInHand().getType().equals(Material.STICK)){
					List<String> lore = damager.getItemInHand().getItemMeta().getLore();
					if(lore.contains(ChatColor.DARK_PURPLE + "Mode: Melee")){
						event.setDamage(5);
					}
				}
			}
		}
	}
	
	public static void recreateWand(Player player, String lore, ItemStack item){
		
		player.getInventory().remove(Material.STICK);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.BLUE + "Wand");
		List<String> lores = new ArrayList<String>();
		lores.add(lore);
		meta.setLore(lores);
		item.setItemMeta(meta);
		item.addUnsafeEnchantment(new EnchantmentWrapper(222), 3);
		
		player.getInventory().addItem(item);
		
	}
}
