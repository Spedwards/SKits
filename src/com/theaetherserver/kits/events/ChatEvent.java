package com.theaetherserver.kits.events;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.checkworld.CheckWorld;

public class ChatEvent implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;
	public ChatEvent(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void chatEvent(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		String msg = event.getMessage();
		String name = player.getName();
		if(CheckWorld.check(player)){
			if(Main.playArcher.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Archer] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playTank.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Tank] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playTurtle.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Turtle] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playGrandpa.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Grandpa] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playKnight.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Knight] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playCreeper.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Creeper] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playNinja.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Ninja] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playWither.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Wither] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playStomper.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Stomper] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playAngel.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Angel] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playSoldier.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Soldier] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playSpider.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Spider] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playReaper.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Trickster] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playBlaze.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Blaze] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playDwarf.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Dwarf] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playFisher.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Fisherman] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playCannon.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Cannon] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playPoseidon.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Poseidon] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playThor.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Thor] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else if(Main.playJumper.containsKey(name)){
				event.setFormat(ChatColor.GOLD + "[Jumper] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}else{
				event.setFormat(ChatColor.GOLD + "[None] " + isRank(player) + ChatColor.BLUE + ": " + msg);
			}
		}
	}
	
	public static String isRank(Player player){
		List<String> admin = Main.inst().getConfig().getStringList("ranks.admin");
		List<String> mod = Main.inst().getConfig().getStringList("ranks.mod");
		if(admin.contains(player.getName())){
			return ChatColor.RED + player.getName();
		}else{
			if(mod.contains(player.getName())){
				return ChatColor.DARK_PURPLE + player.getName();
			}else{
				return ChatColor.DARK_AQUA + player.getName();
			}
		}
	}
}
