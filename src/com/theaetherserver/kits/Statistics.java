package com.theaetherserver.kits;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.theaetherserver.kits.configuration.PlayerStatistics;

public class Statistics implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String commandLabel, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(commandLabel.equalsIgnoreCase("stats")){
				if(args.length == 0){
					player.sendMessage(ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA + "Stats for " + player.getName());
					player.sendMessage(ChatColor.DARK_AQUA + "Kills: " + PlayerStatistics.getKills(player.getName()));
					player.sendMessage(ChatColor.DARK_AQUA + "Deaths: " + PlayerStatistics.getDeaths(player.getName()));
					player.sendMessage(ChatColor.DARK_AQUA + "Highest Killstreak: " + PlayerStatistics.getStreak(player.getName()));
					return true;
				}else if(args.length == 1){
					Player targetPlayer = player.getServer().getPlayer(args[0]);
					if(!targetPlayer.isOnline()){
						player.sendMessage(ChatColor.RED + "Player not found!");
						return true;
					}
					player.sendMessage(ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA + "Stats for " + targetPlayer.getName());
					player.sendMessage(ChatColor.DARK_AQUA + "Kills: " + PlayerStatistics.getKills(targetPlayer.getName()));
					player.sendMessage(ChatColor.DARK_AQUA + "Deaths: " + PlayerStatistics.getDeaths(targetPlayer.getName()));
					player.sendMessage(ChatColor.DARK_AQUA + "Highest Killstreak: " + PlayerStatistics.getStreak(targetPlayer.getName()));
					return true;
				}else{
					player.sendMessage(ChatColor.RED + "Used: /stats <player>");
					return true;
				}
			}
		}
		return false;
	}

}
