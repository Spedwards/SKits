package com.theaetherserver.kits;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.theaetherserver.kits.configuration.Config;
import com.theaetherserver.kits.configuration.PlayerStatistics;
import com.theaetherserver.kits.events.ChatEvent;
import com.theaetherserver.kits.events.KitEvents;
import com.theaetherserver.kits.events.Other;
import com.theaetherserver.kits.events.PotionMove;
import com.theaetherserver.kits.events.ResistanceEvent;
import com.theaetherserver.kits.events.SignCreate;
import com.theaetherserver.kits.events.Stomper;
import com.theaetherserver.kits.events.Update;
import com.theaetherserver.kits.events.death.DeathEvent;
import com.theaetherserver.kits.events.killstreaks.HitKillstreakLevel;
import com.theaetherserver.kits.events.killstreaks.UseKillstreakListener;
import com.theaetherserver.kits.scoreboard.Scoreboards;
import com.theaetherserver.kits.selected.PVP;

public class Main extends JavaPlugin implements Listener{

	// Kit HashMaps
	public final static HashMap<String, String> playArcher = new HashMap<String, String>();
	public final static HashMap<String, String> playTank = new HashMap<String, String>();
	public final static HashMap<String, String> playKnight = new HashMap<String, String>();
	public final static HashMap<String, String> playNinja = new HashMap<String, String>();
	public final static HashMap<String, String> playSpider = new HashMap<String, String>();
	public final static HashMap<String, String> playReaper = new HashMap<String, String>();
	public final static HashMap<String, String> playBlaze = new HashMap<String, String>();
	public final static HashMap<String, String> playDwarf = new HashMap<String, String>();
	public final static HashMap<String, String> playFisher = new HashMap<String, String>();
	public final static HashMap<String, String> playTurtle = new HashMap<String, String>();
	public final static HashMap<String, String> playCreeper = new HashMap<String, String>();
	public final static HashMap<String, String> playWither = new HashMap<String, String>();
	public final static HashMap<String, String> playStomper = new HashMap<String, String>();
	public final static HashMap<String, String> playCannon = new HashMap<String, String>();
	public final static HashMap<String, String> playPoseidon = new HashMap<String, String>();
	public final static HashMap<String, String> playThor = new HashMap<String, String>();
	public final static HashMap<String, String> playGrandpa = new HashMap<String, String>();
	public final static HashMap<String, String> playAngel = new HashMap<String, String>();
	public final static HashMap<String, String> playSoldier = new HashMap<String, String>();
	public final static HashMap<String, String> playJumper = new HashMap<String, String>();
	
	public final static HashMap<String, String> buildToggle = new HashMap<String, String>();
	
	public final static ArrayList<Material> items = new ArrayList<Material>();
	public final static ArrayList<Material> armour = new ArrayList<Material>();


	private static Main instance;
	
	public static final Logger log = Logger.getLogger("Minecraft");

	public void onEnable(){
		instance = this;

		PluginManager pm = getServer().getPluginManager();
		
		// Main package
		pm.registerEvents(this, this);
		pm.registerEvents(new MenuListener(this), this);
		
		// Main.Events package
		pm.registerEvents(new KitEvents(this), this);
		pm.registerEvents(new Other(this), this);
		pm.registerEvents(new SignCreate(this), this);
		pm.registerEvents(new Stomper(this), this);
		pm.registerEvents(new PotionMove(this), this);
		pm.registerEvents(new ResistanceEvent(this), this);
		pm.registerEvents(new Update(this), this);
		pm.registerEvents(new ChatEvent(this), this);
		
		// Main.Events.Killstreaks package
		pm.registerEvents(new HitKillstreakLevel(this), this);
		pm.registerEvents(new UseKillstreakListener(this), this);
		
		// Main.Events.Death package
		pm.registerEvents(new DeathEvent(this), this);
		
		// Commands
		getCommand("pvp").setExecutor(new Commands());
		getCommand("slimekits").setExecutor(new ConfigCmds());
		getCommand("stats").setExecutor(new Statistics());

		try {
			Config.loadConfig();
			PlayerStatistics.createStats();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Methods.createMenu();
		Methods.createSelectMenu();
		Methods.banDrops();
		Methods.armour();
		
		
		Scoreboards.createHealth();
		
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e) {
			// Failed to submit the stats :-(
		}
		
		Enabled.populateList();
		
		com.theaetherserver.kits.enchantments.Main.addEnchantments();
		
		Debug.tryDebug("Enabled");
	}
	
	public void onDisable(){
		instance = null;
		Debug.tryDebug("Disabled");
	}
	
	public static Main inst(){
		return instance;
	}
	
	@SuppressWarnings("unused")
	@EventHandler
	public void signInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		PlayerInventory inventory = player.getInventory();
		String prefix = ChatColor.GREEN + "[SlimeKits] " + ChatColor.DARK_AQUA;
		ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
		if(event.getClickedBlock() != null && event.getClickedBlock().getType() != Material.AIR && event.getClickedBlock().getState() instanceof Sign){
			Sign sign = (Sign) event.getClickedBlock().getState();
			if(sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_BLUE + "[Warp]") && sign.getLine(2).equalsIgnoreCase(ChatColor.BOLD + "Lobby")){
				World lobby = Bukkit.getWorld("lobby");
				Location loc = new Location(lobby, 980.5, 5, 360.5, 270, 0);
				player.teleport(loc);
				player.sendMessage(prefix + "Warping to the lobby.");
			}else if(sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_BLUE + "[Kits]")){
				World pvp = Bukkit.getWorld("pvp");
				Location loc = new Location(pvp, -826.5, 8, 1381.5);
				player.teleport(loc);
				player.sendMessage(prefix + "Warping to the kits lobby.");
			}else if(sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_BLUE + "[1v1]")){
				World onev1 = Bukkit.getWorld("1v1");
				Location loc = new Location(onev1, 1247.5, 8, -459.5, 180, 0);
				player.teleport(loc);
				player.sendMessage(prefix + "Warping to the 1v1 lobby.");
			}else if(sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_BLUE + "[Classic]")){
				World classic = Bukkit.getWorld("classic");
				Location loc = new Location(classic, -489.5, 87, -275.5);
				player.teleport(loc);
				player.sendMessage(prefix + "Warping to the classic lobby.");
			}else if(sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_BLUE + "[Spawn]")){
				World spawn = Bukkit.getWorld("PublicServerWorld Backup");
				Location loc = new Location(spawn, 59.5, 71, -0.5);
				player.teleport(loc);
				player.sendMessage(prefix + "Warping to spawn.");
			}else if(sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_BLUE + "[Kit]") && sign.getLine(2).equalsIgnoreCase(ChatColor.BOLD + "PVP")){
				PVP.selPVP(player);
			}else if(sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_BLUE + "[SlimeKits]") && sign.getLine(2).equalsIgnoreCase("Choose your kit")){
				Methods.openMenu(player);
			}
		}
	}
}
