package com.theaetherserver.kits.enchantments;

import java.lang.reflect.Field;

import org.bukkit.enchantments.Enchantment;

import com.theaetherserver.kits.enchantments.custom.GlowEnchant;

public class Main {
	public static GlowEnchant glow = new GlowEnchant(222);
	
	@SuppressWarnings("unused")
	private com.theaetherserver.kits.Main plugin;
	
	public Main (com.theaetherserver.kits.Main plugin){
		this.plugin = plugin;
	}
	
	public static void addEnchantments(){
		try {
		    Field f = Enchantment.class.getDeclaredField("acceptingNew");
		    f.setAccessible(true);
		    f.set(null, true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		try{
			Enchantment.registerEnchantment(glow);
		}catch(IllegalArgumentException localIllegalArgumentException){
		}
	}
}
