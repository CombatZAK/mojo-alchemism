package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.block.BlockOre;
import cofh.thermalfoundation.init.TFBlocks;
import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.vanilla.ReplaceFurnaceOutputAction;
import erogenousbeef.bigreactors.init.BrItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * Manages the updates to furnace recipes
 *
 * Created by CombatZAK on 4/30/2018.
 */
public class FurnaceUpdateManager extends UpdateManager {
    private static FurnaceUpdateManager ourInstance = new FurnaceUpdateManager();

    public static FurnaceUpdateManager getInstance() {
        return ourInstance;
    }

    private FurnaceUpdateManager() {
        //INGOTS
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotCopper, "ingotCopper"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotTin, "ingotTin"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotBronze, "ingotBronze"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotLead, "ingotLead"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotSilver, "ingotSilver"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotAluminum, "ingotAluminum"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotSteel, "ingotSteel"));
        updateActions.add(new ReplaceFurnaceOutputAction(new ItemStack(BrItems.ingotYellorium), "ingotUranium"));

        //NUGGETS
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.nuggetBronze, "nuggetBronze"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.nuggetSteel, "nuggetSteel"));

        //ORES
        updateActions.add(new ReplaceFurnaceOutputAction(BlockOre.oreCopper, "oreCopper"));
        updateActions.add(new ReplaceFurnaceOutputAction(BlockOre.oreTin, "oreTin"));
        updateActions.add(new ReplaceFurnaceOutputAction(BlockOre.oreLead, "oreLead"));
        updateActions.add(new ReplaceFurnaceOutputAction(BlockOre.oreSilver, "oreSilver"));
        updateActions.add(new ReplaceFurnaceOutputAction(BlockOre.oreNickel, "oreNickel"));
        updateActions.add(new ReplaceFurnaceOutputAction(BlockOre.oreAluminum, "oreAluminum"));
        updateActions.add(new ReplaceFurnaceOutputAction(BlockOre.orePlatinum, "orePlatinum"));
        updateActions.add(new ReplaceFurnaceOutputAction(BlockOre.oreIridium, "oreIridium"));
    }
}
