package com.theaetherserver.kits.events.death;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.theaetherserver.kits.Main;

public class DeathHandler {
	@SuppressWarnings("unused")
	private Main plugin;
	public DeathHandler (Main plugin){
		this.plugin = plugin;
	}
	
	private static ChatColor blue = ChatColor.BLUE;
	private static ChatColor gold = ChatColor.GOLD;
	
	public static String killstreakDeathMessage(Player dead, Player killer){
		return gold + killer.getName() + blue + " has ended " + gold + dead.getName() + blue + "'s " + dead.getLevel() + " killstreak";
	}
	
	public static String regularDeathMessage(Player dead, Player killer){
        if(killer.getItemInHand().getType() == Material.AIR){
                return blue + killer.getName() + " has killed " + dead.getName() + " using his fists";
        }else{
                return blue + killer.getName() + " has killed " + dead.getName() + " using " + killer.getItemInHand().getItemMeta().getDisplayName();
        }
	}
	
	public static String fallDeathMessage(Player dead){
		return blue + dead.getName() + " fell to far";
	}
	
	public static String cactusDeathMessage(Player dead){
		
		return blue + dead.getName() + " died to a cactus. Cactus is on a 1 killstreak";
	}
	
	public static String fireDeathMessage(Player dead){
		return blue + dead.getName() + " stood in the fire too long";
	}
	
	public static String fireTickDeathMessage(Player dead){
		return blue + dead.getName() + " burnt to death";
	}
	
	public static String lavaDeathMessage(Player dead){
		return blue + dead.getName() + " tried to swim in lava";
	}
	
	public static String suicideDeathMessage(Player dead){
		return blue + dead.getName() + " committed suicide";
	}
	
	public static String customDeathMessage(Player dead){
		return blue + dead.getName() + " died of unkown causes";
	}
	
	public static String blockExplosionDeathMessage(Player dead){
		return blue + dead.getName() + " died in a TNT explosion";
	}
	
	public static String entityExplosionDeathMessage(Player dead){
		return blue + dead.getName() + " died to a creeper";
	}
	
	public static String drownDeathMessage(Player dead){
		return blue + dead.getName() + " drowned";
	}
	
	public static String magicDeathMessage(Player dead){
		return blue + dead.getName() + " died from magic";
	}
	
	public static String poisonDeathMessage(Player dead){
		return blue + dead.getName() + " was poisoned";
	}
	
	public static String projectileDeathMessage(Player dead, Player shooter){
		return blue + shooter.getName() + " shot " + dead.getName() + " to death";
	}
	
	public static String starveDeathMessage(Player dead){
		return blue + dead.getName() + " starved to dead";
	}
	
	public static String suffocateDeathMessage(Player dead){
		return blue + dead.getName() + " suffocated";
	}
	
	public static String voidDeathMessage(Player dead){
		return blue + dead.getName() + " died in the void";
	}
}
