package com.theaetherserver.kits;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;

import com.theaetherserver.kits.checkworld.CheckWorld;

public class Commands implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			PlayerInventory inventory = player.getInventory();
			if(commandLabel.equalsIgnoreCase("pvp")){
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("info")){
						// BOOK
						ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
						BookMeta bookMeta = (BookMeta) book.getItemMeta();
						bookMeta.setAuthor("Pink__Slime");
						bookMeta.setTitle(ChatColor.AQUA + "Kits Info");
						ArrayList<String> bookPage = new ArrayList<String>(); // Pages
						bookPage.add("Kits Info:\n" + ChatColor.DARK_GREEN + "Contents\n" + ChatColor.GREEN + "------------\n" + ChatColor.LIGHT_PURPLE + "Archer - 1\n" + ChatColor.AQUA + "Tank - 2\n" + ChatColor.DARK_RED + "Knight - 3\n" + ChatColor.GOLD + "Ninja - 4\n" + ChatColor.DARK_GREEN + "Spider - 5\n" + ChatColor.DARK_GRAY + "Trickster - 6\n" + ChatColor.GOLD + "Blaze - 7\n" + ChatColor.DARK_AQUA + "Turtle - 8\n" + ChatColor.DARK_PURPLE + "Dwarf - 9\n" + ChatColor.RED + "Fisherman - 10"); // Page 1
						bookPage.add(ChatColor.LIGHT_PURPLE + "Archer\n------------\nStart with a bow enchanted with:\nUnreaking 10\nInfinity 1\nSharpness 1\nPower 2\n" + "\nYou also have Chainmail armour.");
						bookPage.add(ChatColor.AQUA + "Tank\n------------\nStart with a diamond sword enchanted with Sharpness 1 and Iron Armour.\nYou also get Resistance 1.");
						bookPage.add(ChatColor.DARK_RED + "Knight\n------------\nStart with an iron sword enchanted with Unbreaking 10 and diamond armour.");
						bookPage.add(ChatColor.GOLD + "Ninja\n------------\nStart with a gold sword enchanted with Unbreaking 10 and Sharpness 3. You also get 8 enderpearls and gold boots enchanted with Protection 5, Unbreaking 10, and Feather Falling 10. You also get Swiftness 2.");
						bookPage.add(ChatColor.DARK_GREEN + "Spider\n------------\nStart with a gold sword enchanted with Unbreaking 10 and a spider eye.\nHitting a player with your spider eye gives them poison.\nStart with a Leather cap, Chainmail chest, Gold leggings and Leather Boots.");
						bookPage.add(ChatColor.DARK_GRAY + "Trickster\n------------\nStart with a gold sword enchanted with Unbreaking 10 and a redstone torch.\nHitting a player with your redstone torch makes them turn around.\nYou also have iron armour.");
						bookPage.add(ChatColor.GOLD + "Blaze\n------------\nStart with an iron sword enchanted with Unbreaking 10 and a blaze rod.\nHitting a player with your blaze rod will ignite them!\nYou also have leather armour.");
						bookPage.add(ChatColor.DARK_AQUA + "Turtle\n------------\nAs turtle you start with two swords. Your iron sword and a stone defender.\nShifting will give you Resistance and shifting while blocking with your defender gives you Resistance 4!");
						bookPage.add(ChatColor.DARK_PURPLE + "Dwarf\n------------\nStart with a Sharpness 2, Knockback 1, Iron Axe.\n Your armour is a Diamond helmet, Iron chestplate, Leather leggings and Gold boots.");
						bookPage.add(ChatColor.RED + "Fisherman\n------------\nYou start with a Knockback 1 diamond sword and a fishing rod.\nUse your fishing rod to reel opponents in!\nYour armour is leather.");
						bookMeta.setPages(bookPage);
						book.setItemMeta(bookMeta);
						inventory.addItem(book);
						return true;
					}else if(args[0].equalsIgnoreCase("choose")){
						Methods.openMenu(player);
						return true;
					}else if(args[0].equalsIgnoreCase("warp")){
						return true;
					}else if(args[0].equalsIgnoreCase("toggle")){
						if(Main.buildToggle.containsKey(player.getName())){
							Main.buildToggle.remove(player.getName());
							player.sendMessage(ChatColor.BLUE + "You can no longer build!");
							Debug.tryDebug("Build disabled for " + player.getName());
							return true;
						}else{
							Main.buildToggle.put(player.getName(), "Allow");
							player.sendMessage(ChatColor.BLUE + "You can now build!");
							Debug.tryDebug("Build enabled for " + player.getName());
							return true;
						}
					}else if(args[0].equalsIgnoreCase("worlds")){
						player.sendMessage(ChatColor.BLUE + "Worlds: " + CheckWorld.worlds);
						return true;
					}else if(args[0].equalsIgnoreCase("enabledkits")){
						player.sendMessage(ChatColor.BLUE + "Enabled Kits: " + Enabled.enabledKits);
						return true;
					}
				}else{
					player.sendMessage(ChatColor.RED + "Used: /pvp [choose:info:toggle]");
					return true;
				}
			}
		}
		return false;
	}

}
