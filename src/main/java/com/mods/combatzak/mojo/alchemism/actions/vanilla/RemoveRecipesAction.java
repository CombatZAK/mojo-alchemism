package com.mods.combatzak.mojo.alchemism.actions.vanilla;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import com.mods.combatzak.mojo.alchemism.helpers.VanillaRecipeHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Removes all crafting recipes that generate a particular output or resource key
 *
 * Created by CombatZAK on 4/21/2018.
 */
public class RemoveRecipesAction extends CraftingAction {
    private String resourceLocationGroup = null;

    public RemoveRecipesAction(ItemStack output) {
        super(null, output);
    }

    public RemoveRecipesAction(ItemStack output, String resourceLocationGroup) {
        super(null, output);
        this.setResourceLocation(resourceLocationGroup);
    }

    public RemoveRecipesAction()
    {
        this((ItemStack)null);
    }

    public String getResourceLocationGroup() {
        return resourceLocationGroup;
    }

    public void setResourceLocation(String resourceLocationGroup) {
        this.resourceLocationGroup = resourceLocationGroup;
    }

    @Override
    public boolean apply() {
        if (resourceLocationGroup != null) return removeByResourceLocationGroup();
        if (getOutput() == null) throw new IllegalStateException("Remove recipes action must have output initialized");
        ForgeRegistry<IRecipe> recipeList = VanillaRecipeHelper.getCraftingRecipes();
        List<Entry<ResourceLocation, IRecipe>> recipeKeys = new ArrayList<>();

        for (Entry<ResourceLocation, IRecipe> testRecipe : recipeList.getEntries()) {
            if (ItemStackHelper.isDirectMatch(output, testRecipe.getValue().getRecipeOutput())) {
                recipeKeys.add(testRecipe);
            }
        }
        for (Entry<ResourceLocation, IRecipe> recipeEntry : recipeKeys) {
            recipeList.remove(recipeEntry.getKey());
        }

        setApplied();
        return true;
    }

    private boolean removeByResourceLocationGroup() {
        ForgeRegistry<IRecipe> recipeList = VanillaRecipeHelper.getCraftingRecipes();
        List<ResourceLocation> matches = new ArrayList<>();

        for (Entry<ResourceLocation, IRecipe> entry : recipeList.getEntries()) {
            if (entry.getKey().getResourceDomain().equals(resourceLocationGroup) && ItemStackHelper.isDirectMatch(output, entry.getValue().getRecipeOutput())) {
                matches.add(entry.getKey());
            }
        }

        for (ResourceLocation match : matches) {
            recipeList.remove(match);
        }

        setApplied();
        return true;
    }
}