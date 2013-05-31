package com.theaetherserver.kits.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.theaetherserver.kits.Debug;
import com.theaetherserver.kits.Main;
import com.theaetherserver.kits.Methods;
import com.theaetherserver.kits.checkworld.CheckWorld;
import com.theaetherserver.cooldown.*;

public class KitEvents implements Listener{

	static String prefix = ChatColor.GREEN + "[SlimeKits]" + ChatColor.DARK_AQUA + " ";
	 
    @SuppressWarnings("unused")
	private Main plugin;
    private static KitEvents instance;
    
    public static KitEvents inst(){
    	return instance;
    }
    
    public KitEvents (Main plugin) {
    	this.plugin = plugin;
    }

    
    // SPIDER
	@EventHandler
	public void poison(EntityDamageByEntityEvent event) {
		String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Player){
			Player p = (Player) event.getEntity();
			Player damager = (Player) event.getDamager();
			if(CheckWorld.check(p)){
				if(Main.playSpider.containsKey(damager.getName())){
					if (p instanceof Player && damager instanceof Player && damager.getItemInHand().getType().equals(Material.SPIDER_EYE)) {
						if(Cooldowns.tryCooldown(damager, "Spider", 15000)){
							p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
							Debug.tryDebug(damager.getName() + " has poisoned " + p.getName());
						}else{
							damager.sendMessage(prefix + "You have " + (Cooldowns.getCooldown(damager, "Spider") / 1000) + " seconds left.");
							Debug.tryDebug(damager.getName() + " is on cooldown for move: Spider");
						}
					}
				}
			}
		}
	}
	
	// BLAZE
	@EventHandler
	public void fire(EntityDamageByEntityEvent event) {
		String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Player){
			Player p = (Player) event.getEntity();
			Player damager = (Player) event.getDamager();
			if(CheckWorld.check(p) && damager.getWorld().getName().equalsIgnoreCase("pvp")){
				if(Main.playBlaze.containsKey(damager.getName())){
					if (p instanceof Player && damager instanceof Player && damager.getItemInHand().getType().equals(Material.BLAZE_ROD)) {
						if(Cooldowns.tryCooldown(damager, "Blaze", 15000)){
							p.setFireTicks(200);
							Debug.tryDebug(damager.getName() + " set " + p.getName() + " on fire");
						}else{
							damager.sendMessage(prefix + "You have " + (Cooldowns.getCooldown(damager, "Blaze") / 1000) + " seconds left.");
							Debug.tryDebug(damager.getName() + " is on cooldown for move: Blaze");
						}
					}
				}
			}
		}

	}
	
	@EventHandler
	public void damageResist(EntityDamageEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player) event.getEntity();
			if(Main.playBlaze.containsKey(player.getName())){
				DamageCause blaze = event.getCause();
				if(blaze == DamageCause.LAVA || blaze == DamageCause.FIRE || blaze == DamageCause.FIRE_TICK){
					event.setCancelled(true);
					Debug.tryDebug(player.getName() + " is immune to lava/fire/firetick. Did not take damage");
				}
			}else if(Main.playCannon.containsKey(player.getName())){
				DamageCause cannon = event.getCause();
				if(cannon == DamageCause.BLOCK_EXPLOSION || cannon == DamageCause.ENTITY_EXPLOSION){
					event.setCancelled(true);
					Debug.tryDebug(player.getName() + " is immune to explosions. Did not take damage");
				}
			}else if(Main.playAngel.containsKey(player.getName())){
				DamageCause angel = event.getCause();
				if(angel == DamageCause.FALL){
					int damage = event.getDamage();
					int give = (int) (damage * .5);
					event.setCancelled(true);
					player.damage(give);
					Debug.tryDebug(player.getName() + " only takes 50% fall damage");
				}
			}
		}
	}
	
	// TRICKSTER
	@EventHandler
	public void trick(EntityDamageByEntityEvent event){
		String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Player){
			Player player = (Player) event.getEntity();
			Player damager = (Player) event.getDamager();
			if(CheckWorld.check(player) && damager.getWorld().getName().equalsIgnoreCase("pvp")){
				if(Main.playReaper.containsKey(damager.getName())){
					if(damager.getItemInHand().getType().equals(Material.REDSTONE_TORCH_ON)){
						if(Cooldowns.tryCooldown(damager, "Trick", 15000)){
							Location loc = player.getLocation();	
							Location flipped = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ(), (loc.getYaw() < 180 ? loc.getYaw() - 180 : loc.getYaw() + 180), loc.getPitch());
							player.teleport(flipped);
							Debug.tryDebug(damager.getName() + " flipped " + player.getName());
						}else{
							damager.sendMessage(prefix + "You have " + (Cooldowns.getCooldown(damager, "Trick") / 1000) + " seconds left.");
							Debug.tryDebug(damager.getName() + " is on cooldown for move: Trickster");
						}
					}
				}
			}
		}
	}
	
	
	// FISHERMAN
	@EventHandler
	public void fisher(PlayerFishEvent event){
		if((event.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)) && (event.getCaught().getType().equals(EntityType.PLAYER))){
			Player player = (Player) event.getCaught();
			if(CheckWorld.check(player) && Main.playFisher.containsKey(event.getPlayer().getName())){
				Methods.teleport(player, event.getPlayer());
				Debug.tryDebug(event.getPlayer().getName() + " fished " + player.getName());
			}
		}
	}
	
	// TURTLE / BLAZE
	@EventHandler
	public void turtle(PlayerMoveEvent event){
		Player player = event.getPlayer();
		if(Main.playBlaze.containsKey(player.getName())){
			Location loc = player.getLocation();
			Block locBlock = loc.getBlock();
			Material block = locBlock.getType();
			if(block == Material.LAVA || block == Material.STATIONARY_LAVA || block == Material.FIRE){
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
				player.setFireTicks(0);
			}
			
			if(player.getFireTicks() >= 1){
				player.setFireTicks(0);
			}
		}else if(Main.playPoseidon.containsKey(player.getName())){
			Material block = player.getLocation().getBlock().getType();
			if(block == Material.WATER || block == Material.STATIONARY_WATER){
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 20, 0));
			}
		}else if(Main.playAngel.containsKey(player.getName())){
			Location loc = player.getLocation();
			if(loc.getY() > 39){
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
			}
		}
	}
	
	// WIP - CREEPER
	@EventHandler
	public void wither(PlayerInteractEvent event){
		Player p = event.getPlayer();
		if(CheckWorld.check(p)){
			if(p.getItemInHand() != null && p.getItemInHand().getType().equals(Material.SULPHUR)){
				if(Main.playCreeper.containsKey(p.getName())){
					p.getWorld().createExplosion(p.getLocation(), 9);
					Debug.tryDebug(p.getName() + " exploded as Creeper");
		            //Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		                
		               // @Override
		               // public void run() {
		           
		                //    p.setHealth(0);
		           
		              //  }
		             // },5L);
				}
			}else if(p.getItemInHand() != null && p.getItemInHand().getType().equals(Material.WOOD_HOE)){
				if(Main.playWither.containsKey(p.getName())){
					long length = 15000;
					if(Cooldowns.tryCooldown(p, "Wither", length)){
						WitherSkull wither = p.getWorld().spawn(p.getEyeLocation().add(p.getLocation().getDirection().normalize()), WitherSkull.class);
						wither.setVelocity(p.getLocation().getDirection().multiply(2));
						Debug.tryDebug(p.getName() + " has shot a Wither Skull");
						for(Player player : Bukkit.getOnlinePlayers()){
							if(CheckWorld.check(player)){
								player.playSound(player.getLocation(), Sound.GHAST_CHARGE, 1, 1);
							}
						}
					}else{
						p.sendMessage(prefix + "You have " + (Cooldowns.getCooldown(p, "Wither") / 1000) + " seconds left.");
						Debug.tryDebug(p.getName() + " is on cooldown for move: Wither");
					}
				}
			}else if(p.getItemInHand() != null && p.getItemInHand().getType().equals(Material.TNT)){
				if(Main.playCannon.containsKey(p.getName())){
					long length = 15000;
					if(Cooldowns.tryCooldown(p, "Cannon", length)){
						TNTPrimed cannon = p.getWorld().spawn(p.getEyeLocation().add(p.getLocation().getDirection().normalize()), TNTPrimed.class);
						cannon.setFuseTicks(30);
						cannon.setVelocity(p.getLocation().getDirection().multiply(1));
						Debug.tryDebug(p.getName() + " shot TNT");
					}else{
						p.sendMessage(prefix + "You have " + (Cooldowns.getCooldown(p, "Cannon") / 1000) + " seconds left.");
						Debug.tryDebug(p.getName() + " is on cooldown for move: Cannon");
					}
				}
			}else if(p.getItemInHand() != null && p.getItemInHand().getType().equals(Material.WOOD_AXE)){
				if(Main.playThor.containsKey(p.getName())){
					long length = 10000;
					if(Cooldowns.tryCooldown(p, "Thor", length)){
						p.getWorld().strikeLightning(event.getClickedBlock().getLocation());
						Debug.tryDebug(p.getName() + " struck lightning");
					}else{
						p.sendMessage(prefix + "You have " + (Cooldowns.getCooldown(p, "Thor") / 1000) + " seconds left.");
						Debug.tryDebug(p.getName() + " is on cooldown for move: Thor");
					}
				}
			}else if(p.getItemInHand() != null && p.getItemInHand().getType().equals(Material.SLIME_BALL)){
				if(Main.playSoldier.containsKey(p.getName())){
					long length = 5000;
					if(Cooldowns.tryCooldown(p, "Soldier", length)){
						Snowball snow = p.getWorld().spawn(p.getEyeLocation().add(p.getLocation().getDirection().normalize()), Snowball.class);
						snow.setMetadata("Label", new FixedMetadataValue(Main.inst(), "Soldier"));
						snow.setVelocity(p.getLocation().getDirection().multiply(1.5));
						Debug.tryDebug(p.getName() + " has thrown a flash grenade");
						if(p.getInventory().getItemInHand().getAmount() > 1){
							InventoryMethods.remove(p.getInventory(), Material.SLIME_BALL, 1, (short)0);
						}else{
							p.getInventory().remove(Material.SLIME_BALL);
						}
					}else{
						p.sendMessage(prefix + "You have " + (Cooldowns.getCooldown(p, "Soldier") / 1000 + " seconds left."));
						Debug.tryDebug(p.getName() + " is on cooldown for move: Soldier");
					}
				}
			}else if(p.getItemInHand() != null && p.getItemInHand().getType().equals(Material.DIAMOND_BOOTS)){
				if(Main.playJumper.containsKey(p.getName())){
					if(p.isSneaking()){
						Location loc = p.getLocation();
						double y = loc.getY() - 2;
						Location newLoc = new Location(loc.getWorld(), loc.getX(), y, loc.getZ());
						if(newLoc.getBlock().getType() != Material.AIR){
							p.setVelocity(p.getLocation().getDirection().multiply(3));
						}
					}else{
						Location loc = p.getLocation();
						double y = loc.getY() - 1;
						Location newLoc = new Location(loc.getWorld(), loc.getX(), y, loc.getZ());
						if(newLoc.getBlock().getType() != Material.AIR){
							Vector length = p.getLocation().getDirection();
							Vector height = new Vector(0, 2, 0);
							length.add(height);
							p.setVelocity(length);
						}
					}
				}
			}
		}
	}
	
	
	@EventHandler
	public void turtle(EntityDamageByEntityEvent event){
		if(event.getDamager() instanceof Player){
			Player player = (Player) event.getDamager();
			if(Main.playTurtle.containsKey(player.getName())){
				if(player.isSneaking()){
					event.setCancelled(true);
					Debug.tryDebug(player.getName() + " can't hit while shifting. Is Turtle");
				}
			}
		}
	}
	
	@EventHandler
	public void projectileHit(EntityDamageByEntityEvent event){
		if(event.getDamager() instanceof Projectile){
			Projectile proj = (Projectile) event.getDamager();
			if(proj instanceof Snowball && proj.hasMetadata("Label")){
				if(proj.getMetadata("Label").toString().equals("Soldier")){
					if(!(event.getEntity() instanceof Player)){
						return;
					}
					Player player = (Player) event.getEntity();
					player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 4));
					Debug.tryDebug(player.getName() + " received blindness from Soldier's flash");
				}
			}
		}
	}
	

}
