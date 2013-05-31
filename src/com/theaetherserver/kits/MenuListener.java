package com.theaetherserver.kits;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuListener implements Listener{
	 
    private Main plugin;
    private static MenuListener instance;
    
    public static MenuListener inst(){
    	return instance;
    }
    
    public MenuListener (Main plugin) {
    	this.plugin = plugin;
    }
 
    public void setMenuOptions(Inventory inv,int slot,ItemStack it,String title,String... lore){
    ItemStack option = setItemNameAndLore(it,title,lore);
    inv.setItem(slot,option);
    }
 
    private ItemStack setItemNameAndLore(ItemStack item, String name, String[] lore) {
    ItemMeta im = item.getItemMeta();
    im.setDisplayName(name);
    im.setLore(Arrays.asList(lore));
    item.setItemMeta(im);
    return item;
    }
 
 
    @EventHandler
    void onClickEvent(InventoryClickEvent e) {

    	if(e.getWhoClicked() instanceof Player){
    		Player player = (Player)e.getWhoClicked();
    		ItemStack it = e.getCurrentItem();
 
    		if(it != null && it.getItemMeta() != null && it.getItemMeta().getDisplayName() != null){


    			if(e.getInventory().getType() == InventoryType.CHEST){

    				if(e.getInventory().getTitle().equalsIgnoreCase(ChatColor.BLUE + "SlimeKits") || e.getInventory().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Select a Kit")){
    					closeInventory(player);
    					Handler BH = new Handler(plugin);
    					BH.onOptionClick(player,it.getItemMeta().getDisplayName());
    					e.setCancelled(true);
    					return;
    				}
    			}else{
    				if(Main.armour.contains(it.getType())){
    					System.out.println("Clicked item is in Armour ArrayList");
    					e.setCancelled(true);
    					player.sendMessage(ChatColor.RED + "You can't move this");
    				}
    			}
    		}
    	}
    }
 
    public void closeInventory(final Player player){
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
   
              @Override
              public void run() {
         
              player.closeInventory();
           
              }
              },1L);
    }
 
 
}