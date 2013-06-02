package com.theaetherserver.kits.events.death;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.checkworld.CheckWorld;

public class DeathEvent implements Listener{

	@EventHandler
	public void deathEvent(PlayerDeathEvent event){
		// Debug for me to see if this code changed the message or not.
		event.setDeathMessage("Player died! No message was applied.");

		// You don't need to cast a player to a player...
		Player player = event.getEntity();

		// I assume this to be true
		if (CheckWorld.check(player)){
			Debug.tryDebug(player.getName() + " died");

			// Checking if the killer is an instance of a player is not needed,
			// as the killer is always a player if not null
			Player killer = player.getKiller();

			EntityDamageEvent lastDamage = player.getLastDamageCause();
			if (lastDamage == null)
				return;

			// Another debug
			Bukkit.getServer().broadcastMessage(player.getName() + " died! He was killed by " + (killer != null ? killer.getName() : "NOONE") + " and died from " + lastDamage.getCause());

			// Let the death handler handle the checks, return the message.
			event.setDeathMessage(DeathHandler.handleDeath(player, killer));
		}
	}
}
