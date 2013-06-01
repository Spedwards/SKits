package com.theaetherserver.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.util.Vector;

import com.theaetherserver.kits.selected.*;


public class Methods {
	@SuppressWarnings("unused")
	private Main plugin;
	private static Methods instance;
	private static InventoryHolder player;
	public static Inventory inv = Bukkit.createInventory(player, 9, ChatColor.BLUE +  "SlimeKits");
	public static Inventory select = Bukkit.createInventory(player, 27, ChatColor.BLUE + "Select a Kit");

	public Methods (Main plugin) {
		this.plugin = plugin;
	}

	public static Methods meth(){
		return instance;
	}


	public static void teleport(Player from, Player to){
		Vector vect1 = from.getLocation().toVector();
		Vector vect2 = to.getLocation().toVector();
		Vector vector = vect2.subtract(vect1).normalize();
		double distance = from.getLocation().distance(to.getLocation());
		for(double i = 1.0D; i < distance; i += 1.0D){
			vect1.add(vector);
			double x = vect1.getX();
			double y = vect1.getY();
			double z = vect1.getZ();
			from.teleport(new Location(from.getWorld(), x, y + 0.25D, z, from.getLocation().getYaw(), from.getLocation().getPitch()));
			waitTicks(25L);
		}
	}

	public static void waitTicks(long n){
		long t0 = System.currentTimeMillis();
		long t1;
		do
			t1 = System.currentTimeMillis();
		while(
				t1 - t0 < n);

	}

	public static boolean isInt(String str){
		try{
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

	public static boolean isDouble(String str){
		try{
			Double.parseDouble(str);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

	public static void createMenu(){
		ItemStack kits = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta kitsMeta = kits.getItemMeta();
		kitsMeta.setDisplayName(ChatColor.AQUA + "Kits");
		ArrayList<String> kitsLore = new ArrayList<String>();
		kitsLore.add(ChatColor.DARK_PURPLE + "Choose a kit to play!");
		kitsMeta.setLore(kitsLore);
		kits.setItemMeta(kitsMeta);

		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bookMeta = (BookMeta) book.getItemMeta();
		bookMeta.setAuthor("SlimeKits");
		bookMeta.setDisplayName(ChatColor.DARK_AQUA + "Info");
		book.setItemMeta(bookMeta);

		ItemStack rules = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta rulesMeta = (BookMeta) rules.getItemMeta();
		rulesMeta.setAuthor("SlimeKits");
		rulesMeta.setDisplayName(ChatColor.RED + "Rules");
		rules.setItemMeta(rulesMeta);

		ItemStack air = new ItemStack(Material.AIR);

		inv.setItem(0, kits);
		inv.setItem(1, book);
		inv.setItem(2, rules);
		inv.addItem(air);
		inv.addItem(air);
		inv.addItem(air);
		inv.addItem(air);
		inv.addItem(air);
		Main.inst();
		Debug.tryDebug("Kits menu created");
	}

	public static void createSelectMenu(){

		ItemStack archer = new ItemStack(Material.BOW);
		ItemMeta archerMeta = archer.getItemMeta();
		archerMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Archer");
		archer.setItemMeta(archerMeta);


		ItemStack tank = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta tankMeta = tank.getItemMeta();
		tankMeta.setDisplayName(ChatColor.AQUA + "Tank");
		tank.setItemMeta(tankMeta);

		ItemStack turtle = new ItemStack(Material.STONE_SWORD);
		ItemMeta turtleMeta = turtle.getItemMeta();
		turtleMeta.setDisplayName(ChatColor.DARK_AQUA + "Turtle");
		turtle.setItemMeta(turtleMeta);

		ItemStack grandpa = new ItemStack(Material.STICK);
		ItemMeta grandpaMeta = grandpa.getItemMeta();
		grandpaMeta.setDisplayName(ChatColor.DARK_GRAY + "Grandpa");
		grandpa.setItemMeta(grandpaMeta);

		ItemStack knight = new ItemStack(Material.IRON_SWORD);
		ItemMeta knightMeta = knight.getItemMeta();
		knightMeta.setDisplayName(ChatColor.DARK_RED + "Knight");
		ArrayList<String> knightLore = new ArrayList<String>();
		knightLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.GRAY + "Iron");
		knightMeta.setLore(knightLore);
		knight.setItemMeta(knightMeta);

		ItemStack creeper = new ItemStack(Material.SULPHUR);
		ItemMeta creeperMeta = creeper.getItemMeta();
		creeperMeta.setDisplayName(ChatColor.GREEN + "Creeper");
		ArrayList<String> creeperLore = new ArrayList<String>();
		creeperLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.GRAY + "Iron");
		creeperMeta.setLore(creeperLore);
		creeper.setItemMeta(creeperMeta);

		ItemStack ninja = new ItemStack(Material.ENDER_PEARL);
		ItemMeta ninjaMeta = ninja.getItemMeta();
		ninjaMeta.setDisplayName(ChatColor.GOLD + "Ninja");
		ArrayList<String> ninjaLore = new ArrayList<String>();
		ninjaLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.GOLD + "Gold");
		ninjaMeta.setLore(ninjaLore);
		ninja.setItemMeta(ninjaMeta);

		ItemStack wither = new ItemStack(Material.WOOD_HOE);
		ItemMeta witherMeta = wither.getItemMeta();
		witherMeta.setDisplayName(ChatColor.BLACK + "Wither");
		ArrayList<String> witherLore = new ArrayList<String>();
		witherLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.GOLD + "Gold");
		witherMeta.setLore(witherLore);
		wither.setItemMeta(witherMeta);

		ItemStack stomper = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta stomperMeta = (LeatherArmorMeta) stomper.getItemMeta();
		stomperMeta.setDisplayName(ChatColor.GRAY + "Stomper");
		stomperMeta.setColor(Color.GRAY);
		ArrayList<String> stomperLore = new ArrayList<String>();
		stomperLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.GOLD + "Gold");
		stomperMeta.setLore(stomperLore);
		stomper.setItemMeta(stomperMeta);

		ItemStack angel = new ItemStack(Material.NETHER_STAR);
		ItemMeta angelMeta = angel.getItemMeta();
		angelMeta.setDisplayName(ChatColor.YELLOW + "Angel");
		ArrayList<String> angelLore = new ArrayList<String>();
		angelLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.GOLD + "Gold");
		angelMeta.setLore(angelLore);
		angel.setItemMeta(angelMeta);

		ItemStack soldier = new ItemStack(Material.SLIME_BALL);
		ItemMeta soldierMeta = soldier.getItemMeta();
		soldierMeta.setDisplayName(ChatColor.BLUE + "Soldier");
		ArrayList<String> soldierLore = new ArrayList<String>();
		soldierLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.GOLD + "Gold");
		soldierMeta.setLore(soldierLore);
		soldier.setItemMeta(soldierMeta);
		
		ItemStack jumper = new ItemStack(Material.SNOW_BLOCK);
		ItemMeta jumperMeta = jumper.getItemMeta();
		jumperMeta.setDisplayName(ChatColor.GREEN + "Jumper");
		ArrayList<String> jumperLore = new ArrayList<String>();
		jumperLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.GOLD + "Gold");
		jumperMeta.setLore(jumperLore);
		jumper.setItemMeta(jumperMeta);

		ItemStack spider = new ItemStack(Material.SPIDER_EYE);
		ItemMeta spiderMeta = spider.getItemMeta();
		spiderMeta.setDisplayName(ChatColor.DARK_GREEN + "Spider");
		ArrayList<String> spiderLore = new ArrayList<String>();
		spiderLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.AQUA + "Diamond");
		spiderMeta.setLore(spiderLore);
		spider.setItemMeta(spiderMeta);

		ItemStack trickster = new ItemStack(Material.REDSTONE_TORCH_ON);
		ItemMeta tricksterMeta = trickster.getItemMeta();
		tricksterMeta.setDisplayName(ChatColor.DARK_GRAY + "Trickster");
		ArrayList<String> tricksterLore = new ArrayList<String>();
		tricksterLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.AQUA + "Diamond");
		tricksterMeta.setLore(tricksterLore);
		trickster.setItemMeta(tricksterMeta);

		ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
		ItemMeta blazeMeta = blaze.getItemMeta();
		blazeMeta.setDisplayName(ChatColor.YELLOW + "Blaze");
		ArrayList<String> blazeLore = new ArrayList<String>();
		blazeLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.AQUA + "Diamond");
		blazeMeta.setLore(blazeLore);
		blaze.setItemMeta(blazeMeta);

		ItemStack dwarf = new ItemStack(Material.IRON_AXE);
		ItemMeta dwarfMeta = dwarf.getItemMeta();
		dwarfMeta.setDisplayName(ChatColor.DARK_PURPLE + "Dwarf");
		ArrayList<String> dwarfLore = new ArrayList<String>();
		dwarfLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.AQUA + "Diamond");
		dwarfMeta.setLore(dwarfLore);
		dwarf.setItemMeta(dwarfMeta);

		ItemStack fisherman = new ItemStack(Material.FISHING_ROD);
		ItemMeta fishermanMeta = fisherman.getItemMeta();
		fishermanMeta.setDisplayName(ChatColor.RED + "Fisherman");
		ArrayList<String> fishermanLore = new ArrayList<String>();
		fishermanLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.AQUA + "Diamond");
		fishermanMeta.setLore(fishermanLore);
		fisherman.setItemMeta(fishermanMeta);

		ItemStack cannon = new ItemStack(Material.TNT);
		ItemMeta cannonMeta = cannon.getItemMeta();
		cannonMeta.setDisplayName(ChatColor.RED + "Ca" + ChatColor.WHITE + "nn" + ChatColor.RED + "on");
		ArrayList<String> cannonLore = new ArrayList<String>();
		cannonLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.AQUA + "Diamond");
		cannonMeta.setLore(cannonLore);
		cannon.setItemMeta(cannonMeta);

		ItemStack poseidon = new ItemStack(Material.WATER);
		ItemMeta poseidonMeta = poseidon.getItemMeta();
		poseidonMeta.setDisplayName(ChatColor.BLUE + "Poseidon");
		ArrayList<String> poseidonLore = new ArrayList<String>();
		poseidonLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.AQUA + "Diamond");
		poseidonMeta.setLore(poseidonLore);
		poseidon.setItemMeta(poseidonMeta);

		ItemStack thor = new ItemStack(Material.WOOD_AXE);
		ItemMeta thorMeta = thor.getItemMeta();
		thorMeta.setDisplayName(ChatColor.YELLOW + "Thor");
		ArrayList<String> thorLore = new ArrayList<String>();
		thorLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.AQUA + "Diamond");
		thorMeta.setLore(thorLore);
		thor.setItemMeta(thorMeta);
		
		ItemStack wizard = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta wizardMeta = (LeatherArmorMeta) wizard.getItemMeta();
		wizardMeta.setDisplayName(ChatColor.BLUE + "Wizard");
		wizardMeta.setColor(Color.BLUE);
		ArrayList<String> wizardLore = new ArrayList<String>();
		wizardLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.AQUA + "Diamond");
		wizardMeta.setLore(wizardLore);
		wizard.setItemMeta(wizardMeta);
		
		ItemStack flame = new ItemStack(Material.FIRE);
		ItemMeta flameMeta = flame.getItemMeta();
		flameMeta.setDisplayName(ChatColor.RED + "Flamethrower");
		List<String> flameLore = new ArrayList<String>();
		flameLore.add(ChatColor.YELLOW + "Donator Kit: " + ChatColor.AQUA + "Diamond");
		flameMeta.setLore(flameLore);
		flame.setItemMeta(flameMeta);

		ItemStack back = new ItemStack(Material.CHEST);
		ItemMeta backMeta = back.getItemMeta();
		backMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Back");
		ArrayList<String> backLore = new ArrayList<String>();
		backLore.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Go back a menu!");
		backMeta.setLore(backLore);
		back.setItemMeta(backMeta);

		if(Main.inst().getConfig().getBoolean("kits.archer.enabled")){
			select.setItem(select.firstEmpty(), archer);
		}
		if(Main.inst().getConfig().getBoolean("kits.tank.enabled")){
			select.setItem(select.firstEmpty(), tank);
		}
		if(Main.inst().getConfig().getBoolean("kits.turtle.enabled")){
			select.setItem(select.firstEmpty(), turtle);
		}
		if(Main.inst().getConfig().getBoolean("kits.grandpa.enabled")){
			select.setItem(select.firstEmpty(), grandpa);
		}
		if(Main.inst().getConfig().getBoolean("kits.knight.enabled")){
			select.setItem(select.firstEmpty(), knight);
		}
		if(Main.inst().getConfig().getBoolean("kits.creeper.enabled")){
			select.setItem(select.firstEmpty(), creeper);
		}
		if(Main.inst().getConfig().getBoolean("kits.ninja.enabled")){
			select.setItem(select.firstEmpty(), ninja);
		}
		if(Main.inst().getConfig().getBoolean("kits.wither.enabled")){
			select.setItem(select.firstEmpty(), wither);
		}
		if(Main.inst().getConfig().getBoolean("kits.stomper.enabled")){
			select.setItem(select.firstEmpty(), stomper);
		}
		if(Main.inst().getConfig().getBoolean("kits.angel.enabled")){
			select.setItem(select.firstEmpty(), angel);
		}
		if(Main.inst().getConfig().getBoolean("kits.soldier.enabled")){
			select.setItem(select.firstEmpty(), soldier);
		}
		if(Main.inst().getConfig().getBoolean("kits.jumper.enabled")){
			select.setItem(select.firstEmpty(), jumper);
		}
		if(Main.inst().getConfig().getBoolean("kits.spider.enabled")){
			select.setItem(select.firstEmpty(), spider);
		}
		if(Main.inst().getConfig().getBoolean("kits.trickster.enabled")){
			select.setItem(select.firstEmpty(), trickster);
		}
		if(Main.inst().getConfig().getBoolean("kits.blaze.enabled")){
			select.setItem(select.firstEmpty(), blaze);
		}
		if(Main.inst().getConfig().getBoolean("kits.dwarf.enabled")){
			select.setItem(select.firstEmpty(), dwarf);
		}
		if(Main.inst().getConfig().getBoolean("kits.fisherman.enabled")){
			select.setItem(select.firstEmpty(), fisherman);
		}
		if(Main.inst().getConfig().getBoolean("kits.cannon.enabled")){
			select.setItem(select.firstEmpty(), cannon);
		}
		if(Main.inst().getConfig().getBoolean("kits.poseidon.enabled")){
			select.setItem(select.firstEmpty(), poseidon);
		}
		if(Main.inst().getConfig().getBoolean("kits.thor.enabled")){
			select.setItem(select.firstEmpty(), thor);
		}
		if(Main.inst().getConfig().getBoolean("kits.wizard.enabled")){
			select.setItem(select.firstEmpty(), wizard);
		}
		if(Main.inst().getConfig().getBoolean("kits.flamethrower.enabled")){
			select.setItem(select.firstEmpty(), flame);
		}
		select.setItem(26, back);
		Debug.tryDebug("Select menu created");
	}

	public static void openMenu(Player player){
		player.openInventory(inv);
		Debug.tryDebug(player.getName() + " opened Kits Menu");
	}

	public static void openSelectMenu(Player player){
		player.openInventory(select);
		Debug.tryDebug(player.getName() + " opened Kits Select Menu");
	}

	public static void giveInfo(Player player){
		PlayerInventory inventory = player.getInventory();
		// INFO
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bookMeta = (BookMeta) book.getItemMeta();
		bookMeta.setAuthor("SlimeKits");
		bookMeta.setTitle(ChatColor.DARK_AQUA + "Info");
		ArrayList<String> bookPage = new ArrayList<String>(); // Pages
		bookPage.add("Kits Info:\n" + ChatColor.DARK_GREEN + "Contents\n" + ChatColor.GREEN + "------------\n" + ChatColor.LIGHT_PURPLE + "Archer - 1\n" + ChatColor.AQUA + "Tank - 2\n" + ChatColor.DARK_RED + "Knight - 3\n" + ChatColor.GOLD + "Ninja - 4\n" + ChatColor.DARK_GREEN + "Spider - 5\n" + ChatColor.DARK_GRAY + "Trickster - 6\n" + ChatColor.GOLD + "Blaze - 7\n" + ChatColor.DARK_AQUA + "Turtle - 8\n" + ChatColor.DARK_PURPLE + "Dwarf - 9\n" + ChatColor.RED + "Fisherman - 10"); // Page 1
		bookPage.add(ChatColor.LIGHT_PURPLE + "Archer\n------------\nStart with a bow enchanted with:\nUnreaking 10\nInfinity 1\nSharpness 1\nPower 2\n" + "\nYou also have Chainmail armour.");
		bookPage.add(ChatColor.AQUA + "Tank\n------------\nStart with a diamond sword enchanted with Sharpness 1 and Iron Armour.\nYou also get Resistance 1.");
		bookPage.add(ChatColor.DARK_RED + "Knight\n------------\nStart with an iron sword enchanted with Unbreaking 10 and diamond armour.");
		bookPage.add(ChatColor.GOLD + "Ninja\n------------\nStart with a gold sword enchanted with Unbreaking 10 and Sharpness 3. You also get 8 enderpearls and gold boots enchanted with Protection 5, Unbreaking 10, and Feather Falling 10. You also get Swiftness 2.");
		bookPage.add(ChatColor.DARK_GREEN + "Spider\n------------\nStart with a gold sword enchanted with Unbreaking 10 and a spider eye.\nHitting a player with your spider eye gives them poison.\nStart with a Leather cap, Chainmail chest, Gold leggings and Leather Boots.");
		bookPage.add(ChatColor.DARK_GRAY + "Trickster\n------------\nStart with a gold sword enchanted with Unbreaking 10 and a redstone torch.\nHitting a player with your redstone torch makes them turn around.\nYou also have iron armour.");
		bookPage.add(ChatColor.GOLD + "Blaze\n------------\nStart with an iron sword enchanted with Unbreaking 10 and a blaze rod.\nHitting a player with your blaze rod will ignite them!\nYou also have leather armour.");
		bookPage.add(ChatColor.DARK_AQUA + "Turtle\n------------\nAs turtle you start with two swords. Your iron sword and a stone defender.\nShifting will give you Resistance and shifting while blocking with your defender gives you Resistance 4!");
		bookPage.add(ChatColor.DARK_PURPLE + "Dwarf\n------------\nStart with a Sharpness 2, Knockback 1, Iron Axe.\n Your armour is a Diamond helmet, Iron chestplate, Leather leggings and Gold boots.");
		bookPage.add(ChatColor.RED + "Fisherman\n------------\nYou start with a Knockback 1 diamond sword and a fishing rod.\nUse your fishing rod to reel opponents in!\nYour armour is leather.");
		bookMeta.setPages(bookPage);
		book.setItemMeta(bookMeta);

		inventory.addItem(book);		
	}

	public static void giveRules(Player player){
		PlayerInventory inventory = player.getInventory();
		// RULES
		ItemStack rules = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta rulesMeta = (BookMeta) rules.getItemMeta();
		rulesMeta.setAuthor("SlimeKits");
		rulesMeta.setTitle(ChatColor.RED + "Rules");
		ArrayList<String> rulesPage = new ArrayList<String>();
		rulesPage.add(ChatColor.LIGHT_PURPLE + "Kits Rules:\n1. No hacks.\n2. No bug abuse. If you are caught, a ban may be dealt.\n3. Flying is allowed. However it would be smart to remember that if you get hit or deal a hit, you will lose flight.");
		rulesMeta.setPages(rulesPage);
		rules.setItemMeta(rulesMeta);

		inventory.addItem(rules);
	}

	public static void clearKitMap(Player player){
		Main.playArcher.remove(player.getName());
		Main.playTank.remove(player.getName());
		Main.playKnight.remove(player.getName());
		Main.playNinja.remove(player.getName());
		Main.playSpider.remove(player.getName());
		Main.playReaper.remove(player.getName());
		Main.playBlaze.remove(player.getName());
		Main.playDwarf.remove(player.getName());
		Main.playFisher.remove(player.getName());
		Main.playTurtle.remove(player.getName());
		Main.playCreeper.remove(player.getName());
		Main.playWither.remove(player.getName());
		Main.playStomper.remove(player.getName());
		Main.playCannon.remove(player.getName());
		Main.playPoseidon.remove(player.getName());
		Main.playThor.remove(player.getName());
		Main.playGrandpa.remove(player.getName());
		Main.playAngel.remove(player.getName());
		Main.playSoldier.remove(player.getName());
		Main.playJumper.remove(player.getName());
		Main.playWizard.remove(player.getName());
		Main.playFlamethrower.remove(player.getName());
	}

	public static void reSoup(Player player){
		PlayerInventory inventory = player.getInventory();
		ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
		inventory.addItem(soup);
	}

	public static void banDrops(){
		// Weapons
		Main.items.add(Material.DIAMOND_SWORD);
		Main.items.add(Material.IRON_SWORD);
		Main.items.add(Material.STONE_SWORD);
		Main.items.add(Material.GOLD_SWORD);
		Main.items.add(Material.WOOD_SWORD);
		Main.items.add(Material.BOW);
		Main.items.add(Material.IRON_AXE);

		// Special Weapons
		Main.items.add(Material.WOOD_AXE);
		Main.items.add(Material.DIAMOND_HOE);
		Main.items.add(Material.WOOD_HOE);
		Main.items.add(Material.BLAZE_ROD);
		Main.items.add(Material.SPIDER_EYE);
		Main.items.add(Material.SULPHUR);
		Main.items.add(Material.TNT);
		Main.items.add(Material.ENDER_PEARL);
		Main.items.add(Material.REDSTONE_TORCH_ON);
		Main.items.add(Material.STICK);
		Main.items.add(Material.SLIME_BALL);
		Main.items.add(Material.DIAMOND_BOOTS);
		Main.items.add(Material.FLINT_AND_STEEL);
		
		// Other
		Main.items.add(Material.COAL);

		// Killstreaks
		Main.items.add(Material.POTION);
		Main.items.add(Material.ANVIL);

		// Soup
		Main.items.add(Material.MUSHROOM_SOUP);
		
		Debug.tryDebug("Items have been added to ban drop list");
	}

	public static void armour(){
		// Diamond
		Main.armour.add(Material.DIAMOND_HELMET);
		Main.armour.add(Material.DIAMOND_CHESTPLATE);
		Main.armour.add(Material.DIAMOND_LEGGINGS);
		Main.armour.add(Material.DIAMOND_BOOTS);

		// Iron
		Main.armour.add(Material.IRON_HELMET);
		Main.armour.add(Material.IRON_CHESTPLATE);
		Main.armour.add(Material.IRON_LEGGINGS);
		Main.armour.add(Material.IRON_BOOTS);

		// Gold
		Main.armour.add(Material.GOLD_HELMET);
		Main.armour.add(Material.GOLD_CHESTPLATE);
		Main.armour.add(Material.GOLD_LEGGINGS);
		Main.armour.add(Material.GOLD_BOOTS);

		// Chain
		Main.armour.add(Material.CHAINMAIL_HELMET);
		Main.armour.add(Material.CHAINMAIL_CHESTPLATE);
		Main.armour.add(Material.CHAINMAIL_LEGGINGS);
		Main.armour.add(Material.CHAINMAIL_BOOTS);

		// Leather
		Main.armour.add(Material.LEATHER_HELMET);
		Main.armour.add(Material.LEATHER_CHESTPLATE);
		Main.armour.add(Material.LEATHER_LEGGINGS);
		Main.armour.add(Material.LEATHER_BOOTS);

		Debug.tryDebug("Armour added to ArrayList");
	}

	public static void refill(Player player) {
		String p = player.getName();
		if(Main.playArcher.containsKey(p)){
			Archer.selArcher(player);
		}else if(Main.playTank.containsKey(p)){
			Tank.selTank(player);
		}else if(Main.playKnight.containsKey(p)){
			Knight.selKnight(player);
		}else if(Main.playNinja.containsKey(p)){
			Ninja.selNinja(player);
		}else if(Main.playSpider.containsKey(p)){
			Spider.selSpider(player);
		}else if(Main.playReaper.containsKey(p)){
			Trickster.selTrickster(player);
		}else if(Main.playBlaze.containsKey(p)){
			Blaze.selBlaze(player);
		}else if(Main.playDwarf.containsKey(p)){
			Dwarf.selDwarf(player);
		}else if(Main.playFisher.containsKey(p)){
			Fisherman.selFisherman(player);
		}else if(Main.playTurtle.containsKey(p)){
			Turtle.selTurtle(player);
		}else if(Main.playCannon.containsKey(p)){
			Cannon.selCannon(player);
		}else if(Main.playCreeper.containsKey(p)){
			Creeper.selCreeper(player);
		}else if(Main.playPoseidon.containsKey(p)){
			Poseidon.selPoseidon(player);
		}else if(Main.playWither.containsKey(p)){
			Wither.selWither(player);
		}else if(Main.playStomper.containsKey(p)){
			StomperKit.selStomper(player);
		}else{
			player.sendMessage(ChatColor.RED + p + ", you aren't a kit.");			
		}
	}
}
