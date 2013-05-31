package com.theaetherserver.kits.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.theaetherserver.kits.Main;

public class Scoreboards {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public Scoreboards (Main plugin){
		this.plugin = plugin;
	}
	
	public static void createHealth(){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		
		Objective obj = board.registerNewObjective("showhealth", "health");
		obj.setDisplaySlot(DisplaySlot.BELOW_NAME);
		obj.setDisplayName(ChatColor.RED + "/ 20");
		
		for(Player online : Bukkit.getOnlinePlayers()){
			if(online.getWorld().getName().equalsIgnoreCase("pvp")){
				online.setScoreboard(board);
				online.setHealth(online.getHealth());
			}
		}
	}
}
