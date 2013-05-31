package com.theaetherserver.kits.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.theaetherserver.kits.Main;

public class Stomper implements Listener {
	  private int Range;
	  private int FallForStomp;
	  private int FallDamage;
	  @SuppressWarnings("unused")
	  private Main plugin;
	  private boolean MustHitTarget;
	  private boolean MobsCanBeStomped;
	  private boolean PlayersCanBeStomped;
	  private boolean ShiftingReducesDamage;
	  private double ShiftReduction;

	  public Stomper(Main plugin)
	  {
	    this.plugin = plugin;
	    this.Range = 4;
	    this.FallForStomp = 4;
	    this.FallDamage = 4;
	    this.MustHitTarget = false;
	    this.MobsCanBeStomped = true;
	    this.PlayersCanBeStomped = true;
	    this.ShiftingReducesDamage = true;
	    this.ShiftReduction = 0.5;
	  }

	  @EventHandler
	  public void OnFall(EntityDamageEvent event) {
	    Entity ent = event.getEntity();
	    if ((ent instanceof Player)) {
	      Player player = (Player)ent;

	      if (Main.playStomper.containsKey(player.getName()) && (event.getCause() == EntityDamageEvent.DamageCause.FALL)) {
	        Boolean targethit = Boolean.valueOf(false);
	        if (event.getDamage() > this.FallForStomp) {
	          event.setCancelled(true);
	          if (this.FallDamage > 0) {
	            player.damage(this.FallDamage);
	          }
	        }
	        for (Entity nearby : player.getNearbyEntities(this.Range, this.Range, this.Range)) {
	          if ((this.MobsCanBeStomped) && 
	            ((nearby instanceof LivingEntity)) && (!(nearby instanceof Player))) {
	            LivingEntity mob = (LivingEntity)nearby;
	            mob.damage(event.getDamage());
	            event.setCancelled(true);
	            targethit = Boolean.valueOf(true);
	          }

	          if ((this.PlayersCanBeStomped) && 
	            ((nearby instanceof Player))) {
	            Player targetplayer = (Player)nearby;
	              if (targetplayer.isSneaking()) {
	                if (this.ShiftingReducesDamage) {
	                  int Damage = (int)(event.getDamage() * this.ShiftReduction);
	                  targetplayer.damage(Damage);
	                }
	              }
	              else
	              {
	                targetplayer.damage(event.getDamage());
	              }
	              event.setCancelled(true);
	              targethit = Boolean.valueOf(true);
	              if (targetplayer.isDead()) {
	                Bukkit.getServer().broadcastMessage(player.getName() + " has stomped " + targetplayer.getName());
	              }
	          }

	        }

	        if ((this.MustHitTarget) && 
	          (!targethit.booleanValue()))
	          event.setCancelled(false);
	      }
	    }
	  }
}
