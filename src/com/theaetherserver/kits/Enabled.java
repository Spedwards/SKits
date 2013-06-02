package com.theaetherserver.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class Enabled {
	@SuppressWarnings("unused")
	private Main plugin;
	public Enabled(Main plugin){
		this.plugin = plugin;
	}
	
	private static ChatColor enabled = ChatColor.GREEN;
	private static ChatColor disabled = ChatColor.RED;
	private static ChatColor base = ChatColor.GOLD;
	
	public static final List<String> enabledKits = new ArrayList<String>();
	
	public static void populateList(){
		if(Main.inst().getConfig().getBoolean("kits.archer.enabled")){
			enabledKits.add(enabled + "Archer" + base);
		}else{
			enabledKits.add(disabled + "Archer" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.tank.enabled")){
			enabledKits.add(enabled + "Tank" + base);
		}else{
			enabledKits.add(disabled + "Tank" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.grandpa.enabled")){
			enabledKits.add(enabled + "Grandpa" + base);
		}else{
			enabledKits.add(disabled + "Grandpa" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.turtle.enabled")){
			enabledKits.add(enabled + "Turtle" + base);
		}else{
			enabledKits.add(disabled + "Turtle" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.knight.enabled")){
			enabledKits.add(enabled + "Knight" + base);
		}else{
			enabledKits.add(disabled + "Knight" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.creeper.enabled")){
			enabledKits.add(enabled + "Creeper" + base);
		}else{
			enabledKits.add(disabled + "Creeper" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.ninja.enabled")){
			enabledKits.add(enabled + "Ninja" + base);
		}else{
			enabledKits.add(disabled + "Ninja" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.wither.enabled")){
			enabledKits.add(enabled + "Wither" + base);
		}else{
			enabledKits.add(disabled + "Wither" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.stomper.enabled")){
			enabledKits.add(enabled + "Stomper" + base);
		}else{
			enabledKits.add(disabled + "Stomper" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.angel.enabled")){
			enabledKits.add(enabled + "Angel" + base);
		}else{
			enabledKits.add(disabled + "Angel" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.soldier.enabled")){
			enabledKits.add(enabled + "Soldier" + base);
		}else{
			enabledKits.add(disabled + "Soldier" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.spider.enabled")){
			enabledKits.add(enabled + "Spider" + base);
		}else{
			enabledKits.add(disabled + "Spider" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.trickster.enabled")){
			enabledKits.add(enabled + "Trickster" + base);
		}else{
			enabledKits.add(disabled + "Trickster" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.blaze.enabled")){
			enabledKits.add(enabled + "Blaze" + base);
		}else{
			enabledKits.add(disabled + "Blaze" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.dwarf.enabled")){
			enabledKits.add(enabled + "Dwarf" + base);
		}else{
			enabledKits.add(disabled + "Dwarf" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.fisherman.enabled")){
			enabledKits.add(enabled + "Fisherman" + base);
		}else{
			enabledKits.add(disabled + "Fisherman" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.cannon.enabled")){
			enabledKits.add(enabled + "Cannon" + base);
		}else{
			enabledKits.add(disabled + "Cannon" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.poseidon.enabled")){
			enabledKits.add(enabled + "Poseidon" + base);
		}else{
			enabledKits.add(disabled + "Poseidon" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.thor.enabled")){
			enabledKits.add(enabled + "Thor" + base);
		}else{
			enabledKits.add(disabled + "Thor" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.jumper.enabled")){
			enabledKits.add(enabled + "Jumper" + base);
		}else{
			enabledKits.add(disabled + "Jumper" + base);
		}
		if(Main.inst().getConfig().getBoolean("kits.wizard.enabled")){
			enabledKits.add(enabled + "Wizard" + base);
		}else{
			enabledKits.add(disabled + "Wizard" + base);
		}
	}
	
	public static List<String> returnEnabledKits(){
		return enabledKits;
	}
}
