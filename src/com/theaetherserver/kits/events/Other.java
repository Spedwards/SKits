package com.theaetherserver.kits.events;

import net.minecraft.server.v1_5_R3.Packet205ClientCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_5_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.checkworld.CheckWorld;
import com.theaetherserver.kits.configuration.PlayerStatistics;
import com.theaetherserver.kits.selected.Clear;

public class Other implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;

	public Other(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void drops(final PlayerDeathEvent event){
		if(event.getEntity() instanceof Player){ // Check if both entity is a player and killer is a player
			final Player player = event.getEntity(); // Player
			if(player.getKiller() instanceof Player){
				Player killer = (Player) player.getKiller();
				if(CheckWorld.check(player)){ // Checks if player is in world pvp.


					PlayerStatistics.addKill(killer.getName());
					PlayerStatistics.addDeath(player.getName());
					PlayerStatistics.addKillstreak(player.getName(), player.getLevel());
					
					killer.setLevel(killer.getLevel() + 1); // Killer gets one level added to them.
					
					Debug.tryDebug(player.getName() + " died to " + killer.getName());



					Packet205ClientCommand packet = new Packet205ClientCommand(); // Create packet
					packet.a = 1; 
					((CraftPlayer) player).getHandle().playerConnection.a(packet); // Send the player the packet.
					
					event.getDrops().clear(); // Clear drops

					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.inst(), new Runnable() {
						@Override
						public void run(){
							event.setDroppedExp(0); // No experience drop on death.
							player.setLevel(0);

							World world = Bukkit.getWorld("pvp"); // Locate world
							Location loc = new Location(world, -826.5, 9.5, 1381.5); // Sets a location
							player.teleport(loc); // Teleports the player to location

							Clear.clearKits(player); // Clear kit
						}
					}, 5L);

				}
			}else{
				if(CheckWorld.check(player)){
					Packet205ClientCommand packet = new Packet205ClientCommand(); // Create packet
					packet.a = 1; 
					((CraftPlayer) player).getHandle().playerConnection.a(packet); // Send the player the packet.
					
					event.getDrops().clear(); // Clear drops
					
					PlayerStatistics.addDeath(player.getName());
					PlayerStatistics.addKillstreak(player.getName(), player.getLevel());

					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.inst(), new Runnable() {
						@Override
						public void run(){
							event.getDrops().clear(); // Clear drops
							event.setDroppedExp(0); // No experience drop on death.
							player.setLevel(0);

							World world = Bukkit.getWorld("pvp"); // Locate world
							Location loc = new Location(world, -826.5, 9.5, 1381.5); // Sets a location
							player.teleport(loc); // Teleports the player to location

							Clear.clearKits(player); // Clear kit
						}
					}, 5L);
					Debug.tryDebug(player.getName() + " died to environmental damage.");
				}
			}
		}
	}

	@EventHandler
	public void explode(EntityExplodeEvent event){
		if(CheckWorld.check(event.getEntity())){
			event.setCancelled(true);
			Debug.tryDebug("Explosion cancelled");
		}
	}

	@EventHandler
	public void login(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if(CheckWorld.check(player)){

			World world = Bukkit.getWorld("pvp"); // Locate world
			Location loc = new Location(world, -826.5, 9.5, 1381.5); // Sets a location
			player.teleport(loc); // Teleports the player to location

			Clear.clearKits(player); // Clear kit
			
			Debug.tryDebug(player.getName() + " logged in on Kits world");
			
			PlayerStatistics.addPlayer(player.getName());
		}
	}
	
	@EventHandler
	public void worldChance(PlayerChangedWorldEvent event){
		Player player = event.getPlayer();
		if(CheckWorld.check(player)){
			PlayerStatistics.addPlayer(player.getName());
		}
	}

	@EventHandler
	public void pickup(PlayerPickupItemEvent event){
		Player player = event.getPlayer();
		if(CheckWorld.check(player)){
			event.setCancelled(true);
		}

	}

	@EventHandler
	public void drop(PlayerDropItemEvent e){
		Player player = e.getPlayer();
		if(CheckWorld.check(player)){
			if(Main.items.contains(e.getItemDrop().getItemStack().getType()) || Main.armour.contains(e.getItemDrop().getItemStack().getType())){
				e.setCancelled(true);
				player.sendMessage(ChatColor.RED + "You are not allowed you drop this");
			}else{
				e.getItemDrop().remove();
			}
		}
	}

	@EventHandler
	public void blockPlace(BlockPlaceEvent e){
		Player player = (Player) e.getPlayer();
		if(CheckWorld.check(player)){
			if(!Main.buildToggle.containsKey(player.getName())){
				e.setCancelled(true);
				player.sendMessage(ChatColor.RED + "You cannot build here!");
			}
		}
	}

	@EventHandler
	public void blockBreak(BlockBreakEvent e){
		Player player = e.getPlayer();
		if(CheckWorld.check(player)){
			if(!Main.buildToggle.containsKey(player.getName())){
				e.setCancelled(true);
				player.sendMessage(ChatColor.RED + "You cannot break here!");
			}
		}
	}

}
