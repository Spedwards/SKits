package com.theaetherserver.kits.events;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.theaetherserver.kits.Main;

public class InventoryMethods {
	@SuppressWarnings("unused")
	private Main plugin;
	public InventoryMethods(Main plugin){
		this.plugin = plugin;
	}
	
    public static int remove(Inventory inventory, Material mat, int amount, short damage)
    {
        ItemStack[] contents = inventory.getContents();
        int removed = 0;
        for (int i = 0; i < contents.length; i++) {
            ItemStack item = contents[i];
 
            if (item == null || !item.getType().equals(mat)) {
                continue;
            }
 
            if (damage != (short) -1 && item.getDurability() != damage) {
                continue;
            }
 
            int remove = item.getAmount() - amount - removed;
 
            if (removed > 0) {
                removed = 0;
            }
 
            if (remove <= 0) {
                removed += Math.abs(remove);
                contents[i] = null;
            } else {
                item.setAmount(remove);
            }
        }
        return removed;
    }
 
 
    /**
    * Checks weather the inventory contains a item or not.
    *
    * @param inventory The inventory to check..
    * @param mat      The material to check .
    * @param amount    The amount to check.
    * @param damage    The data value or -1 if this does not matter.
    * @return The amount of items the player has not. If this return 0 then the check was successfull.
    */
    public static int contains(Inventory inventory, Material mat, int amount, short damage)
    {
        ItemStack[] contents = inventory.getContents();
        int searchAmount = 0;
        for (ItemStack item : contents) {
 
            if (item == null || !item.getType().equals(mat)) {
                continue;
            }
 
            if (damage != -1 && item.getDurability() == damage) {
                continue;
            }
 
            searchAmount += item.getAmount();
        }
        return searchAmount - amount;
    }
}
