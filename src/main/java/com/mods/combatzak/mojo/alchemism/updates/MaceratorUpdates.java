package com.mods.combatzak.mojo.alchemism.updates;

import net.minecraft.item.ItemStack;
import ganymedes01.aobd.lib.CompatType;
import ganymedes01.aobd.ore.Ore;
import ganymedes01.aobd.recipes.RecipesModule;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.core.Ic2Items;
import thaumcraft.api.ItemApi;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.ic2.macerator.AddMaceratorAction;
import com.mods.combatzak.mojo.alchemism.actions.te4.pulverizer.ReplacePulverizerAction;

/**
 * Manages updates to the IC2 macerator
 * 
 * @author CombatZAK
 *
 */
public class MaceratorUpdates {
	/**
	 * Stores Macerator recipe updates
	 */
	private GroupAction maceratorActions = new GroupAction();
	
	/**
	 * Singleton instance used to register updates
	 */
	private static MaceratorUpdates instance = new MaceratorUpdates();
	
	/**
	 * Gets the MaceratorUpdates singleton
	 * 
	 * @return singleton instance
	 */
	public static MaceratorUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Registers the updates to the IC2 macerator
	 */
	public void register() {
		if (!this.maceratorActions.getIsApplied())
			this.maceratorActions.apply();
	}
	
	/**
	 * Private constructor initializes singleton
	 */
	private MaceratorUpdates() {
		this.maceratorActions.add(new AddMaceratorAction(new RecipeInputItemStack(ItemApi.getItem("itemNugget", 16)), resizeStack(Ic2Items.purifiedCrushedIronOre, 3)));
		this.maceratorActions.add(new AddMaceratorAction(new RecipeInputItemStack(ItemApi.getItem("itemNugget", 17)), resizeStack(Ic2Items.purifiedCrushedCopperOre, 3)));
		this.maceratorActions.add(new AddMaceratorAction(new RecipeInputItemStack(ItemApi.getItem("itemNugget", 18)), resizeStack(Ic2Items.purifiedCrushedTinOre, 3)));
		this.maceratorActions.add(new AddMaceratorAction(new RecipeInputItemStack(ItemApi.getItem("itemNugget", 19)), resizeStack(Ic2Items.purifiedCrushedSilverOre, 3)));
		this.maceratorActions.add(new AddMaceratorAction(new RecipeInputItemStack(ItemApi.getItem("itemNugget", 20)), resizeStack(Ic2Items.purifiedCrushedLeadOre, 3)));
		this.maceratorActions.add(new AddMaceratorAction(new RecipeInputItemStack(ItemApi.getItem("itemNugget", 31)), resizeStack(Ic2Items.purifiedCrushedGoldOre, 3)));
		
		for (Ore ore : Ore.ores) {
			if (ore.isCompatEnabled(CompatType.THAUMCRAFT)) {
				ItemStack inputStack = RecipesModule.getOreStack("cluster", ore);
				if (inputStack.getItem() == ItemApi.getItem("itemNugget", 16).getItem()) continue; //skip this if it's already been added.
				this.maceratorActions.add(new AddMaceratorAction(new RecipeInputItemStack(inputStack), RecipesModule.getOreStack("crushedPurified", ore, 3)));
			}
		}
	}
	
	/**
	 * Gets an item stack with the specified item and new amount
	 * 
	 * @param target itemSTack to copy
	 * @param amount new stack size
	 * @return ItemStack with target's item and amount stack size
	 */
	private static ItemStack resizeStack(ItemStack target, int amount) {
		if (target == null) return null; //handle null
		if (amount > target.getMaxStackSize()) amount = target.getMaxStackSize(); //bound amount
		if (target.stackSize == amount) return target; //check if desired amount is equal to current
		
		ItemStack result = target.copy(); //clone the stack
		result.stackSize = amount;
		return result;
	}
}
