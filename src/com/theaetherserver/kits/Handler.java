package com.theaetherserver.kits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.theaetherserver.kits.selected.*;

public class Handler{
	 
	private Main plugin; 
 
    public void openInvMenu(final Player player){
        Inventory inv = Bukkit.createInventory(player, 27, "menu_name");
        setOptions(inv,player);
        player.openInventory(inv);
    }
    
    public Handler (Main plugin) {
    	this.plugin = plugin;
    }
    
    public void onOptionClick(final Player player, String name){
 
        if(name.equalsIgnoreCase(ChatColor.AQUA + "kits")){
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
       
                  @Override
                  public void run() {
             
                      Methods.openSelectMenu(player);
             
                  }
                },1L);
                return;
        }else if(name.equalsIgnoreCase(ChatColor.DARK_AQUA + "Info")){
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                
                @Override
                public void run() {
           
                    Methods.giveInfo(player);
           
                }
              },1L);
              return;
        }else if(name.equalsIgnoreCase(ChatColor.RED + "Rules")){
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                
                @Override
                public void run() {
           
                    Methods.giveRules(player);
           
                }
              },1L);
              return;
        }else if(name.equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Archer")){
        	Archer.selArcher(player);
        }else if(name.equalsIgnoreCase(ChatColor.AQUA + "Tank")){
        	Tank.selTank(player);
        }else if(name.equalsIgnoreCase(ChatColor.DARK_RED + "Knight")){
        	Knight.selKnight(player);
        }else if(name.equalsIgnoreCase(ChatColor.GOLD + "Ninja")){
        	Ninja.selNinja(player);
        }else if(name.equalsIgnoreCase(ChatColor.DARK_GREEN + "Spider")){
        	Spider.selSpider(player);
        }else if(name.equalsIgnoreCase(ChatColor.DARK_GRAY + "Trickster")){
        	Trickster.selTrickster(player);
        }else if(name.equalsIgnoreCase(ChatColor.YELLOW + "Blaze")){
        	Blaze.selBlaze(player);
        }else if(name.equalsIgnoreCase(ChatColor.RED + "Fisherman")){
        	Fisherman.selFisherman(player);
        }else if(name.equalsIgnoreCase(ChatColor.DARK_PURPLE + "Dwarf")){
        	Dwarf.selDwarf(player);
        }else if(name.equalsIgnoreCase(ChatColor.DARK_AQUA + "Turtle")){
        	Turtle.selTurtle(player);
        }else if(name.equalsIgnoreCase(ChatColor.GREEN + "Creeper")){
        	Creeper.selCreeper(player);
        }else if(name.equalsIgnoreCase(ChatColor.BLACK + "Wither")){
        	Wither.selWither(player);
        }else if(name.equalsIgnoreCase(ChatColor.GRAY + "Stomper")){
        	StomperKit.selStomper(player);
        }else if(name.equalsIgnoreCase(ChatColor.RED + "Ca" + ChatColor.WHITE + "nn" + ChatColor.RED + "on")){
        	Cannon.selCannon(player);
        }else if(name.equalsIgnoreCase(ChatColor.BLUE + "Poseidon")){
        	Poseidon.selPoseidon(player);
        }else if(name.equalsIgnoreCase(ChatColor.YELLOW + "Thor")){
        	Thor.selThor(player);
        }else if(name.equalsIgnoreCase(ChatColor.DARK_GRAY + "Grandpa")){
        	Grandpa.selGrandpa(player);
        }else if(name.equalsIgnoreCase(ChatColor.YELLOW + "Angel")){
        	Angel.selAngel(player);
        }else if(name.equalsIgnoreCase(ChatColor.BLUE + "Soldier")){
        	Soldier.selSoldier(player);
        }else if(name.equalsIgnoreCase(ChatColor.GREEN + "Jumper")){
        	Jumper.selJumper(player);
        }else if(name.equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Back")){
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                
                @Override
                public void run() {
           
                    Methods.openMenu(player);
           
                }
              },1L);
              return;
        }
 
    return;
    } 
 
 
 
    public void setOptions(Inventory inv, Player player){
    MenuListener.inst().setMenuOptions(inv,0, new ItemStack(Material.NETHER_STAR, 1),"Back","Go to the previous menu.");
    }
}
