package com.theaetherserver.kits.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import com.theaetherserver.kits.Main;

public class SignCreate implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;
	
	public SignCreate(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void signCreate(SignChangeEvent event){
		String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
		Player player = event.getPlayer();
		if(player.isOp()){
			if(event.getLine(0).equalsIgnoreCase("[Kit]")){
				if(event.getLine(1).equalsIgnoreCase("lobby")){
					event.setLine(0, null);
					event.setLine(1, ChatColor.DARK_BLUE + "[Warp]");
					event.setLine(2, ChatColor.BOLD + "Lobby");
					player.sendMessage(prefix + "Lobby sign created.");
				}else if(event.getLine(1).equalsIgnoreCase("kits")){
					event.setLine(0, null);
					event.setLine(1, ChatColor.DARK_BLUE + "[Kits]");
					event.setLine(2, "Lobby");
					player.sendMessage(prefix + "Kits Lobby sign created.");
				}else if(event.getLine(1).equalsIgnoreCase("1v1")){
					event.setLine(0, null);
					event.setLine(1, ChatColor.DARK_BLUE + "[1v1]");
					event.setLine(2, "Lobby");
					player.sendMessage(prefix + "1v1 Lobby sign created.");
				}else if(event.getLine(1).equalsIgnoreCase("classic")){
					event.setLine(0, null);
					event.setLine(1, ChatColor.DARK_BLUE + "[Classic]");
					event.setLine(2, "Lobby");
					player.sendMessage(prefix + "Classic Lobby sign created.");
				}else if(event.getLine(1).equalsIgnoreCase("spawn")){
					event.setLine(0, null);
					event.setLine(1, ChatColor.DARK_BLUE + "[Spawn]");
				}else if(event.getLine(1).equalsIgnoreCase("pvp")){
					event.setLine(0, null);
					event.setLine(1, ChatColor.DARK_BLUE + "[Kit]");
					event.setLine(2, ChatColor.BOLD + "PVP");
				}else if(event.getLine(1).equalsIgnoreCase("choose")){
					event.setLine(0, null);
					event.setLine(1, ChatColor.DARK_BLUE + "[SlimeKits]");
					event.setLine(2, "Choose your kit");
				}else{
					player.sendMessage(prefix + event.getLine(1) + " is not a kit.");
				}
			}
		}else{
			player.sendMessage(prefix + "You do not have permission to do this.");
		}
	}
	
}
