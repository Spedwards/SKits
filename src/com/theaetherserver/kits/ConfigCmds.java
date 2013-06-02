package com.theaetherserver.kits;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.theaetherserver.kits.checkworld.CheckWorld;
import com.theaetherserver.kits.configuration.Config;

public class ConfigCmds implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("slimekits")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(player.hasPermission("slimekits.configuration")){
					if(args.length > 0){
						if(args[0].equalsIgnoreCase("config")){
							if(args[1].equalsIgnoreCase("set")){
								if(args[2].equalsIgnoreCase("debug")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("debug", true);
										player.sendMessage(ChatColor.GOLD + "Debug: True");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("debug", false);
										player.sendMessage(ChatColor.GOLD + "Debug: False");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set debug [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("archer")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("tank")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("grandpa")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("turtle")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("knight")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("creeper")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("ninja")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("wither")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("stomper")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("angel")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("soldier")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("spider")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("trickster")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("blaze")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("dwarf")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("fisherman")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("cannon")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("poseidon")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("thor")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("jumper")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("wizard")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}else if(args[2].equalsIgnoreCase("flamethrower")){
									if(args[3].equalsIgnoreCase("true")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", true);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " enabled");
										return true;
									}else if(args[3].equalsIgnoreCase("false")){
										Config.setConfigValues("kits." + args[2].toLowerCase() + ".enabled", false);
										player.sendMessage(ChatColor.GOLD + toTitleCase(args[2]) + " disabled");
										return true;
									}else{
										player.sendMessage(ChatColor.RED + "Used: /slimekits config set " + args[2].toLowerCase() + " [true:false]");
										return true;
									}
								}
							}else if(args[1].equalsIgnoreCase("add")){
								if(args[2].equalsIgnoreCase("world")){
									List<String> list = Main.inst().getConfig().getStringList("worlds");
									list.add(args[3]);
									Config.setConfigValues("worlds", list);
									player.sendMessage(ChatColor.GOLD + "Worlds: " + CheckWorld.worlds);
									return true;
								}else if(args[2].equalsIgnoreCase("admin")){
									List<String> list = Main.inst().getConfig().getStringList("ranks.admin");
									list.add(args[3]);
									Config.setConfigValues("ranks.admin", list);
									player.sendMessage(ChatColor.GOLD + "Admins: " + Main.inst().getConfig().getStringList("ranks.admin"));
									return true;
								}else if(args[2].equalsIgnoreCase("mod")){
									List<String> list = Main.inst().getConfig().getStringList("ranks.mod");
									list.add(args[3]);
									Config.setConfigValues("ranks.mod", list);
									player.sendMessage(ChatColor.GOLD + "Mods: " + Main.inst().getConfig().getStringList("ranks.mod"));
									return true;
								}
							}else if(args[1].equalsIgnoreCase("get")){
								if(args[2].equalsIgnoreCase("debug")){
									player.sendMessage(ChatColor.GOLD + "Debug: " + Main.inst().getConfig().getBoolean("debug"));
									return true;
								}else if(args[2].equalsIgnoreCase("admin")){
									player.sendMessage(ChatColor.GOLD + "Admins: " + Main.inst().getConfig().getStringList("ranks.admin"));
									return true;
								}else if(args[2].equalsIgnoreCase("mod")){
									player.sendMessage(ChatColor.GOLD + "Mods: " + Main.inst().getConfig().getStringList("ranks.mod"));
									return true;
								}else if(args[2].equalsIgnoreCase("worlds")){
									player.sendMessage(ChatColor.GOLD + "Worlds: " + CheckWorld.worlds);
									return true;
								}else if(args[2].equalsIgnoreCase("enabledkits")){
									player.sendMessage(ChatColor.GOLD + "Enabled Kits: " + Enabled.enabledKits);
									return true;
								}else{
									player.sendMessage(ChatColor.RED + "Used: /slimekits config get [debug:admin:mod:worlds:enabledkits]");
									return true;
								}
							}else{
								player.sendMessage(ChatColor.RED + "Used: /slimekits config [add:set:get]");
								return true;
							}
							return true;
						}
					}else{
						player.sendMessage(ChatColor.RED + "Used: /slimekits config [add:set:get]");
						return true;
					}
				}
			}
		}
		return false;
	}

	public static String toTitleCase(String input) {
		StringBuilder titleCase = new StringBuilder();
		boolean nextTitleCase = true;

		for (char c : input.toCharArray()) {
			if (Character.isSpaceChar(c)) {
				nextTitleCase = true;
			} else if (nextTitleCase) {
				c = Character.toTitleCase(c);
				nextTitleCase = false;
			}

			titleCase.append(c);
		}

		return titleCase.toString();
	}

}
