package com.theaetherserver.kits;

public class Debug {
	
	
	public static void tryDebug(String msg){
		if(Main.inst().getConfig().getBoolean("debug")){
			System.out.println("[SlimeKits]" + msg);
		}else{
			return;
		}
	}
}
