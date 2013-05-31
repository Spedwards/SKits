package com.theaetherserver.kits.configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerStatistics {
	static File configFile = new File("plugins/SlimeKits/stats.yml");
	static File folder = new File("plugins/SlimeKits");
	static FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

	
	public static void createStats() throws IOException{
		if(!folder.exists())
			folder.mkdirs();
		
		if(!configFile.exists())
			configFile.createNewFile();
	}
	
	public static void addPlayer(String name){
		if(config.getString(name) == null){
			config.set(name + ".kills", 0);
			config.set(name + ".deaths", 0);
			config.set(name + ".killstreak", 0);
			try {
				config.save(configFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void addKill(String name){
		int kills = config.getInt(name + ".kills");
		int addKills = kills + 1;
		config.set(name + ".kills", addKills);
		try {
			config.save(configFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addDeath(String name){
		int deaths = config.getInt(name + ".deaths");
		int addDeaths = deaths + 1;
		config.set(name + ".deaths", addDeaths);
		try {
			config.save(configFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addKillstreak(String name, int streak){
		int killstreak = config.getInt(name + ".killstreak");
		if(streak > killstreak){
			config.set(name + ".killstreak", streak);
			try {
				config.save(configFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static int getKills(String name){
		return config.getInt(name + ".kills");
	}
	public static int getDeaths(String name){
		return config.getInt(name + ".deaths");
	}
	public static int getStreak(String name){
		return config.getInt(name + ".killstreak");
	}
}
