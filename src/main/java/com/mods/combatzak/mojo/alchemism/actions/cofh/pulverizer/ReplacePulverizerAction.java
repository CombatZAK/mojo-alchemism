package com.mods.combatzak.mojo.alchemism.actions.cofh.pulverizer;

import cofh.thermalexpansion.util.managers.machine.PulverizerManager;
import net.minecraft.item.ItemStack;

/**
 * Adds or replaces a Pulverizer recipe based on its input
 *
 * Created by CombatZAK on 4/20/2018.
 */
public class ReplacePulverizerAction extends PulverizerAction {
    public ReplacePulverizerAction(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance) {
        super(energy, input, primaryOutput, secondaryOutput, secondaryChance);
    }

    public ReplacePulverizerAction() {
        this(0, null, null, null, 0);
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("ReplacePulverizerAction cannot be applied without input");
        if (primaryOutput == null) throw new IllegalStateException("ReplacePulverizerAction cannot be applied without primaryOutput");
        if (energy <= 0) throw new IllegalStateException("ReplacePulverizerAction must have energy cost");
        if (secondaryOutput != null && secondaryChance <= 0) throw new IllegalStateException("ReplacePulverizerAction with secondaryOutput must have secondaryChance");

        PulverizerManager.removeRecipe(input); //assume recipe is successfully removed if it existed
        if (secondaryOutput == null) PulverizerManager.addRecipe(energy, input, primaryOutput);
        else PulverizerManager.addRecipe(energy, input, primaryOutput, secondaryOutput, secondaryChance);

        setApplied();
        return true;
    }
}
