package com.mods.combatzak.mojo.alchemism.actions.renaming;

import net.minecraft.item.ItemStack;

public class RenameItemAction extends RenameAction {
	/**
	 * Item to be renamed
	 */
	private ItemStack targetItem;
	
	/**
	 * Gets the item to be renamed
	 * 
	 * @return target of rename
	 */
	public ItemStack getTargetItem() {
		return this.targetItem;
	}
	
	/**
	 * Sets the item to be renamed
	 * 
	 * @param value target of rename
	 */
	public void setTargetItem(ItemStack value) {
		this.targetItem = value;
	}
	
	/**
	 * Self-referentially sets item to be renamed
	 * 
	 * @param value target of rename
	 * @return self-reference
	 */
	public RenameItemAction withTargetItem(ItemStack value) {
		this.setTargetItem(value);
		return this;
	}
	
	/**
	 * Creates a new RenameItemAction instance
	 * 
	 * @param targetItem target of rename
	 * @param newDisplayName updated display name
	 */
	public RenameItemAction(ItemStack targetItem, String newDisplayName) {
		super(newDisplayName);
		this.targetItem = targetItem;
	}
	
	/**
	 * Default constructor
	 */
	public RenameItemAction() {
		this(null, null);
	}
	
	/**
	 * Gets the target item's display name field
	 */
	@Override
	public String getUnlocalizedNameField() {
		if (this.targetItem == null) return null; //perform a null test

		String label = this.targetItem.getUnlocalizedName() + ".name"; //get the unlocalized name for the item stack
		if (label.endsWith(".name.name")) //check for double name suffix
			label = label.substring(0, label.length() - 5); //cut the last .name out
		
		return label;
	}
}