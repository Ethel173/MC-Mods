package com.Ethel.RedStonePerfPack;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = RSPP.MODID, name = RSPP.MODNAME, version = RSPP.VERSION)
public class RSPP {

    public static final String MODID = "RSPP";
    public static final String MODNAME = "RedStonePerfPack";
    public static final String VERSION = "1.52R-ZLL";

    @EventHandler
    public void init(FMLInitializationEvent e) {
    	Blocks.REDSTONE_WIRE.setLightLevel((float) 0.3);
		
		Blocks.REDSTONE_ORE.setLightLevel(0);
		Blocks.LIT_REDSTONE_ORE.setLightLevel(0);
		
		Blocks.REDSTONE_TORCH.setLightLevel((float) 0.3);
		Blocks.UNLIT_REDSTONE_TORCH.setLightLevel((float) 0.3);
		
		Blocks.POWERED_REPEATER.setLightLevel((float) 0.3);
		Blocks.UNPOWERED_REPEATER.setLightLevel((float) 0.3);
		
		Blocks.POWERED_COMPARATOR.setLightLevel((float) 0.3);
		Blocks.UNPOWERED_COMPARATOR.setLightLevel((float) 0.3);
    }
}