package com.theaetherserver.kits.events.death;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.events.killstreaks.KillstreakManagement;

public class DeathHandler {
	private final static ChatColor blue = ChatColor.BLUE;
	private final static ChatColor gold = ChatColor.GOLD;

	public static String handleDeath(Player victim, Player killer){
		EntityDamageEvent lastDamage = victim.getLastDamageCause();

		// You should use a switch here, not the if/else-if statements
		if (killer != null){
			Debug.tryDebug(victim.getName() + "'s killer was " + killer.getName());

			switch (lastDamage.getCause()){
			case ENTITY_ATTACK:
				return DeathHandler.regularDeathMessage(victim, killer);
			case PROJECTILE:
				return DeathHandler.projectileDeathMessage(victim, killer);
			default:
				break; // TODO: Default message, good for debugging other
				// causes which involves a killer
			}
		}else{
			Debug.tryDebug(victim.getName() + "'s killer was null");

			switch (lastDamage.getCause()){
			case BLOCK_EXPLOSION:
				return DeathHandler.blockExplosionDeathMessage(victim);
			case CONTACT:
				return DeathHandler.cactusDeathMessage(victim);
			case CUSTOM:
				return DeathHandler.customDeathMessage(victim);
			case DROWNING:
				return DeathHandler.drownDeathMessage(victim);
			case ENTITY_ATTACK:
				return DeathHandler.regularDeathMessage(victim, killer);
			case ENTITY_EXPLOSION:
				return DeathHandler.entityExplosionDeathMessage(victim);
			case FALL:
				return DeathHandler.fallDeathMessage(victim);
			case FALLING_BLOCK:
				break; // TODO: Unhandled
			case FIRE:
				return DeathHandler.fireDeathMessage(victim);
			case FIRE_TICK:
				return DeathHandler.fireTickDeathMessage(victim);
			case LAVA:
				return DeathHandler.lavaDeathMessage(victim);
			case LIGHTNING:
				break; // TODO: Unhandled
			case MAGIC:
				return DeathHandler.magicDeathMessage(victim);
			case MELTING:
				break; // TODO: Unhandled
			case POISON:
				return DeathHandler.poisonDeathMessage(victim);
			case PROJECTILE:
				return DeathHandler.projectileDeathMessage(victim, killer);
			case STARVATION:
				return DeathHandler.starveDeathMessage(victim);
			case SUFFOCATION:
				return DeathHandler.suffocateDeathMessage(victim);
			case SUICIDE:
				return DeathHandler.suicideDeathMessage(victim);
			case THORNS:
				break; // TODO: Unhandled
			case VOID:
				return DeathHandler.voidDeathMessage(victim);
			case WITHER:
				break; // TODO: Unhandled
			default:
				break;
			}
		}

		return ChatColor.RED + "ERROR! Please report this! No death message was applied!";
	}

	public static String killstreakDeathMessage(Player dead, Player killer){
		return gold + killer.getName() + blue + " has ended " + gold + dead.getName() + blue + "'s " + dead.getLevel() + " killstreak";
	}

	public static String regularDeathMessage(Player dead, Player killer){
		if (KillstreakManagement.isKillstreak(dead)){
			return killstreakDeathMessage(dead, killer);
		}else{
			if (killer.getItemInHand().getType() == Material.AIR){
				return blue + killer.getName() + " has killed " + dead.getName() + " using his fists";
			}else{
				return blue + killer.getName() + " has killed " + dead.getName() + " using " + killer.getItemInHand().getItemMeta().getDisplayName();
			}
		}
	}

	public static String nulledDeathMessage(Player dead){
		if (KillstreakManagement.isKillstreak(dead)){
			return gold + "null" + blue + " has ended " + gold + dead.getName() + blue + "'s " + dead.getLevel() + " killstreak";
		}else{
			return blue + "null has killed " + dead.getName();
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
		if (KillstreakManagement.isKillstreak(dead)){
			return killstreakDeathMessage(dead, shooter);
		}
		else{
			return blue + shooter.getName() + " shot " + dead.getName() + " to death";
		}
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
