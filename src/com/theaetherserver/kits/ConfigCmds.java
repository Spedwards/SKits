package com.theaetherserver.kits;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.theaetherserver.kits.configuration.SetValues;

public class ConfigCmds implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("slimekits")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(player.hasPermission("slimekits.configuration")){
					if(args[0].equalsIgnoreCase("config")){
						if(args[1].equalsIgnoreCase("set")){
							if(args[2].equalsIgnoreCase("debug")){
								if(args[3].equalsIgnoreCase("true")){
									SetValues.setConfigValues("debug", "true");
									return true;
								}else if(args[3].equalsIgnoreCase("false")){
									SetValues.setConfigValues("debug", "false");
									return true;
								}else{
									player.sendMessage(ChatColor.RED + "Used: /pvp config set debug [true:false]");
									return true;
								}
							}
						}else if(args[1].equalsIgnoreCase("add")){
							if(args[2].equalsIgnoreCase("world")){
								List<String> list = Main.inst().getConfig().getStringList("worlds");
								list.add(args[3]);
								SetValues.setConfigValues("worlds", list);
								return true;
							}else if(args[2].equalsIgnoreCase("admin")){
								List<String> list = Main.inst().getConfig().getStringList("ranks.admin");
								list.add(args[3]);
								SetValues.setConfigValues("ranks.admin", list);
								return true;
							}else if(args[2].equalsIgnoreCase("mod")){
								List<String> list = Main.inst().getConfig().getStringList("ranks.mod");
								list.add(args[3]);
								SetValues.setConfigValues("ranks.mod", list);
								return true;
							}
						}else if(args[1].equalsIgnoreCase("get")){

						}else{
							player.sendMessage(ChatColor.RED + "Used: /pvp config [add:set:get]");
							return true;
						}
						return true;
					}
				}
			}
		}
		return false;
	}

}
