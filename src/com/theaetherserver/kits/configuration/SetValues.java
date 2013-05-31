package com.theaetherserver.kits.configuration;

import java.util.List;

import com.theaetherserver.kits.Main;

public class SetValues {
	public static void setConfigValues(String key, String value){
		Main.inst().getConfig().set(key, value);
		Main.inst().saveConfig();
	}
	
	public static void setConfigValues(String key, List<String> list){
		Main.inst().getConfig().set(key, list);
		Main.inst().saveConfig();
	}
}
