package com.theaetherserver.kits.events.death;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.checkworld.CheckWorld;
import com.theaetherserver.kits.events.killstreaks.KillstreakManagement;

public class DeathEvent implements Listener{

	@EventHandler
	public void deathEvent(PlayerDeathEvent event){
		Player player = (Player) event.getEntity();
		if(CheckWorld.check(player)){
			Debug.tryDebug(player.getName() + " died");
			if(player.getKiller() == null){
				Debug.tryDebug(player.getName() + "'s killer was null");
				return;
			}
			if(!(player.getKiller() instanceof Player)){
				Debug.tryDebug(player.getName() + "'s killer wasn't a player");
				return;
			}
			Player killer = player.getKiller();

			EntityDamageEvent lastDamage = player.getLastDamageCause();
			if(lastDamage == null){
				return;
			}
			
			if(KillstreakManagement.isKillstreak(player)){
				event.setDeathMessage(DeathHandler.killstreakDeathMessage(player, killer));
				return;
			}
			
			DamageCause cause = lastDamage.getCause();
			
			if(cause.equals(DamageCause.SUICIDE)){
				// Suicide
				event.setDeathMessage(DeathHandler.suicideDeathMessage(player));
			}else if(cause.equals(DamageCause.CUSTOM)){
				// Unkown Causes
				event.setDeathMessage(DeathHandler.customDeathMessage(player));
			}else if(cause.equals(DamageCause.BLOCK_EXPLOSION)){
				// TNT
				event.setDeathMessage(DeathHandler.blockExplosionDeathMessage(player));
			}else if(cause.equals(DamageCause.CONTACT)){
				// Cactus
				event.setDeathMessage(DeathHandler.cactusDeathMessage(player));
			}else if(cause.equals(DamageCause.DROWNING)){
				// Drowned
				event.setDeathMessage(DeathHandler.drownDeathMessage(player));
			}else if(cause.equals(DamageCause.ENTITY_EXPLOSION)){
				// Creeper
				event.setDeathMessage(DeathHandler.entityExplosionDeathMessage(player));
			}else if(cause.equals(DamageCause.FALL)){
				// Fall
				event.setDeathMessage(DeathHandler.fallDeathMessage(player));
			}else if(cause.equals(DamageCause.FIRE)){
				// Fire
				event.setDeathMessage(DeathHandler.fireDeathMessage(player));
			}else if(cause.equals(DamageCause.FIRE_TICK)){
				// Fire tick
				event.setDeathMessage(DeathHandler.fireTickDeathMessage(player));
			}else if(cause.equals(DamageCause.LAVA)){
				// Lava
				event.setDeathMessage(DeathHandler.lavaDeathMessage(player));
			}else if(cause.equals(DamageCause.MAGIC)){
				// Damage Potion / Wither Skull
				event.setDeathMessage(DeathHandler.magicDeathMessage(player));
			}else if(cause.equals(DamageCause.POISON)){
				// Poison
				event.setDeathMessage(DeathHandler.poisonDeathMessage(player));
			}else if(cause.equals(DamageCause.PROJECTILE)){
				// Projectile
				event.setDeathMessage(DeathHandler.projectileDeathMessage(player, killer));
			}else if(cause.equals(DamageCause.STARVATION)){
				// Starved
				event.setDeathMessage(DeathHandler.starveDeathMessage(player));
			}else if(cause.equals(DamageCause.SUFFOCATION)){
				// Suffocated
				event.setDeathMessage(DeathHandler.suffocateDeathMessage(player));
			}else if(cause.equals(DamageCause.VOID)){
				// Void
				event.setDeathMessage(DeathHandler.voidDeathMessage(player));
			}else if(cause.equals(DamageCause.ENTITY_ATTACK)){
				event.setDeathMessage(DeathHandler.regularDeathMessage(player, killer));
			}

		}
	}
}
