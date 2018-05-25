package com.mods.combatzak.mojo.alchemism;

import blusunrize.immersiveengineering.api.IEApi;
import blusunrize.immersiveengineering.api.crafting.ArcFurnaceRecipe;
import com.mods.combatzak.mojo.alchemism.UpdateManagers.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Handles initialization
 *
 * Created by CombatZAK on 4/19/2018.
 */
public class CommonProxy {
    public void registerInitActions() {
        OreDictionaryUpdateManager.getInstance().applyUpdates();
    }

    /**
     * Occurs during post-load; applies all action categories
     */
    public void registerActions() {
        System.out.println("LOADING UPDATES");
        CraftingUpdateManager.getInstance().applyUpdates();
        FurnaceUpdateManager.getInstance().applyUpdates();
        PulverizerUpdateManager.getInstance().applyUpdates();
        RedstoneFurnaceUpdateManager.getInstance().applyUpdates();
        InductionSmelterUpdateManager.getInstance().applyUpdates();
        CentrifugalSeperatorUpdateManager.getInstance().applyUpdates();
        EnsorcellatorUpdateManager.getInstance().applyUpdates();

        MaceratorUpdateManager.getInstance().applyUpdates();
        CompressorUpdateManager.getInstance().applyUpdates();
        ThermalCentrifugeUpdateManager.getInstance().applyUpdates();
        BlastFurnaceUpdateManager.getInstance().applyUpdates();

        ForestryCentrifugeUpdateManager.getInstance().applyUpdates();
        SqueezerUpdateManager.getInstance().applyUpdates();

        CrusherUpdateManager.getInstance().applyUpdates();
        EnrichmentChamberUpdateManager.getInstance().applyUpdates();
        MetallurgicInfuserUpdateManager.getInstance().applyUpdates();

        GrinderUpdateManager.getInstance().applyUpdates();

        AlloyKilnUpdateManager.getInstance().applyUpdates();
        ArcFurnaceUpdateManager.getInstance().applyUpdates();
        CokeOvenUpdateManager.getInstance().applyUpdates();
        IeBlastFurnaceUpdateManager.getInstance().applyUpdates();

        TestUpdateManager.getInstance().applyUpdates();
    }
}
