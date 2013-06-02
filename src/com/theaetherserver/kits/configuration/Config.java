package com.theaetherserver.kits.configuration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;

public class Config {
	@SuppressWarnings("unused")
	private Main plugin;
	public Config (Main plugin) {
		this.plugin = plugin;
	}

	static File configFile = new File("plugins/SlimeKits/config.yml");
	static File folder = new File("plugins/SlimeKits");
	static FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
	
	public static void loadConfig() throws IOException{
		createConfig();
		Debug.tryDebug("Configuration created");
	}	
	
	public static void createConfig() throws IOException{
		if(!folder.exists())
			folder.mkdirs();
		
		if(!configFile.exists())
			configFile.createNewFile();
		
		String[] worlds = {"worlds;#example_world"};
		String[] kits = {"kits.archer.enabled;true", "kits.tank.enabled;true", "kits.turtle.enabled;true", "kits.grandpa.enabled;true", "kits.knight.enabled;true", "kits.creeper.enabled;true", "kits.ninja.enabled;true", "kits.wither.enabled;true", "kits.stomper.enabled;true", "kits.angel.enabled;true", "kits.soldier.enabled;true", "kits.spider.enabled;true", "kits.trickster.enabled;true", "kits.blaze.enabled;true", "kits.dwarf.enabled;true", "kits.fisherman.enabled;true", "kits.cannon.enabled;true", "kits.poseidon.enabled;true", "kits.thor.enabled;true", "kits.jumper.enabled;true", "kits.wizard.enabled;true", "kits.flamethrower.enabled;true"};
		String[] debug = {"debug;false"};
		
		
		for(String opt: worlds){
			String[] spl = opt.split("\\;");
			String key = spl[0];
			String val = spl[1];
			
			if(config.getString(key) == null){
				config.set(key, val);
				config.save(configFile);
			}
		}
		
		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("plugins/SlimeKits/config.yml", true)));
			out.print("#################");
			out.close();
		}catch(IOException e){
			Bukkit.getLogger().log(Level.SEVERE, "Config file does not exist or I have no permission to write to it!");
			e.printStackTrace();
		}
		
		for(String opt : kits){
			String[] spl = opt.split("\\;");
			String key = spl[0];
			
			if(config.getString(key) == null){
				config.set(key, true);
				config.save(configFile);
			}
		}
		
		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("plugins/SlimeKits/config.yml", true)));
			out.print("#################");
			out.close();
		}catch(IOException e){
			Bukkit.getLogger().log(Level.SEVERE, "Config file does not exist or I have no permission to write to it!");
			e.printStackTrace();
		}
		
		for(String opt : debug){
			String[] spl = opt.split("\\;");
			String key = spl[0];
			
			if(config.getString(key) == null){
				config.set(key, false);
				config.save(configFile);
			}
		}
	}
	
	
	public static void setConfigValues(String key, String value){
		config.set(key, value);
		try {
			config.save(configFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setConfigValues(String key, List<String> list){
		config.set(key, list);
		try {
			config.save(configFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setConfigValues(String key, boolean value){
		config.set(key, value);
		try {
			config.save(configFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
