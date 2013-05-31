package com.theaetherserver.kits.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;

public class ResistanceEvent implements Listener{
	 
    @SuppressWarnings("unused")
	private Main plugin;
    
    public ResistanceEvent (Main plugin) {
    	this.plugin = plugin;
    }

	@EventHandler
	public void resistanceEvent(EntityDamageEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player) event.getEntity();
			int damage = event.getDamage();
			if(Main.playTurtle.containsKey(player.getName())){
				Debug.tryDebug(player.getName() + " is playing as Turtle");
				if(player.isSneaking()){
					int resistHealth = (int) (damage * 0.2);
					event.setDamage(resistHealth);
					Debug.tryDebug(player.getName() + " took reduced damage; Original: " + damage + ", Damage Taken: " + resistHealth);
				}
			}else if(Main.playTank.containsKey(player.getName())){
				Debug.tryDebug(player.getName() + " is playing as Tank");
				int resistHealth = (int) (damage * 0.8);
				event.setDamage(resistHealth);
				Debug.tryDebug(player.getName() + " took reduced damage; Original: " + damage + ", Damage Taken: " + resistHealth);
			}
		}
	}
	
}
